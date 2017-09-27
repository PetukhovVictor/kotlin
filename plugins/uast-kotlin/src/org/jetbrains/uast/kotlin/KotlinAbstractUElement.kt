/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.uast.kotlin

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.getStrictParentOfType
import org.jetbrains.uast.*

abstract class KotlinAbstractUElement(private val givenParent: UElement?) : UElement {

    override val uastParent: UElement? by lz {
        givenParent ?: convertParent()
    }

    protected open fun convertParent(): UElement? {
        var parent = psi?.parent ?: psi?.containingFile

        if (parent is KtStringTemplateExpression && parent.entries.size == 1) {
            parent = parent.parent
        }

        val result = doConvertParent(this, parent)
        if (result == this) {
            throw IllegalStateException("Loop in parent structure when converting a $psi")
        }

        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other !is UElement) {
            return false
        }

        return this.psi == other.psi
    }

    override fun hashCode() = psi?.hashCode() ?: 0
}

fun doConvertParent(element: UElement, parent: PsiElement?): UElement? {
    val parentUnwrapped = KotlinConverter.unwrapElements(parent) ?: return null
    if (parent is KtValueArgument && parentUnwrapped is KtAnnotationEntry) {
        return (KotlinUastLanguagePlugin().convertElementWithParent(parentUnwrapped, null) as? KotlinUAnnotation)
            ?.findAttributeValueExpression(parent)
    }

    if (parent is KtParameter) {
        val annotationClass = findAnnotationClassFromConstructorParameter(parent)
        if (annotationClass != null) {
            return annotationClass.methods.find { it.name == parent.name }
        }
    }

    val result = KotlinUastLanguagePlugin().convertElementWithParent(parentUnwrapped, null)

    if (result is UEnumConstant && element is UDeclaration) {
        return result.initializingClass
    }
    return result
}

private fun findAnnotationClassFromConstructorParameter(parameter: KtParameter): UClass? {
    val primaryConstructor = parameter.getStrictParentOfType<KtPrimaryConstructor>() ?: return null
    val containingClass = primaryConstructor.getContainingClassOrObject()
    if (containingClass.isAnnotation()) {
        return KotlinUastLanguagePlugin().convertElementWithParent(containingClass, null) as UClass
    }
    return null
}

abstract class KotlinAbstractUExpression(givenParent: UElement?)
    : KotlinAbstractUElement(givenParent), UExpression {

    override val annotations: List<UAnnotation>
        get() {
            val annotatedExpression = psi?.parent as? KtAnnotatedExpression ?: return emptyList()
            return annotatedExpression.annotationEntries.map { KotlinUAnnotation(it, this) }
        }
}

