/*
 KOTLIN SPEC TEST (NEGATIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 4
 SENTENCE 3: Type test condition: type checking operator followed by type.
 NUMBER: 3
 DESCRIPTION: When entry with type checking operator and non-type operator value.
 */

object A {}

class B {
    companion object {

    }
}

fun test1(value: Any): Int {
    when (value) {
        is A -> return 1
        is B.Companion -> return 1
        is B<!SYNTAX!>::<!><!SYNTAX!><!SYNTAX!><!>class<!><!SYNTAX!><!> <!SYNTAX!><!>-> return 1
        is <!DUPLICATE_LABEL_IN_WHEN!>B<!><!SYNTAX!>::<!><!SYNTAX!><!SYNTAX!><!>class<!><!SYNTAX!><!SYNTAX!><!>.<!><!EXPRESSION_EXPECTED_PACKAGE_FOUND!>java<!> <!SYNTAX!><!>-> return 1
    }

    return -1
}

fun test2(value: Any, <!UNUSED_PARAMETER!>value1<!>: String, <!UNUSED_PARAMETER!>value2<!>: Any?): Int {
    when (value) {
        is <!UNRESOLVED_REFERENCE!>value1<!> -> return 1
        is <!UNRESOLVED_REFERENCE!>value2<!> -> return 2
        is <!UNRESOLVED_REFERENCE!>value1<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>isEmpty<!><!SYNTAX!>(<!><!SYNTAX!><!SYNTAX!><!>)<!><!SYNTAX!><!> <!SYNTAX!><!>-> return 3
    }

    return -1
}

fun test3(value: Any): Int {
    when (value) {
        is <!SYNTAX!><!>{} <!SYNTAX!><!>-> return 1
        is <!SYNTAX!><!SYNTAX!><!>fun<!>(<!SYNTAX!><!>) {} <!SYNTAX!><!>-> return 2
        is <!SYNTAX!>90<!> -> return 2
        is <!SYNTAX!>-<!><!SYNTAX!>.032<!><!SYNTAX!><!> <!SYNTAX!><!>-> return 3
        is <!SYNTAX!>"<!><!SYNTAX!>...<!><!SYNTAX!><!SYNTAX!><!>"<!><!SYNTAX!><!> <!SYNTAX!><!>-> return 4
        is <!SYNTAX!>'.'<!> -> return 5
        is <!SYNTAX!>return<!> <!SYNTAX!>1<!><!SYNTAX!><!> <!SYNTAX!><!>-> return 6
        is <!SYNTAX!>throw<!> <!SYNTAX!>Exception<!>(<!SYNTAX!><!>) <!SYNTAX!><!>-> return 7
    }

    return -1
}
