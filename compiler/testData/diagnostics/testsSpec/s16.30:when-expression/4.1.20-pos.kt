/*
 KOTLIN SPEC TEST (POSITIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 4
 SENTENCE 1: When expression with bound value (the form where the expression enclosed in parantheses is present) are very similar to the form without bound value, but use different syntax for conditions.
 NUMBER: 20
 DESCRIPTION: When with throw expression in the control structure bodies.
 */

fun foo(value: Int) {
    val lambda1 = {
        throw Exception("Ex")
    }

    when(value) {
        1 -> lambda1()
        2 -> throw Exception("Ex")
        3 -> {
            try {
                throw Exception("Ex")
            } catch (e: Exception) {

            }
        }
    }
}