/*
 KOTLIN DIAGNOSTICS SPEC TEST (POSITIVE)

 SECTION: 16.30 When expression
 PARAGRAPH: 11
 SENTENCE: [1] It has an else entry;
 NUMBER: 1
 DESCRIPTION: Check when exhaustive via else entry (when without bound value_1).
 */

// CASE DESCRIPTION: Checking for exhaustive 'when' (several value_1 check branches and 'else' branch).
fun case_1(value_1: Int): String = when {
    value_1 == 0 -> ""
    value_1 > 0 && value_1 <= 10 -> ""
    value_1 > 10 && value_1 <= 100 -> ""
    value_1 > 100 -> ""
    else -> ""
}

// CASE DESCRIPTION: Checking for exhaustive 'when' (value_1 check branch and 'else' branch).
fun case_2(): String = when {
    true -> ""
    else -> ""
}

// CASE DESCRIPTION: Checking for exhaustive 'when' (only 'else' branch).
fun case_3(): String = when {
    else -> ""
}