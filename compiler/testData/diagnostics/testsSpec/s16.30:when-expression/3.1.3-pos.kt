/*
 KOTLIN SPEC TEST (POSITIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 3
 SENTENCE 1: When expression without bound value (the form where the expression enclosed in parantheses is absent) evaluates one of the many different expressions based on corresponding conditions present in the same when entry.
 NUMBER: 3
 DESCRIPTION: When with different variants of the equality expression in the control structure bodies.
 */

fun foo(
    value: Int,
    value1: Boolean,
    value2: Byte,
    value3: Short,
    value4: Int,
    value5: Long,
    value6: Float,
    value7: Double,
    value8: String,
    value9: Char,
    obj1: List<String>,
    obj2: List<String>,
    obj3: Nothing,
    obj4: Any
) {
    when {
        value == 1 -> value1 == true
        value == 2 -> value2 == 127.toByte()
        value == 3 -> value3 != 11.toShort()
        value == 4 -> value4 != 13142
        value == 5 -> value5 == 1243124124431443L
        value == 6 -> value6 != .0000000012f
        value == 7 -> value7 == 13223.12391293
        value == 8 -> value8 == ""
        value == 9 -> value9 != 'a'
        value == 10 -> {
            obj2 === obj1 && obj4 != obj2 || !(value6 == .000023412f) && value9 == '0' || value1 == false
        }
        value == 11 -> obj1 === obj2
        value == 12 -> obj1 == obj2
        value == 13 -> obj3 <!UNREACHABLE_CODE!>=== obj4<!>
        value == 14 -> obj4 <!UNREACHABLE_CODE!>!==<!> obj3
        value == 15 -> obj3 <!UNREACHABLE_CODE!>!= obj3<!>
    }
}