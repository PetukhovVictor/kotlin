/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.checkers;

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
@TestMetadata("compiler/testData/foreignAnnotationsJava8/tests")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class ForeignJava8AnnotationsNoAnnotationInClasspathTestGenerated extends AbstractForeignJava8AnnotationsNoAnnotationInClasspathTest {
    public void testAllFilesPresentInTests() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/foreignAnnotationsJava8/tests"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true);
    }

    @TestMetadata("checkerFramework.kt")
    public void testCheckerFramework() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/checkerFramework.kt");
        doTest(fileName);
    }

    @TestMetadata("eclipse.kt")
    public void testEclipse() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/eclipse.kt");
        doTest(fileName);
    }

    @TestMetadata("typeUseOnObject.kt")
    public void testTypeUseOnObject() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/typeUseOnObject.kt");
        doTest(fileName);
    }

    @TestMetadata("compiler/testData/foreignAnnotationsJava8/tests/jsr305")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Jsr305 extends AbstractForeignJava8AnnotationsNoAnnotationInClasspathTest {
        public void testAllFilesPresentInJsr305() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/foreignAnnotationsJava8/tests/jsr305"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true);
        }

        @TestMetadata("defaultAnnotationAppliedToType.kt")
        public void testDefaultAnnotationAppliedToType() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/jsr305/defaultAnnotationAppliedToType.kt");
            doTest(fileName);
        }

        @TestMetadata("defaultAnnotationAppliedToTypeForCompiledJava.kt")
        public void testDefaultAnnotationAppliedToTypeForCompiledJava() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/jsr305/defaultAnnotationAppliedToTypeForCompiledJava.kt");
            doTest(fileName);
        }

        @TestMetadata("springNullableWithTypeUse.kt")
        public void testSpringNullableWithTypeUse() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/jsr305/springNullableWithTypeUse.kt");
            doTest(fileName);
        }

        @TestMetadata("typeArguments.kt")
        public void testTypeArguments() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/jsr305/typeArguments.kt");
            doTest(fileName);
        }

        @TestMetadata("typeUseVsMethodConflict.kt")
        public void testTypeUseVsMethodConflict() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/jsr305/typeUseVsMethodConflict.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("compiler/testData/foreignAnnotationsJava8/tests/typeEnhancement")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class TypeEnhancement extends AbstractForeignJava8AnnotationsNoAnnotationInClasspathTest {
        public void testAllFilesPresentInTypeEnhancement() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/foreignAnnotationsJava8/tests/typeEnhancement"), Pattern.compile("^(.+)\\.kt$"), TargetBackend.ANY, true);
        }

        @TestMetadata("annotatedTypeArguments.kt")
        public void testAnnotatedTypeArguments() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/typeEnhancement/annotatedTypeArguments.kt");
            doTest(fileName);
        }

        @TestMetadata("methodWithTypeParameter.kt")
        public void testMethodWithTypeParameter() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/typeEnhancement/methodWithTypeParameter.kt");
            doTest(fileName);
        }

        @TestMetadata("notNullVarargsOverrides.kt")
        public void testNotNullVarargsOverrides() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/typeEnhancement/notNullVarargsOverrides.kt");
            doTest(fileName);
        }

        @TestMetadata("nullableVarargsOverrides.kt")
        public void testNullableVarargsOverrides() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/typeEnhancement/nullableVarargsOverrides.kt");
            doTest(fileName);
        }

        @TestMetadata("returnTypeDifferentConstructor.kt")
        public void testReturnTypeDifferentConstructor() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/typeEnhancement/returnTypeDifferentConstructor.kt");
            doTest(fileName);
        }

        @TestMetadata("returnTypeOverrideInKotlin.kt")
        public void testReturnTypeOverrideInKotlin() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/typeEnhancement/returnTypeOverrideInKotlin.kt");
            doTest(fileName);
        }

        @TestMetadata("simple.kt")
        public void testSimple() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/foreignAnnotationsJava8/tests/typeEnhancement/simple.kt");
            doTest(fileName);
        }
    }
}
