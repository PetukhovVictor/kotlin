/*
 KOTLIN SPEC TEST (POSITIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 3
 SENTENCE 1: When expression without bound value (the form where the expression enclosed in parantheses is absent) evaluates one of the many different expressions based on corresponding conditions present in the same when entry.
 NUMBER: 1
 DESCRIPTION: When with different variants of the arithmetic expressions in the control structure bodies.
 */

fun int(value: Int, value1: Int) {
    val value2 = 912
    val value3 = 124901924904

    when {
        value == 1 -> <!UNUSED_EXPRESSION!>2<!>
        value == 2 -> 2 + 2
        value == 3 -> 2 * 2
        value == 4 -> 8 / 2
        value == 5 -> 8 % 2
        value == 6 -> 4 - 2
        value == 7 -> 2 + 2 * 2 / 2 % 2 - 2
        value == 8 -> 32 shl 2
        value == 9 -> value1 shr value2
        value == 10 -> 64 ushr value2
        value == 11 -> value2 and 4
        value == 12 -> 16 or 5
        value == 13 -> value1 xor 55
        value == 14 -> 55.inv()
        value == 15 -> value1 * value2
        value == 16 -> {
            value1 * 2 / 10 - 5 + 14 / 2 % 4 % value3
        }
    }
}

fun float(value: Int, value1: Float) {
    val value2 = 912.2134F
    val value3 = 124901924904.991242F

    when {
        value == 1 -> <!UNUSED_EXPRESSION!>2.1F<!>
        value == 2 -> 2.1f + 2.5f
        value == 3 -> 2.2f * 2f
        value == 4 -> 8.5f / 2.3f
        value == 5 -> 8F % 2f
        value == 6 -> 4.0F - 2.1f
        value == 7 -> 2f + .9f * .0000000001F / 2F % 2.91f - 2.09F
        value == 8 -> value1 * value2
        value == 9 -> {
            value1 * 2F / 10.12414141f - .13104141040f + 0.5F / 2F % 4.0f % value3
        }
    }
}

fun double(value: Int, value1: Double) {
    val value2 = 912.2134
    val value3 = 124901924904.99124212

    when {
        value == 1 -> <!UNUSED_EXPRESSION!>2.1<!>
        value == 2 -> 2.1 + 2.5
        value == 3 -> 2.2 * 2
        value == 4 -> 8.5 / 2.3
        value == 5 -> 8 % 2
        value == 6 -> 4.0 - 2.1
        value == 7 -> 2 + .9 * .0000000001 / 2 % 2.91 - 2.09
        value == 8 -> value1 * value2
        value == 9 -> {
            value1 * 2 / 10.12414141 - .13104141040 + 0.5 / 2 % 4.0 % value3
        }
    }
}

fun long(value: Int, value1: Long) {
    val value2 = 9L
    val value3 = 124909249042341234L

    when {
        value == 1 -> <!UNUSED_EXPRESSION!>2L<!>
        value == 2 -> 1249011249042341234L + 412L
        value == 3 -> 2L * 2L
        value == 4 -> 3241019249042341234L / 2L
        value == 5 -> 324901924942341234L % 2L
        value == 6 -> 4L - 2L
        value == 7 -> 2L + 9L * 10000000000000L / 2L % 5L - 2L
        value == 8 -> value1 * value2
        value == 9 -> {
            value1 * 2L / 10L - 92490149042341234L + 1324019249042341234L / 2L % 234124312423452L % value3
        }
    }
}

fun short(value: Int, value1: Short) {
    val value2: Short = 9234
    val value3: Short = 112
    val value4: Short = 6
    val value5: Short = 32767
    val value6: Short = -32768

    when {
        value == 1 -> <!UNUSED_EXPRESSION!>value1<!>
        value == 2 -> value1 - value2
        value == 3 -> value2 * value3
        value == 4 -> value4 / value2
        value == 5 -> value4 % value3
        value == 6 -> value4 - value6
        value == 7 -> value3 + value1 * value3 / value5 % value3 - value1
        value == 8 -> {
            value1 * value3 / value2 - value4 + value1 / value3 % value3 % value2 + value6
        }
    }
}

fun byte(value: Int, value1: Byte) {
    val value2: Byte = -11
    val value3: Byte = 3
    val value4: Byte = 127
    val value5: Byte = 5
    val value6: Byte = -128

    when {
        value == 1 -> <!UNUSED_EXPRESSION!>value1<!>
        value == 2 -> value1 - value2
        value == 3 -> value1 * value4
        value == 4 -> value3 / value4
        value == 5 -> value3 % value4
        value == 6 -> value5 - value1
        value == 7 -> value2 + value1 * value4 / value6 % value4 - value2
        value == 8 -> {
            value1 * value4 / value5 - value4 + value3 / value5 % value4 % value1 + value6
        }
    }
}