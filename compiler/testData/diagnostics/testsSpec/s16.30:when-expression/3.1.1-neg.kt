/*
 KOTLIN SPEC TEST (NEGATIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 3
 SENTENCE 1: When expression without bound value (the form where the expression enclosed in parantheses is absent) evaluates one of the many different expressions based on corresponding conditions present in the same when entry.
 NUMBER: 1
 DESCRIPTION: When with empty control structure bodies.
 */

fun test1(value: Int) {
    when {
        value == 1 -><!SYNTAX!><!>
    }
}