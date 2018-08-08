/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.spec

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiFile
import java.io.File

class ParsingSpecTestValidator(testDataFile: File) : SpecTestValidator(testDataFile, TestArea.PSI) {
    constructor(testDataFile: String) : this(File(testDataFile))

    private fun checkErrorElement(psi: PsiElement): Boolean =
        psi.children.any { it is PsiErrorElement || checkErrorElement(it) }

    private fun computeTestType(psiFile: PsiFile): TestType {
        return if (checkErrorElement(psiFile)) TestType.NEGATIVE else TestType.POSITIVE
    }

    fun validateTestType(psiFile: PsiFile) {
        validateTestType(computeTestType(psiFile))
    }
}