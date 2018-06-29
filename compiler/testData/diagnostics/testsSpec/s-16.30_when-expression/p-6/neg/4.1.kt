// !CHECK_TYPE

/*
 KOTLIN SPEC TEST (NEGATIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 6
 SENTENCE 4: The bound expression is of type kotlin.Boolean and the conditions contain both:
 NUMBER: 1
 DESCRIPTION: Checking for not exhaustive when when not contains by all Boolean values.
 */

// CASE DESCRIPTION: Checking for not exhaustive in 'when' on the Boolean value (with only true branch).
fun case_1(value: Boolean): Int = <!NO_ELSE_IN_WHEN!>when<!>(value) {
    true -> 1
}

// CASE DESCRIPTION: Checking for not exhaustive in 'when' on the Boolean value (with only false branch).
fun case_2(value: Boolean): Int = <!NO_ELSE_IN_WHEN!>when<!>(value) {
    false -> 1
}

// CASE DESCRIPTION: Checking for not exhaustive in 'when' on the Boolean value (no branches).
fun case_3(value: Boolean): Int = <!NO_ELSE_IN_WHEN!>when<!>(<!UNUSED_EXPRESSION!>value<!>) { }
