// !LANGUAGE: +AllowContractsForCustomFunctions +UseReturnsEffect
// !DIAGNOSTICS: -INVISIBLE_REFERENCE -INVISIBLE_MEMBER

/*
 KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (NEGATIVE)

 SECTION: Contracts
 CATEGORY: analysis, smartcasts
 NUMBER: 6
 DESCRIPTION: Smartcast using returns effect with complex type checking and not-null conditions on receiver and another value_1 (mixed).
 */

// FILE: contracts.kt

package contracts

import kotlin.internal.contracts.*

/*
 CASE KEYWORDS:
    effectsDefinition
        1
        returns
            implies
                invertTypeCheck:string
                disjunction
                nullCheck:receiver
    fun:extension:generic,nullable
 */
fun <T> T?.case_1(value_1: Int?) {
    contract { returns() implies (this@case_1 == null || this@case_1 !is String || value_1 == null) }
    if (!(this == null || this !is String || value_1 == null)) throw Exception()
}

/*
 CASE KEYWORDS:
    effectsDefinition
        1
        returns
            implies
                invertTypeCheck:int,number
                disjunction
                nullCheck:receiver
    fun:extension
        generic:upperBound
        nullable
 */
fun <T : Number?> T.case_2(value_2: Any?) {
    contract { returns() implies (this@case_2 !is Int || <!SENSELESS_COMPARISON!>this@case_2 == null<!> || value_2 !is Number || <!SENSELESS_COMPARISON!>value_2 == null<!>) }
    if (!(this !is Int || <!SENSELESS_COMPARISON!>this == null<!> || value_2 !is Number || <!SENSELESS_COMPARISON!>value_2 == null<!>)) throw Exception()
}

/*
 CASE KEYWORDS:
    effectsDefinition
        1
        returns
            implies
                invertTypeCheck:int,number
                disjunction
                nullCheck:receiver
    fun:extension
        generic:upperBound
        nullable
 */
fun <T : Any?> T?.case_3(value_2: Any?) {
    contract { returns() implies (this@case_3 !is Number || this@case_3 !is Int || <!SENSELESS_COMPARISON!>this@case_3 == null<!> || value_2 == null) }
    if (!(this !is Number || this !is Int || <!SENSELESS_COMPARISON!>this == null<!>)) throw Exception()
}

/*
 CASE KEYWORDS:
    effectsDefinition
        1
        returns
            implies
                invertTypeCheck:int,number
                disjunction
                nullCheck:receiver
    fun
        extension
            generic:upperBound
            nullable
        inline:reified
 */
inline fun <reified T : Any?> T?.case_4(value_2: Number, value_3: Any?, value_4: String?) {
    contract { returns() implies ((this@case_4 !is Number && this@case_4 !is Int) || value_2 !is Int || value_3 == null || value_3 !is Number || value_4 == null) }
    if (!((this !is Number && this !is Int) || value_2 !is Int || value_3 == null || value_3 !is Number || value_4 == null)) throw Exception()
}

/*
 CASE KEYWORDS:
    effectsDefinition
        1
        returnsTrue
            implies
                invertTypeCheck:string
                disjunction
                nullCheck:receiver
        returnsFalse
            implies
                invertTypeCheck:string
                disjunction
                nullCheck:receiver
        returnsNotNull
            implies
                invertTypeCheck:string
                disjunction
                nullCheck:receiver
        returnsNull
            implies
                invertTypeCheck:string
                disjunction
                nullCheck:receiver
    fun:extension:generic,nullable
 */
fun <T> T?.case_5_1(value_1: Int?): Boolean {
    contract { returns(true) implies (this@case_5_1 == null || this@case_5_1 !is String || value_1 == null) }
    return this == null || this !is String || value_1 == null
}
fun <T> T?.case_5_2(value_1: Int?): Boolean {
    contract { returns(false) implies (this@case_5_2 == null || this@case_5_2 !is String || value_1 == null) }
    return this == null || this !is String || value_1 == null
}
fun <T> T?.case_5_3(value_1: Int?): Boolean? {
    contract { returnsNotNull() implies (this@case_5_3 == null || this@case_5_3 !is String || value_1 == null) }
    return this == null || this !is String || value_1 == null
}
fun <T> T?.case_5_4(value_1: Int?): Boolean? {
    contract { returns(null) implies (this@case_5_4 == null || this@case_5_4 !is String || value_1 == null) }
    return this == null || this !is String || value_1 == null
}

/*
 CASE KEYWORDS:
    effectsDefinition
        1
        returnsTrue
            implies
                invertTypeCheck:int,number
                disjunction
                nullCheck:receiver
        returnsFalse
            implies
                invertTypeCheck:int,number
                disjunction
                nullCheck:receiver
        returnsNotNull
            implies
                invertTypeCheck:int,number
                disjunction
                nullCheck:receiver
        returnsNull
            implies
                invertTypeCheck:int,number
                disjunction
                nullCheck:receiver
    fun:extension
        generic:upperBound
        nullable
 */
fun <T : Number?> T.case_6_1(value_2: Any?): Boolean {
    contract { returns(true) implies (this@case_6_1 !is Int || <!SENSELESS_COMPARISON!>this@case_6_1 == null<!> || value_2 !is Number || <!SENSELESS_COMPARISON!>value_2 == null<!>) }
    return this !is Int || <!SENSELESS_COMPARISON!>this == null<!> || value_2 !is Number || <!SENSELESS_COMPARISON!>value_2 == null<!>
}
fun <T : Number?> T.case_6_2(value_2: Any?): Boolean {
    contract { returns(false) implies (this@case_6_2 !is Int || <!SENSELESS_COMPARISON!>this@case_6_2 == null<!> || value_2 !is Number || <!SENSELESS_COMPARISON!>value_2 == null<!>) }
    return this !is Int || <!SENSELESS_COMPARISON!>this == null<!> || value_2 !is Number || <!SENSELESS_COMPARISON!>value_2 == null<!>
}
fun <T : Number?> T.case_6_3(value_2: Any?): Boolean? {
    contract { returnsNotNull() implies (this@case_6_3 !is Int || <!SENSELESS_COMPARISON!>this@case_6_3 == null<!> || value_2 !is Number || <!SENSELESS_COMPARISON!>value_2 == null<!>) }
    return this !is Int || <!SENSELESS_COMPARISON!>this == null<!> || value_2 !is Number || <!SENSELESS_COMPARISON!>value_2 == null<!>
}
fun <T : Number?> T.case_6_4(value_2: Any?): Boolean? {
    contract { returns(null) implies (this@case_6_4 !is Int || <!SENSELESS_COMPARISON!>this@case_6_4 == null<!> || value_2 !is Number || <!SENSELESS_COMPARISON!>value_2 == null<!>) }
    return this !is Int || <!SENSELESS_COMPARISON!>this == null<!> || value_2 !is Number || <!SENSELESS_COMPARISON!>value_2 == null<!>
}

/*
 CASE KEYWORDS:
    effectsDefinition
        1
        returnsTrue
            implies
                invertTypeCheck:int,number
                disjunction
                nullCheck:receiver
        returnsFalse
            implies
                invertTypeCheck:int,number
                disjunction
                nullCheck:receiver
        returnsNotNull
            implies
                invertTypeCheck:int,number
                disjunction
                nullCheck:receiver
        returnsNull
            implies
                invertTypeCheck:int,number
                disjunction
                nullCheck:receiver
    fun:extension
        generic:upperBound
        nullable
 */
fun <T : Any?> T?.case_7_1(value_2: Any?): Boolean {
    contract { returns(true) implies (this@case_7_1 !is Number || this@case_7_1 !is Int || <!SENSELESS_COMPARISON!>this@case_7_1 == null<!> || value_2 == null) }
    return this !is Number || this !is Int || <!SENSELESS_COMPARISON!>this == null<!> || value_2 == null
}
fun <T : Any?> T?.case_7_2(value_2: Any?): Boolean {
    contract { returns(false) implies (this@case_7_2 !is Number || this@case_7_2 !is Int || <!SENSELESS_COMPARISON!>this@case_7_2 == null<!> || value_2 == null) }
    return this !is Number || this !is Int || <!SENSELESS_COMPARISON!>this == null<!> || value_2 == null
}
fun <T : Any?> T?.case_7_3(value_2: Any?): Boolean? {
    contract { returnsNotNull() implies (this@case_7_3 !is Number || this@case_7_3 !is Int || <!SENSELESS_COMPARISON!>this@case_7_3 == null<!> || value_2 == null) }
    return this !is Number || this !is Int || <!SENSELESS_COMPARISON!>this == null<!> || value_2 == null
}
fun <T : Any?> T?.case_7_4(value_2: Any?): Boolean? {
    contract { returns(null) implies (this@case_7_4 !is Number || this@case_7_4 !is Int || <!SENSELESS_COMPARISON!>this@case_7_4 == null<!> || value_2 == null) }
    return this !is Number || this !is Int || <!SENSELESS_COMPARISON!>this == null<!> || value_2 == null
}

/*
 CASE KEYWORDS:
    effectsDefinition
        1
        returnsTrue
            implies
                invertTypeCheck:int,number
                disjunction,conjunction
                nullCheck:receiver
        returnsFalse
            implies
                invertTypeCheck:int,number
                disjunction,conjunction
                nullCheck:receiver
        returnsNotNull
            implies
                invertTypeCheck:int,number
                disjunction,conjunction
                nullCheck:receiver
        returnsNull
            implies
                invertTypeCheck:int,number
                disjunction,conjunction
                nullCheck:receiver
    fun
        extension
            generic:upperBound
            nullable
        inline:reified
 */
inline fun <reified T : Any?> T?.case_8_1(value_2: Number, value_3: Any?, value_4: String?): Boolean {
    contract { returns(true) implies ((this@case_8_1 !is Number && this@case_8_1 !is Int) || value_2 !is Int || value_3 == null || value_3 !is Number || value_4 == null) }
    return (this !is Number && this !is Int) || value_2 !is Int || value_3 == null || value_3 !is Number || value_4 == null
}
inline fun <reified T : Any?> T?.case_8_2(value_2: Number, value_3: Any?, value_4: String?): Boolean {
    contract { returns(false) implies ((this@case_8_2 !is Number && this@case_8_2 !is Int) || value_2 !is Int || value_3 == null || value_3 !is Number || value_4 == null) }
    return (this !is Number && this !is Int) || value_2 !is Int || value_3 == null || value_3 !is Number || value_4 == null
}
inline fun <reified T : Any?> T?.case_8_3(value_2: Number, value_3: Any?, value_4: String?): Boolean? {
    contract { returnsNotNull() implies ((this@case_8_3 is Number || this@case_8_3 is Int) && value_2 is Int && value_3 != null && value_3 is Number && value_4 != null) }
    return (this !is Number && this !is Int) || value_2 !is Int || value_3 == null || value_3 !is Number || value_4 == null
}
inline fun <reified T : Any?> T?.case_8_4(value_2: Number, value_3: Any?, value_4: String?): Boolean? {
    contract { returns(null) implies ((this@case_8_4 is Number || this@case_8_4 is Int) && value_2 is Int && value_3 != null && value_3 is Number && value_4 != null) }
    return (this !is Number && this !is Int) || value_2 !is Int || value_3 == null || value_3 !is Number || value_4 == null
}

// FILE: usages.kt

import contracts.*

/*
 CASE KEYWORDS:
    effectsUsage
        returns:
            invertTypeCheck:string
            disjunction
            nullCheck:receiver
    smartcast:notNull,string
 */
fun case_1(value_1: Any?, value_2: Int?) {
    value_1.case_1(value_2)
    println(value_1.<!UNRESOLVED_REFERENCE!>length<!>)
    println(value_2<!UNSAFE_CALL!>.<!>inv())
}

/*
 CASE KEYWORDS:
    effectsUsage
        returns:
            invertTypeCheck:int,number
            disjunction
            nullCheck:receiver
    smartcast:int,number
 */
fun case_2(value_1: Number?, value_2: Any?) {
    value_1.case_2(value_2)
    println(value_1.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>())
    println(value_2.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>toByte<!>())
}

/*
 CASE KEYWORDS:
    effectsUsage
        returns:
            invertTypeCheck:int,number
            disjunction
            nullCheck:receiver
    smartcast:notNull,int
 */
fun case_3(value_1: Any?, value_2: String?) {
    value_1.case_3(value_2)
    println(value_1.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>())
    println(value_2<!UNSAFE_CALL!>.<!>length)
}

/*
 CASE KEYWORDS:
    effectsUsage
        returns:
            invertTypeCheck:int,number
            disjunction
            nullCheck:receiver
    smartcast:number,int,string
 */
fun case_4(value_1: Any?, value_2: Number, value_3: Any?, value_4: String?) {
    value_1.case_4(value_2, value_3, value_4)
    println(value_2.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>())
    println(value_3.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>toByte<!>())
    println(value_4<!UNSAFE_CALL!>.<!>length)
}

/*
 CASE KEYWORDS:
    effectsUsage
        returnsTrue
            invertTypeCheck:string
            disjunction
            nullCheck:receiver
        returnsFalse
            invertTypeCheck:string
            disjunction
            nullCheck:receiver
        returnsNotNull
            invertTypeCheck:string
            disjunction
            nullCheck:receiver
        returnsNull
            invertTypeCheck:string
            disjunction
            nullCheck:receiver
    smartcast:notNull,string
 */
fun case_5(value_1: Any?, value_2: Int?, value_3: Any?, value_4: Int?, value_5: Any?, value_6: Int?) {
    when {
        value_1.case_5_1(value_2) -> {
            println(value_1.<!UNRESOLVED_REFERENCE!>length<!>)
            println(value_2<!UNSAFE_CALL!>.<!>inv())
        }
    }
    when {
        !value_3.case_5_2(value_4) -> {
            println(value_3.<!UNRESOLVED_REFERENCE!>length<!>)
            println(value_4<!UNSAFE_CALL!>.<!>inv())
        }
    }
    when {
        value_5.case_5_3(value_6) != null -> {
            println(value_5.<!UNRESOLVED_REFERENCE!>length<!>)
            println(value_6<!UNSAFE_CALL!>.<!>inv())
        }
    }
}

/*
 CASE KEYWORDS:
    effectsUsage
        returnsTrue
            invertTypeCheck:int,number
            disjunction
            nullCheck:receiver
        returnsFalse
            invertTypeCheck:int,number
            disjunction
            nullCheck:receiver
        returnsNotNull
            invertTypeCheck:int,number
            disjunction
            nullCheck:receiver
        returnsNull
            invertTypeCheck:int,number
            disjunction
            nullCheck:receiver
    smartcast:int,number
    if
 */
fun case_6(value_1: Number?, value_2: Any?, value_3: Number?, value_4: Any?, value_5: Number?, value_6: Any?) {
    if (value_1.case_6_1(value_2)) {
        println(value_1.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>())
        println(value_2.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>toByte<!>())
    }
    if (!value_3.case_6_2(value_4)) {
        println(value_3.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>())
        println(value_4.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>toByte<!>())
    }
    if (value_5.case_6_3(value_6) != null) {
        println(value_5.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>())
        println(value_6.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>toByte<!>())
    }
    if (value_5.case_6_4(value_6) == null) {
        println(value_5.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>())
        println(value_6.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>toByte<!>())
    }
}

/*
 CASE KEYWORDS:
    effectsUsage
        returnsTrue
            invertTypeCheck:int,number
            disjunction
            nullCheck:receiver
        returnsFalse
            invertTypeCheck:int,number
            disjunction
            nullCheck:receiver
        returnsNotNull
            invertTypeCheck:int,number
            disjunction
            nullCheck:receiver
        returnsNull
            invertTypeCheck:int,number
            disjunction
            nullCheck:receiver
    smartcast:notNull,int
 */
fun case_7(value_1: Any?, value_2: String?, value_3: Any?, value_4: String?, value_5: Any?, value_6: String?) {
    if (value_1.case_7_1(value_2)) {
        println(value_1.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>())
        println(value_2<!UNSAFE_CALL!>.<!>length)
    }
    if (value_3.case_7_2(value_4)) {
        println(value_3.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>())
        println(value_4<!UNSAFE_CALL!>.<!>length)
    }
    if (value_5.case_7_3(value_6) != null) {
        println(value_5.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>())
        println(value_6<!UNSAFE_CALL!>.<!>length)
    }
    if (value_5.case_7_4(value_6) == null) {
        println(value_5.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>())
        println(value_6<!UNSAFE_CALL!>.<!>length)
    }
}

/*
 CASE KEYWORDS:
    effectsUsage
        returnsTrue
            invertTypeCheck:int,number
            disjunction,conjunction
            nullCheck:receiver
        returnsFalse
            invertTypeCheck:int,number
            disjunction,conjunction
            nullCheck:receiver
        returnsNotNull
            invertTypeCheck:int,number
            disjunction,conjunction
            nullCheck:receiver
        returnsNull
            invertTypeCheck:int,number
            disjunction,conjunction
            nullCheck:receiver
    smartcast:notNull,number,int
    when
 */
fun case_8(value_1: Any?, value_2: Number, value_3: Any?, value_4: String?) {
    when { value_1.case_8_1(value_2, value_3, value_4) -> println(value_2.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>()) }
    when { value_1.case_8_1(value_2, value_3, value_4) -> println(value_3.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>toByte<!>()) }
    when { value_1.case_8_1(value_2, value_3, value_4) -> println(value_4<!UNSAFE_CALL!>.<!>length) }
    when { !value_1.case_8_2(value_2, value_3, value_4) -> println(value_2.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>()) }
    when { !value_1.case_8_2(value_2, value_3, value_4) -> println(value_3.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>toByte<!>()) }
    when { !value_1.case_8_2(value_2, value_3, value_4) -> println(value_4<!UNSAFE_CALL!>.<!>length) }
    when { value_1.case_8_3(value_2, value_3, value_4) == null -> println(value_2.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>()) }
    when { value_1.case_8_3(value_2, value_3, value_4) == null -> println(value_3.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>toByte<!>()) }
    when { value_1.case_8_3(value_2, value_3, value_4) == null -> println(value_4<!UNSAFE_CALL!>.<!>length) }
    when { value_1.case_8_4(value_2, value_3, value_4) != null -> println(value_2.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>inv<!>()) }
    when { value_1.case_8_4(value_2, value_3, value_4) != null -> println(value_3.<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>toByte<!>()) }
    when { value_1.case_8_4(value_2, value_3, value_4) != null -> println(value_4<!UNSAFE_CALL!>.<!>length) }
}
