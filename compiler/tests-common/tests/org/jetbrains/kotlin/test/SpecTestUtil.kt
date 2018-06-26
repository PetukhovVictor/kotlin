/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.test

import org.jetbrains.kotlin.checkers.BaseDiagnosticsTest
import org.jetbrains.kotlin.diagnostics.Diagnostic
import org.jetbrains.kotlin.diagnostics.Severity
import java.io.File
import java.util.regex.Matcher
import java.util.regex.Pattern

enum class TestType(val type: String) {
    POSITIVE("pos"),
    NEGATIVE("neg");

    companion object {
        private val map = TestType.values().associateBy(TestType::type)
        fun fromValue(type: String) = map[type]
    }
}

enum class TestArea(val title: String) {
    PARSING("PARSING"),
    DIAGNOSTIC("DIAGNOSTIC"),
    BLACKBOX("BLACK BOX")
}

data class TestInfo(
    val testType: TestType,
    val sectionNumber: String,
    val sectionName: String,
    val paragraphNumber: Int,
    val sentenceNumber: Int,
    val sentence: String? = null,
    val testNumber: Int,
    val description: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TestInfo) return false

        return this.testType == other.testType && this.sectionNumber == other.sectionNumber && this.testNumber == other.testNumber && this.paragraphNumber == other.paragraphNumber && this.sentenceNumber == other.sentenceNumber
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}

enum class SpecTestValidationFailedReason(val description: String) {
    FILENAME_NOT_VALID(
        "Incorrect test filename or folder name.\n" +
                "It must match the following path pattern: " +
                "testsSpec/s<sectionNumber>_<sectionName>/p<paragraph>s<sentence>_<pos|neg>.kt " +
                "(example: testsSpec/s16.30:when-expression/1:1-pos.kt)"
    ),
    METAINFO_NOT_VALID("Incorrect meta info in test file."),
    FILENAME_AND_METAINFO_NOT_CONSISTENCY("Test info from filename and file content is not consistency"),
    NOT_PARSED("Test info not parsed. You must call parseTestInfo before test info printing."),
    DIAGNOSTIC_NOT_COLLECTED("Diagnostics not collected from the test file. You must call collectAllDiagnostics."),
    TEST_IS_NOT_POSITIVE("Test is not positive because it contains diagnostics with ERROR severity."),
    TEST_IS_NOT_NEGATIVE("Test is not negative because it not contains diagnostics with ERROR severity."),
    UNKNOWN("Unknown validation error.")
}

class SpecTestValidationException(val reason: SpecTestValidationFailedReason) : Exception()

abstract class SpecTestValidator(private val testDataFile: File, private val testArea: TestArea) {
    private lateinit var testInfoByFilename: TestInfo
    private lateinit var testInfoByContent: TestInfo
    protected val testInfo by lazy { testInfoByContent }

    companion object {
        const val specUrl = "https://petukhovvictor.github.io/kotlin-spec"

        private const val integerRegex = "[1-9]\\d*"
        private const val testPathRegex =
            "^.*?/s(?<sectionNumber>(?:$integerRegex)(?:\\.$integerRegex)*):(?<sectionName>[\\w-]+)/(?<paragraphNumber>$integerRegex).(?<sentenceNumber>$integerRegex).(?<testNumber>$integerRegex)-(?<testType>pos|neg)\\.kt$"
        private const val testContentMetaInfoRegex =
            "\\/\\*\\s+KOTLIN SPEC TEST \\((?<testType>POSITIVE|NEGATIVE)\\)\\s+SECTION (?<sectionNumber>(?:$integerRegex)(?:\\.$integerRegex)*):\\s*(?<sectionName>.*?)\\s+PARAGRAPH:\\s*(?<paragraphNumber>$integerRegex)\\s+SENTENCE\\s*(?<sentenceNumber>$integerRegex):\\s*(?<sentence>.*?)\\s+NUMBER:\\s*(?<testNumber>$integerRegex)\\s+DESCRIPTION:\\s*(?<testDescription>.*?)\\s+\\*\\/\\s+"

        private fun getTestInfo(testInfoMatcher: Matcher, directMappedTestTypeEnum: Boolean = false, withDetails: Boolean = false): TestInfo {
            return TestInfo(
                if (directMappedTestTypeEnum)
                    TestType.valueOf(testInfoMatcher.group("testType")) else
                    TestType.fromValue(testInfoMatcher.group("testType"))!!,
                testInfoMatcher.group("sectionNumber"),
                testInfoMatcher.group("sectionName"),
                testInfoMatcher.group("paragraphNumber").toInt(),
                testInfoMatcher.group("sentenceNumber").toInt(),
                if (withDetails) testInfoMatcher.group("sentence") else null,
                testInfoMatcher.group("testNumber").toInt(),
                if (withDetails) testInfoMatcher.group("testDescription") else null
            )
        }

        private fun getTestFileWithoutMetaInfo(testInfoByContentMatcher: Matcher): File {
            val testFileContentWithoutMetaInfo = testInfoByContentMatcher.replaceAll("")
            val tempFile = createTempFile()
            tempFile.writeText(testFileContentWithoutMetaInfo)

            return tempFile
        }
    }

    fun parseTestInfo() {
        val testInfoByFilenameMatcher = Pattern.compile(testPathRegex).matcher(testDataFile.path)

        if (!testInfoByFilenameMatcher.find()) {
            throw SpecTestValidationException(SpecTestValidationFailedReason.FILENAME_NOT_VALID)
        }

        val testInfoByContentMatcher = Pattern.compile(testContentMetaInfoRegex).matcher(testDataFile.readText())

        if (!testInfoByContentMatcher.find()) {
            throw SpecTestValidationException(SpecTestValidationFailedReason.METAINFO_NOT_VALID)
        }

        testInfoByFilename = getTestInfo(testInfoByFilenameMatcher)
        testInfoByContent = getTestInfo(testInfoByContentMatcher, withDetails = true, directMappedTestTypeEnum = true)

        if (testInfoByFilename != testInfoByContent) {
            throw SpecTestValidationException(SpecTestValidationFailedReason.FILENAME_AND_METAINFO_NOT_CONSISTENCY)
        }
    }

    fun printTestInfo() {
        if (!this::testInfoByContent.isInitialized || !this::testInfoByFilename.isInitialized) {
            throw SpecTestValidationException(SpecTestValidationFailedReason.NOT_PARSED)
        }

        val specSentenceUrl =
            "$specUrl#${testInfoByFilename.sectionName}:${testInfoByFilename.paragraphNumber}:${testInfoByFilename.sentenceNumber}"

        println("-------------------------")
        println("${testArea.title} SPEC TEST IS RUNNING [${testInfoByFilename.testType}]")
        println("SECTION: ${testInfoByFilename.sectionNumber} ${testInfoByContent.sectionName} (paragraph: ${testInfoByFilename.paragraphNumber})")
        println("SENTENCE ${testInfoByContent.sentenceNumber} [$specSentenceUrl]: ${testInfoByContent.sentence}")
        println("TEST NUMBER: ${testInfoByContent.testNumber}")
        println("DESCRIPTION: ${testInfoByContent.description}")
    }
}

class DiagnosticSpecTestValidator(private val testDataFile: File) : SpecTestValidator(testDataFile, TestArea.DIAGNOSTIC) {
    private lateinit var diagnostics: MutableList<Diagnostic>
    private lateinit var diagnosticSeverityStats: MutableMap<Severity, Int>

    private fun collectDiagnosticStatistic() {
        diagnosticSeverityStats = mutableMapOf()

        diagnostics.forEach {
            if (diagnosticSeverityStats.contains(it.severity)) {
                diagnosticSeverityStats[it.severity] = diagnosticSeverityStats[it.severity]!! + 1
            } else {
                diagnosticSeverityStats[it.severity] = 1
            }
        }
    }

    private fun computeTestType(): TestType {
        return if (Severity.ERROR in diagnosticSeverityStats) TestType.NEGATIVE else TestType.POSITIVE
    }

    fun printSeverityStatistic() {
        println("DIAGNOSTICS: $diagnosticSeverityStats")
    }

    fun collectDiagnostics(files: List<BaseDiagnosticsTest.TestFile>) {
        diagnostics = mutableListOf()

        files.forEach {
            it.actualDiagnostics.forEach {
                diagnostics.add(it.diagnostic)
            }
        }

        collectDiagnosticStatistic()
    }

    fun validateTestType() {
        if (!this::diagnostics.isInitialized) {
            throw SpecTestValidationException(SpecTestValidationFailedReason.DIAGNOSTIC_NOT_COLLECTED)
        }

        val computedTestType = computeTestType()

        if (computedTestType != testInfo.testType) {
            val isNotNegative = computedTestType == TestType.POSITIVE && testInfo.testType == TestType.NEGATIVE
            val isNotPositive = computedTestType == TestType.NEGATIVE && testInfo.testType == TestType.POSITIVE
            val reason: SpecTestValidationFailedReason

            when {
                isNotNegative -> reason = SpecTestValidationFailedReason.TEST_IS_NOT_NEGATIVE
                isNotPositive -> reason = SpecTestValidationFailedReason.TEST_IS_NOT_POSITIVE
                else -> reason = SpecTestValidationFailedReason.UNKNOWN
            }

            printSeverityStatistic()

            throw SpecTestValidationException(reason)
        }
    }
}