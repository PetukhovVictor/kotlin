// !LANGUAGE: +AllowContractsForCustomFunctions +UseReturnsEffect
// !WITH_CONTRACT_FUNCTIONS
// !WITH_BASIC_TYPES
// !DIAGNOSTICS: -INVISIBLE_REFERENCE -INVISIBLE_MEMBER

/*
 KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (POSITIVE)

 SECTION: Contracts
 CATEGORY: analysis, smartcasts
 NUMBER: 9
 DESCRIPTION: Smartcast using more of the various returns effects on the same values.
 */

// FILE: contracts.kt

package contracts

import kotlin.internal.contracts.*

fun <T> T?.case_4(): Boolean {
    contract { returns(true) implies (this@case_4 != null) }
    return this@case_4 != null
}

fun <T> T?.case_4_1(): Boolean {
    contract { returns(false) implies (this@case_4_1 != null) }
    return this@case_4_1 != null
}

fun <T> T?.case_4_2(): Boolean {
    contract { returns(null) implies (this@case_4_2 is String) }
    return this@case_4_2 != null
}

// FILE: usages.kt

import contracts.*

fun case_1(value_1: Any?) {
    if (funWithReturnsTrue(value_1 is String) && funWithReturnsTrueAndNotNullCheck(value_1)) {
        println(<!DEBUG_INFO_SMARTCAST!>value_1<!>.length)
    }
}

fun case_2(value_1: Any?) {
    if (!funWithReturnsFalse(value_1 is String) && !funWithReturnsTrueAndNullCheck(value_1)) {
        println(<!DEBUG_INFO_SMARTCAST!>value_1<!>.length)
    }
}

fun case_3(value_1: Any?) {
    if (funWithReturnsNull(value_1 is String?) == null && funWithReturnsTrue(value_1 != null)) {
        println(<!DEBUG_INFO_SMARTCAST!>value_1<!>.length)
    }
}

/*
 UNEXPECTED BEHAVIOUR
 */
fun case_4(value_1: Any?) {
    if (!value_1.case_4_1() && <!SENSELESS_COMPARISON!>value_1.case_4_2() == null<!>) {
        println(<!DEBUG_INFO_SMARTCAST!>value_1<!>.length)
    }
}

fun case_5(value_1: Any?, value_2: Boolean) {
    if (!funWithReturnsFalse(value_1 is String) && value_2) {
        println(<!DEBUG_INFO_SMARTCAST!>value_1<!>.length)
    }
}

fun case_6(value_1: Any?, value_2: Boolean?) {
    if (funWithReturnsNull(value_1 is String) == null && value_2 != null && <!DEBUG_INFO_SMARTCAST!>value_2<!>) {
        println(<!DEBUG_INFO_SMARTCAST!>value_1<!>.length)
    }
}

fun case_7(value_1: String?) {
    if (funWithReturnsTrueAndNotNullCheck(value_1) && true) {
        println(<!DEBUG_INFO_SMARTCAST!>value_1<!>.length)
    }
}

fun case_8(value_1: Any?) {
    if (funWithReturnsTrueAndNullCheck(value_1) && false) {
        println(<!DEBUG_INFO_CONSTANT!>value_1<!>)
    }
}

/*
 UNEXPECTED BEHAVIOUR: unreachable code
 */
fun case_9(value_1: Any?) {
    if (funWithReturnsFalse(value_1 is String) || funWithReturnsFalse(value_1 is Int)) {

    } else {
        println(<!DEBUG_INFO_SMARTCAST!>value_1<!>.length)
        println(<!DEBUG_INFO_SMARTCAST!>value_1<!>.inv())
    }
}

/*
 UNEXPECTED BEHAVIOUR: unreachable code
 */
fun case_10(value_1: Any?) {
    if (funWithReturnsFalse(value_1 is String) || getBoolean()) {

    } else {
        println(<!DEBUG_INFO_SMARTCAST!>value_1<!>.length)
    }
}
