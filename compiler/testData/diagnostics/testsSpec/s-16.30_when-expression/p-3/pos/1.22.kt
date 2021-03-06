/*
 KOTLIN SPEC TEST (POSITIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 3
 SENTENCE 1: When expression without bound value (the form where the expression enclosed in parantheses is absent) evaluates one of the many different expressions based on corresponding conditions present in the same when entry.
 NUMBER: 22
 DESCRIPTION: 'When' with return expression in the control structure body.
 */

fun case_1(value: Int): String {
    when {
        value == 1 -> return ""
        value == 2 -> (return "")
        value == 3 -> {
            return ""
        }
    }

    return ""
}