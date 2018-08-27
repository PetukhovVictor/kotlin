// !LANGUAGE: +AllowContractsForCustomFunctions +UseCallsInPlaceEffect
// !DIAGNOSTICS: -INVISIBLE_REFERENCE -INVISIBLE_MEMBER -UNUSED_VARIABLE -UNUSED_PARAMETER -UNREACHABLE_CODE -UNUSED_EXPRESSION

/*
 KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (POSITIVE)

 SECTION: Contracts
 CATEGORY: definitions, contract_builder
 NUMBER: 9
 DESCRIPTION: smartcasts in implies
 */

import kotlin.internal.contracts.*

// CASE DESCRIPTION: assignment statement before contract description
fun case_1(value_1: Boolean?): Boolean {
    contract { returns(true) implies (value_1 != null && !<!DEBUG_INFO_SMARTCAST!>value_1<!>) }
    return true
}

// CASE DESCRIPTION: expression before contract description
fun Boolean.case_2(value_1: Any?): Boolean {
    contract { returnsNotNull() implies (value_1 is Boolean? && value_1 != null && <!DEBUG_INFO_SMARTCAST!>value_1<!>) }
    return true
}

// CASE DESCRIPTION: expression before contract description
fun Boolean?.case_3(): Boolean {
    contract { returnsNotNull() implies (this@case_3 != null && <!DEBUG_INFO_SMARTCAST!>this@case_3<!>) }
    return true
}

// CASE DESCRIPTION: expression before contract description
fun <T : Boolean?> T.case_3(value_1: Any?): Boolean {
    contract { returnsNotNull() implies (value_1 is Boolean? && value_1 != null && <!DEBUG_INFO_SMARTCAST!>value_1<!> && this@case_3 != null && <!DEBUG_INFO_SMARTCAST!>this@case_3<!>) }
    return true
}
