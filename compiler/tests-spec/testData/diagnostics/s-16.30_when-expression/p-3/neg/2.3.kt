// !WITH_BASIC_TYPES

/*
 KOTLIN DIAGNOSTIC SPEC TEST (NEGATIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 3
 SENTENCE 2: Each entry consists of a boolean condition (or a special else condition), each of which is checked and evaluated in order of appearance.
 NUMBER: 3
 DESCRIPTION: 'When' without bound value and not allowed (if when used as expression) return in when entry.
 */

// CASE DESCRIPTION: 'When' with break expression (without label).
fun case_1(<!UNUSED_PARAMETER!>value<!>: Int) = when {
    <!RETURN_TYPE_MISMATCH, RETURN_IN_FUNCTION_WITH_EXPRESSION_BODY!>return<!> -> <!UNREACHABLE_CODE!>1<!>
}

// CASE DESCRIPTION: 'When' with break expression (without label).
fun case_2(value: Int) = when {
    value == 1 -> {}
    <!RETURN_IN_FUNCTION_WITH_EXPRESSION_BODY!>return<!> -> <!UNREACHABLE_CODE!>{}<!>
    <!UNREACHABLE_CODE!>else -> {}<!>
}

// CASE DESCRIPTION: 'When' with break expression (without label).
fun case_3(<!UNUSED_PARAMETER!>value<!>: Int) = when {
    <!RETURN_IN_FUNCTION_WITH_EXPRESSION_BODY!>return<!> -> <!UNREACHABLE_CODE!>{}<!>
    <!UNREACHABLE_CODE!>value == 2 -> {}<!>
}

// CASE DESCRIPTION: 'When' with break expression (without label).
fun case_4(<!UNUSED_PARAMETER!>value<!>: Int) = when {
    <!RETURN_IN_FUNCTION_WITH_EXPRESSION_BODY!>return<!> -> <!UNREACHABLE_CODE!>{}<!>
    <!UNREACHABLE_CODE!>return -> {}<!>
}

// CASE DESCRIPTION: 'When' with break expression (without label).
fun <!IMPLICIT_NOTHING_RETURN_TYPE!>case_5<!>(<!UNUSED_PARAMETER!>value<!>: Int) = when {
    <!RETURN_TYPE_MISMATCH, RETURN_IN_FUNCTION_WITH_EXPRESSION_BODY!>return<!> -> <!RETURN_TYPE_MISMATCH, UNREACHABLE_CODE!>return<!>
    <!UNREACHABLE_CODE!><!RETURN_TYPE_MISMATCH!>return<!> -> <!RETURN_TYPE_MISMATCH!>return<!><!>
}
