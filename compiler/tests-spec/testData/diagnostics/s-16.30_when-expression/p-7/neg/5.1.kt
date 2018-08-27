// !DIAGNOSTICS: -UNUSED_VALUE -ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE

/*
 KOTLIN DIAGNOSTICS SPEC TEST (NEGATIVE)

 SECTION: 16.30 When expression
 PARAGRAPH: 7
 SENTENCE: [5] Any other expression.
 NUMBER: 1
 DESCRIPTION: 'When' with bound value_1 and non-expressions in 'when condition'.
 */

// CASE DESCRIPTION: 'When' with cycles in when condition.
fun case_1(value_1: Int, value_1: List<Int>): String {
    when (value_1) {
        <!EXPRESSION_EXPECTED!>while (false) {}<!> -> return ""
        <!EXPRESSION_EXPECTED!>do {} while (false)<!> -> return ""
        <!EXPRESSION_EXPECTED!>for (value_2 in value_1) {}<!> -> return ""
    }

    return ""
}

// CASE DESCRIPTION: 'When' with assignments in when condition.
fun case_4(value_1: Int): String {
    var value_1: Int
    var value_2 = 10

    when (value_1) {
        <!ASSIGNMENT_IN_EXPRESSION_CONTEXT!>value_1 = 10<!> -> return ""
        <!ASSIGNMENT_IN_EXPRESSION_CONTEXT!>value_2 %= 10<!> -> return ""
    }

    return ""
}