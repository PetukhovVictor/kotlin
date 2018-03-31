/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.checkers.javac;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@RunWith(JUnit3RunnerWithInners.class)
public class JavacFieldResolutionTestGenerated extends AbstractJavacFieldResolutionTest {
    @TestMetadata("compiler/testData/javac/fieldsResolution/tests")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Tests extends AbstractJavacFieldResolutionTest {
        public void testAllFilesPresentInTests() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/javac/fieldsResolution/tests"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true);
        }

        @TestMetadata("AsteriskStaticImportsAmbiguity.kt")
        public void testAsteriskStaticImportsAmbiguity() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/AsteriskStaticImportsAmbiguity.kt");
            doTest(fileName);
        }

        @TestMetadata("BinaryInitializers.kt")
        public void testBinaryInitializers() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/BinaryInitializers.kt");
            doTest(fileName);
        }

        @TestMetadata("ConstantByFqName.kt")
        public void testConstantByFqName() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/ConstantByFqName.kt");
            doTest(fileName);
        }

        @TestMetadata("ConstantValues.kt")
        public void testConstantValues() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/ConstantValues.kt");
            doTest(fileName);
        }

        @TestMetadata("ConstantValuesFromKtFile.kt")
        public void testConstantValuesFromKtFile() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/ConstantValuesFromKtFile.kt");
            doTest(fileName);
        }

        @TestMetadata("FieldFromOuterClass.kt")
        public void testFieldFromOuterClass() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/FieldFromOuterClass.kt");
            doTest(fileName);
        }

        @TestMetadata("InheritedField.kt")
        public void testInheritedField() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/InheritedField.kt");
            doTest(fileName);
        }

        @TestMetadata("MultipleOuters.kt")
        public void testMultipleOuters() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/MultipleOuters.kt");
            doTest(fileName);
        }

        @TestMetadata("ResolutionPriority.kt")
        public void testResolutionPriority() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/ResolutionPriority.kt");
            doTest(fileName);
        }

        @TestMetadata("SameFieldInSupertypes.kt")
        public void testSameFieldInSupertypes() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/SameFieldInSupertypes.kt");
            doTest(fileName);
        }

        @TestMetadata("StaticImport.kt")
        public void testStaticImport() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/StaticImport.kt");
            doTest(fileName);
        }

        @TestMetadata("StaticImportsAmbiguity.kt")
        public void testStaticImportsAmbiguity() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/StaticImportsAmbiguity.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("compiler/testData/javac/fieldsResolution/tests")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class TestsWithoutJavac extends AbstractJavacFieldResolutionTest {
        public void testAllFilesPresentInTestsWithoutJavac() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/javac/fieldsResolution/tests"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true);
        }

        @TestMetadata("AsteriskStaticImportsAmbiguity.kt")
        public void testAsteriskStaticImportsAmbiguity() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/AsteriskStaticImportsAmbiguity.kt");
            doTestWithoutJavacWrapper(fileName);
        }

        @TestMetadata("BinaryInitializers.kt")
        public void testBinaryInitializers() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/BinaryInitializers.kt");
            doTestWithoutJavacWrapper(fileName);
        }

        @TestMetadata("ConstantByFqName.kt")
        public void testConstantByFqName() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/ConstantByFqName.kt");
            doTestWithoutJavacWrapper(fileName);
        }

        @TestMetadata("ConstantValues.kt")
        public void testConstantValues() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/ConstantValues.kt");
            doTestWithoutJavacWrapper(fileName);
        }

        @TestMetadata("ConstantValuesFromKtFile.kt")
        public void testConstantValuesFromKtFile() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/ConstantValuesFromKtFile.kt");
            doTestWithoutJavacWrapper(fileName);
        }

        @TestMetadata("FieldFromOuterClass.kt")
        public void testFieldFromOuterClass() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/FieldFromOuterClass.kt");
            doTestWithoutJavacWrapper(fileName);
        }

        @TestMetadata("InheritedField.kt")
        public void testInheritedField() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/InheritedField.kt");
            doTestWithoutJavacWrapper(fileName);
        }

        @TestMetadata("MultipleOuters.kt")
        public void testMultipleOuters() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/MultipleOuters.kt");
            doTestWithoutJavacWrapper(fileName);
        }

        @TestMetadata("ResolutionPriority.kt")
        public void testResolutionPriority() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/ResolutionPriority.kt");
            doTestWithoutJavacWrapper(fileName);
        }

        @TestMetadata("SameFieldInSupertypes.kt")
        public void testSameFieldInSupertypes() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/SameFieldInSupertypes.kt");
            doTestWithoutJavacWrapper(fileName);
        }

        @TestMetadata("StaticImport.kt")
        public void testStaticImport() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/StaticImport.kt");
            doTestWithoutJavacWrapper(fileName);
        }

        @TestMetadata("StaticImportsAmbiguity.kt")
        public void testStaticImportsAmbiguity() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/javac/fieldsResolution/tests/StaticImportsAmbiguity.kt");
            doTestWithoutJavacWrapper(fileName);
        }
    }
}
