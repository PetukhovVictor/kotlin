// !CHECK_TYPE

/*
 KOTLIN SPEC TEST (NEGATIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 6
 SENTENCE 2: It has an else entry;
 NUMBER: 1
 DESCRIPTION: Checking for not exhaustive when without bound value when there is no else branch.
 */

// CASE DESCRIPTION: Checking for not exhaustive in 'when' (several branches).
fun case_1(value: Int): Int = <!NO_ELSE_IN_WHEN!>when<!> {
    value == 1 -> 1
    value == 2 -> 2
    value == 3 -> 3
}

// CASE DESCRIPTION: Checking for not exhaustive in 'when' (one branch).
fun case_2(value: Int): Int = <!NO_ELSE_IN_WHEN!>when<!> {
    value == 1 -> 1
}

// CASE DESCRIPTION: Checking for not exhaustive in 'when' (no branches).
fun case_3(): Int = <!NO_ELSE_IN_WHEN!>when<!> {}
