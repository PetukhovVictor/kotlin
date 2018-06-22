/*
 KOTLIN SPEC TEST (POSITIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 4
 SENTENCE 1: When expression with bound value (the form where the expression enclosed in parantheses is present) are very similar to the form without bound value, but use different syntax for conditions.
 NUMBER: 17
 DESCRIPTION: When with fun literal in the control structure bodies.
 */

fun foo(value: Int) {
    val fun1 = fun(): Int {
        return 0
    }

    when(value) {
        1 -> <!UNUSED_EXPRESSION!>fun() {}<!>
        2 -> <!UNUSED_EXPRESSION!>fun(): Boolean {
            return when {
                else -> true
            }
        }<!>
        3 -> <!UNUSED_EXPRESSION!>fun1<!>
        4 -> {
            <!UNUSED_EXPRESSION!>fun() {<!UNUSED_EXPRESSION!>fun() {<!UNUSED_EXPRESSION!>fun() {}<!>}<!>}<!>
        }
    }
}