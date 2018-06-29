/*
 KOTLIN SPEC TEST (POSITIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 4
 SENTENCE 7: Any other expression.
 NUMBER: 18
 DESCRIPTION: 'When' with bound value and lambda literals in 'when condition'.
 */

// CASE DESCRIPTION: 'When' with 'else' branch (as expression).
fun case_1(value: Any?): Int {
    val lambda1 = { 0 }

    return when (value) {
        {} -> 1
        {{{{{ 0 }}}}} -> 2
        {
            when {
                else -> true
            }
        } -> 3
        lambda1 -> 4
        else -> 5
    }
}

// CASE DESCRIPTION: 'When' without 'else' branch (as statement).
fun case_2(value: Any?): Int {
    val lambda1 = { 0 }

    return when (value) {
        {} -> 1
        {{{{{ 0 }}}}} -> 2
        {
            when {
                else -> true
            }
        } -> 3
        lambda1 -> 4
        else -> 5
    }
}