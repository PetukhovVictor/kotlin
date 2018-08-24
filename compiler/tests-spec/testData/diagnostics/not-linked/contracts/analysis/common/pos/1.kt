// !LANGUAGE: +AllowContractsForCustomFunctions +UseReturnsEffect +UseCallsInPlaceEffect
// !DIAGNOSTICS: -INVISIBLE_REFERENCE -INVISIBLE_MEMBER

/*
 KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (POSITIVE)

 SECTION: Contracts
 CATEGORY: analysis, common
 NUMBER: 1
 DESCRIPTION: Analysis by contracts with mixed various effects.
 */

// FILE: contracts.kt

package contracts

import kotlin.internal.contracts.*

/*
 CASE KEYWORDS:
    fun:inline
    effectsDefinition
        2
        returns:true:implies:notNullCheck
        callsInPlace:exactlyOnce
 */
inline fun case_1(value1: Int?, block: () -> Unit): Boolean {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        returns(true) implies (value1 != null)
    }

    block()

    return value1 != null
}

/*
 CASE KEYWORDS:
    fun:inline,extension
    effectsDefinition
        4
        returnsNotNull:implies:notNullCheck
        returns:false:implies:nullableBooleanTypeCheck,receiverNotNullCheck
        callsInPlace:atLeastOnce
 */
inline fun <T> T?.case_2(value1: Int?, value2: Any?, block: () -> Unit): Boolean? {
    contract {
        callsInPlace(block, InvocationKind.AT_LEAST_ONCE)
        returnsNotNull() implies (value1 != null)
        returns(false) implies (value2 is Boolean?)
        returns(false) implies (this@case_2 != null)
    }

    block()

    if (value1 == null) return null
    if (value2 is Boolean? || this != null) return false

    return true
}

// FILE: usages.kt

import contracts.*

/*
 CASE KEYWORDS:
    effectsUsage
        returns:true
        callsInPlace:exactlyOnce
    smartInit:val
    smartcast:notNull
    if:else
 */
fun case_1(value1: Int?) {
    val value3: Int
    if (contracts.case_1(value1) { value3 = 10 }) {
        <!DEBUG_INFO_SMARTCAST!>value1<!>.inv()
        println(value3)
    } else {
        println(value3)
    }
}

/*
 CASE KEYWORDS:
    effectsUsage
        returnsNotNull
        returns:false
        callsInPlace:atLeastOnce
        nested
    smartInit:var
    smartcast:notNull,nullableBoolean
    if:else,nested
 */
fun case_2(value1: Int?, value2: Any?) {
    var value3: Int
    if (value1.case_2(value1, value2) { value3 = 10 } != null) {
        <!DEBUG_INFO_SMARTCAST!>value1<!>.inv()
        println(value3)
    } else {
        if (value1.case_2(value1, value2) { value3 = 10 } == false) {
            println(<!DEBUG_INFO_SMARTCAST!>value2<!>?.xor(true))
            println(value3)
            println(<!DEBUG_INFO_SMARTCAST!>value1<!>.inv())
        }
    }
}
