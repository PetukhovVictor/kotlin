import java.util.regex.Pattern

plugins {
    kotlin("jvm")
    id("jps-compatible")
}

dependencies {
    testCompile(project(":core:descriptors"))
    testCompile(project(":core:descriptors.jvm"))
    testCompile(project(":core:deserialization"))
    testCompile(project(":compiler:util"))
    testCompile(project(":compiler:backend"))
    testCompile(project(":compiler:ir.ir2cfg"))
    testCompile(project(":compiler:frontend"))
    testCompile(project(":compiler:frontend.java"))
    testCompile(project(":compiler:util"))
    testCompile(project(":compiler:cli-common"))
    testCompile(project(":compiler:cli"))
    testCompile(project(":compiler:light-classes"))
    testCompile(project(":compiler:serialization"))
    testCompile(project(":kotlin-preloader"))
    testCompile(project(":compiler:daemon-common"))
    testCompile(project(":js:js.serializer"))
    testCompile(project(":js:js.frontend"))
    testCompile(project(":js:js.translator"))
    testCompileOnly(project(":plugins:android-extensions-compiler"))
    testCompile(projectDist(":kotlin-test:kotlin-test-jvm"))
    testCompile(projectTests(":compiler:tests-common-jvm6"))
    testCompileOnly(project(":kotlin-reflect-api"))
    testCompile(commonDep("junit:junit"))
    testCompile(androidDxJar()) { isTransitive = false }
    testCompile(intellijCoreDep()) { includeJars("intellij-core"); isTransitive = false }
    testCompile(intellijDep()) {
        includeJars("openapi", "platform-api", "platform-impl", "idea", "idea_rt", "guava", "trove4j", "picocontainer", "asm-all", "log4j", "jdom", "bootstrap", "annotations", rootProject = rootProject)
        isTransitive = false
    }
}

sourceSets {
    "main" { }
    "test" { projectDefault() }
}

testsJar {}

task("printSpecTestStatistic") {
    val testDataDir = "../testData"
    val specTestsDir = "testsSpec"
    val specTestAreas = listOf("diagnostics", "psi", "codegen")
    val integerRegex = "[1-9]\\d*"
    val testPathRegex =
        "s-(?<sectionNumber>(?:$integerRegex)(?:\\.$integerRegex)*)_(?<sectionName>[\\w-]+)/p-(?<paragraphNumber>$integerRegex)/(?<testType>pos|neg)/(?<sentenceNumber>$integerRegex)\\.(?<testNumber>$integerRegex)\\.kt$"

    abstract class StatElement {
        var counter = 0
        abstract val elements: MutableMap<out Any, out StatElement>?
        abstract fun increment()
    }

    class TestTypeStat(private val paragraph: StatElement): StatElement() {
        override val elements = null
        override fun increment() {
            counter++
            paragraph.increment()
        }
    }

    class ParagraphStat(private val section: StatElement): StatElement() {
        override val elements: MutableMap<String, TestTypeStat>? = sortedMapOf()
        override fun increment() {
            counter++
            section.increment()
        }
    }

    class SectionStat(private val area: StatElement): StatElement() {
        override val elements: MutableMap<Int, ParagraphStat>? = sortedMapOf()
        override fun increment() {
            counter++
            area.increment()
        }
    }

    class AreaStat: StatElement() {
        override val elements: MutableMap<String, SectionStat>? = sortedMapOf()
        override fun increment() {
            counter++
        }
    }

    fun printStat(statistic: MutableMap<String, AreaStat>, depth: Int = 0) {
        statistic.forEach {
            println("${it.key.toUpperCase()} TESTS: ${it.value.counter}")

            it.value.elements!!.forEach {
                println("  ${it.key.toUpperCase()}: ${it.value.counter}")

                it.value.elements!!.forEach {
                    val testTypes = mutableListOf<String>()

                    it.value.elements!!.forEach {
                        testTypes.add("${it.key}: ${it.value.counter}")
                    }

                    println("    ${it.key} PARAGRAPH: ${it.value.counter} (${testTypes.joinToString(", ")})")
                }
            }
        }
    }

    fun incrementStatCounters(testAreaStats: AreaStat, sectionName: String, paragraphNumber: Int, testType: String) {
        val section = testAreaStats.elements!!.computeIfAbsent(sectionName) { SectionStat(testAreaStats) }
        val paragraph = section.elements!!.computeIfAbsent(paragraphNumber) { ParagraphStat(section) }

        paragraph.elements!!.computeIfAbsent(testType) { TestTypeStat(paragraph) }.increment()
    }

    println("--------------------------------------------------")
    println("SPEC TESTS STATISTIC")
    println("--------------------------------------------------")

    val statistic: MutableMap<String, AreaStat> = mutableMapOf()

    specTestAreas.forEach {
        val specTestType = it
        val specTestsPath = "$testDataDir/$specTestType/$specTestsDir"

        statistic[specTestType] = AreaStat()

        File(specTestsPath).walkTopDown().forEach areaTests@{
            if (!it.isFile || it.extension != "kt") {
                return@areaTests
            }

            val testInfoMatcher = Pattern.compile(testPathRegex).matcher(it.path)

            if (!testInfoMatcher.find()) {
                return@areaTests
            }

            val sectionNumber = testInfoMatcher.group("sectionNumber")
            val sectionName = testInfoMatcher.group("sectionName")
            val paragraphNumber = testInfoMatcher.group("paragraphNumber").toInt()
            val testType = testInfoMatcher.group("testType")
            val section = "$sectionNumber $sectionName"

            incrementStatCounters(statistic[specTestType]!!, section, paragraphNumber, testType)
        }
    }

    printStat(statistic)

    println("--------------------------------------------------")
}