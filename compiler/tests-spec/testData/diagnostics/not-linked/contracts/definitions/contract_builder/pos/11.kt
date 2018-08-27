// !LANGUAGE: +AllowContractsForCustomFunctions +UseCallsInPlaceEffect
// !DIAGNOSTICS: -INVISIBLE_REFERENCE -INVISIBLE_MEMBER -UNUSED_VARIABLE -UNUSED_PARAMETER -UNREACHABLE_CODE -UNUSED_EXPRESSION
// !WITH_BASIC_TYPES

/*
 KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (POSITIVE)

 SECTION: Contracts
 CATEGORY: definitions, contract_builder
 NUMBER: 11
 DESCRIPTION: contract functions is not top-level
 UNEXPECTED BEHAVIOUR
 ISSUES: KT-26149
 */

import kotlin.internal.contracts.*

fun <T> T?.case_3() {
    fun <K> K?.case_3_1(): Boolean {
        contract { returns(true) implies (this@case_3 != null) }
        return this@case_3 != null
    }
}
