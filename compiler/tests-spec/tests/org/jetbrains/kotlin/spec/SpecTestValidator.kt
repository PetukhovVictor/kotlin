/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.spec

import java.io.File
import java.util.regex.Matcher
import java.util.regex.Pattern

enum class SpecTestFileInfoElementType(
    override val valuePattern: Pattern? = null,
    override val required: Boolean = false
) : SpecTestInfoElementType {
    SECTION(
        valuePattern = Pattern.compile("""(?<number>(?:${AbstractSpecTestValidator.INTEGER_REGEX})(?:\.${AbstractSpecTestValidator.INTEGER_REGEX})*)(?<name>.*?)"""),
        required = true
    ),
    PARAGRAPH(required = true),
    SENTENCE(
        valuePattern = Pattern.compile("""\[(?<number>${AbstractSpecTestValidator.INTEGER_REGEX})\](?<text>.*?)"""),
        required = true
    ),
    NUMBER(required = true),
    DESCRIPTION(required = true),
    ISSUES(valuePattern = Pattern.compile("""(KT-[1-9]\d*)(,\s*KT-[1-9]\d*)*""")),
    UNEXPECTED_BEHAVIOUR,
    DISCUSSION,
    NOTE
}

class SpecTest(
    testArea: TestArea,
    testType: TestType,
    val sectionNumber: String,
    sectionName: String,
    val paragraphNumber: Int,
    val sentenceNumber: Int,
    val sentence: String? = null,
    testNumber: Int,
    description: String? = null,
    cases: List<SpecTestCase>? = null,
    unexpectedBehavior: Boolean? = null,
    issues: Set<String>? = null
) : AbstractSpecTest(testArea, testType, sectionName, testNumber, description, cases, unexpectedBehavior, issues) {
    override fun checkConsistency(other: AbstractSpecTest) =
        if (other is SpecTest) checkConsistency(other) else false

    private fun checkConsistency(other: SpecTest): Boolean {
        return this.testArea == other.testArea
                && this.testType == other.testType
                && this.sectionNumber == other.sectionNumber
                && this.testNumber == other.testNumber
                && this.paragraphNumber == other.paragraphNumber
                && this.sentenceNumber == other.sentenceNumber
    }
}

class SpecTestValidator(
    private val testDataFile: File,
    private val testArea: TestArea
) : AbstractSpecTestValidator<SpecTest>(testDataFile, testArea) {
    override val testPathPattern: Pattern =
        Pattern.compile(testPathRegexTemplate.format(pathPartRegex, filenameRegex))
    override val testInfoPattern: Pattern =
        Pattern.compile(MULTILINE_COMMENT_REGEX.format("""KOTLIN $testAreaRegex SPEC TEST \($testTypeRegex\)\n(?<infoElements>[\s\S]*?\n)"""))

    companion object {
        val pathPartRegex =
            """(?:s-(?<sectionNumber>(?:$INTEGER_REGEX)(?:\.$INTEGER_REGEX)*)_(?<sectionName>[\w-]+)/p-(?<paragraphNumber>$INTEGER_REGEX))"""
        val filenameRegex = """(?<sentenceNumber>$INTEGER_REGEX)\.(?<testNumber>$INTEGER_REGEX)\.kt"""
    }

    override fun getTestInfo(
        testInfoMatcher: Matcher,
        testInfoElements: SpecTestInfoElements<SpecTestInfoElementType>,
        testCases: List<SpecTestCase>,
        unexpectedBehavior: Boolean,
        issues: Set<String>?
    ): SpecTest {
        val sectionMatcher = testInfoElements[SpecTestFileInfoElementType.SECTION]!!.additionalMatcher!!
        val sentenceMatcher = testInfoElements[SpecTestFileInfoElementType.SENTENCE]!!.additionalMatcher!!

        return SpecTest(
            TestArea.valueOf(testInfoMatcher.group("testArea").toUpperCase()),
            TestType.valueOf(testInfoMatcher.group("testType")),
            sectionMatcher.group("number"),
            sectionMatcher.group("name"),
            testInfoElements[SpecTestFileInfoElementType.PARAGRAPH]!!.content.toInt(),
            sentenceMatcher.group("number").toInt(),
            sentenceMatcher.group("text"),
            testInfoElements[SpecTestFileInfoElementType.NUMBER]!!.content.toInt(),
            testInfoElements[SpecTestFileInfoElementType.DESCRIPTION]!!.content,
            testCases,
            unexpectedBehavior,
            issues
        )
    }

    override fun getTestInfo(testInfoMatcher: Matcher): SpecTest {
        return SpecTest(
            TestArea.valueOf(testInfoMatcher.group("testArea").toUpperCase()),
            TestType.fromValue(testInfoMatcher.group("testType"))!!,
            testInfoMatcher.group("sectionNumber"),
            testInfoMatcher.group("sectionName"),
            testInfoMatcher.group("paragraphNumber").toInt(),
            testInfoMatcher.group("sentenceNumber").toInt(),
            testNumber = testInfoMatcher.group("testNumber").toInt()
        )
    }

    override fun parseTestInfo() = parseTestInfo(SpecTestFileInfoElementType.values())

    override fun printTestInfo() {
        println("--------------------------------------------------")
        if (testInfoByContent.unexpectedBehavior!!)
            println("(!!!) HAS UNEXPECTED BEHAVIOUR (!!!)")
        println("$testArea ${testInfoByFilename.testType} SPEC TEST")
        println("SECTION: ${testInfoByFilename.sectionNumber} ${testInfoByContent.sectionName} (paragraph: ${testInfoByFilename.paragraphNumber})")
        println("SENTENCE ${testInfoByContent.sentenceNumber}: ${testInfoByContent.sentence}")
        println("TEST NUMBER: ${testInfoByContent.testNumber}")
        println("NUMBER OF TEST CASES: ${testInfoByContent.cases!!.size}")
        println("DESCRIPTION: ${testInfoByContent.description}")
        if (testInfoByContent.issues!!.isNotEmpty()) {
            println("LINKED ISSUES: ${testInfoByContent.issues!!.joinToString(", ")}")
        }
    }

    override fun getSingleTestCase(testInfoElements: SpecTestInfoElements<SpecTestInfoElementType>) = SpecTestCase(
        1,
        description = testInfoElements[SpecTestFileInfoElementType.DESCRIPTION]!!.content,
        unexpectedBehavior = testInfoElements.contains(SpecTestFileInfoElementType.UNEXPECTED_BEHAVIOUR),
        issues = parseIssues(testInfoElements[SpecTestFileInfoElementType.ISSUES])
    )
}
