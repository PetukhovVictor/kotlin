/*
 KOTLIN SPEC TEST (POSITIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 4
 SENTENCE 1: When expression with bound value (the form where the expression enclosed in parantheses is present) are very similar to the form without bound value, but use different syntax for conditions.
 NUMBER: 22
 DESCRIPTION: 'When' with return expression in the control structure body.
 */

fun case_1(value: Int): Int {
    when (value) {
        1 -> return 1
        2 -> (return 2)
        3 -> {
            return 3
        }
    }

    return -1
}