/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.navigation;

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
@TestMetadata("idea/testData/navigation/gotoTypeDeclaration")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class GotoTypeDeclarationTestGenerated extends AbstractGotoTypeDeclarationTest {
    public void testAllFilesPresentInGotoTypeDeclaration() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/testData/navigation/gotoTypeDeclaration"), Pattern.compile("^(.+)\\.test$"), TargetBackend.ANY, true);
    }

    @TestMetadata("builtinTypeStdlib.test")
    public void testBuiltinTypeStdlib() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/builtinTypeStdlib.test");
        doTest(fileName);
    }

    @TestMetadata("explicitParameterInLambda.test")
    public void testExplicitParameterInLambda() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/explicitParameterInLambda.test");
        doTest(fileName);
    }

    @TestMetadata("fromFunctionDeclarationName.test")
    public void testFromFunctionDeclarationName() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/fromFunctionDeclarationName.test");
        doTest(fileName);
    }

    @TestMetadata("fromFunctionDeclarationReturn.test")
    public void testFromFunctionDeclarationReturn() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/fromFunctionDeclarationReturn.test");
        doTest(fileName);
    }

    @TestMetadata("fromFunctionDeclrationExtension.test")
    public void testFromFunctionDeclrationExtension() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/fromFunctionDeclrationExtension.test");
        doTest(fileName);
    }

    @TestMetadata("functionCall.test")
    public void testFunctionCall() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/functionCall.test");
        doTest(fileName);
    }

    @TestMetadata("itExtensionLambda.test")
    public void testItExtensionLambda() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/itExtensionLambda.test");
        doTest(fileName);
    }

    @TestMetadata("itParameterInLambda.test")
    public void testItParameterInLambda() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/itParameterInLambda.test");
        doTest(fileName);
    }

    @TestMetadata("noParametersLambda.test")
    public void testNoParametersLambda() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/noParametersLambda.test");
        doTest(fileName);
    }

    @TestMetadata("thisExtensionFunction.test")
    public void testThisExtensionFunction() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/thisExtensionFunction.test");
        doTest(fileName);
    }

    @TestMetadata("thisExtensionFunctionWithAnnotationOnReceiver.test")
    public void testThisExtensionFunctionWithAnnotationOnReceiver() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/thisExtensionFunctionWithAnnotationOnReceiver.test");
        doTest(fileName);
    }

    @TestMetadata("thisExtensionFunctionWithGenericReceiver.test")
    public void testThisExtensionFunctionWithGenericReceiver() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/thisExtensionFunctionWithGenericReceiver.test");
        doTest(fileName);
    }

    @TestMetadata("thisExtensionLambda.test")
    public void testThisExtensionLambda() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/thisExtensionLambda.test");
        doTest(fileName);
    }

    @TestMetadata("thisInExtensionPropertyAccessor.test")
    public void testThisInExtensionPropertyAccessor() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/thisInExtensionPropertyAccessor.test");
        doTest(fileName);
    }

    @TestMetadata("variableType.test")
    public void testVariableType() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("idea/testData/navigation/gotoTypeDeclaration/variableType.test");
        doTest(fileName);
    }
}
