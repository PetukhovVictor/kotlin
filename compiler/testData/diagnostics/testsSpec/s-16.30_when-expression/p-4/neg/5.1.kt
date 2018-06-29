/*
 KOTLIN SPEC TEST (NEGATIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 4
 SENTENCE 5: Contains test condition: containment operator followed by an expression.
 NUMBER: 1
 DESCRIPTION: 'When' with bound value and 'when entry' with range exression, but wuthout contains operator.
 */

fun case_1(value: Int): Int {
    when (value) {
        <!INCOMPATIBLE_TYPES!>0..10<!> -> return 1
        <!INCOMPATIBLE_TYPES!>-10..10<!> -> return 2
        <!INCOMPATIBLE_TYPES!>-0..0<!> -> return 3
    }

    return -1
}
