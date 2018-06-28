/*
 KOTLIN SPEC TEST (POSITIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 4
 SENTENCE 3: Type test condition: type checking operator followed by type.
 NUMBER: 4
 DESCRIPTION: Simple when with bound value and type test condition with type aliases.
 */

typealias AnyCustom = Any
typealias UnitCustom = Unit
typealias NothingCustom = Nothing
typealias IntCustom = Int
typealias ListBook = List<Map<String, String>>

fun test1(value: Any): Int {
    when (value) {
        is ListBook -> 1
        is IntCustom -> 2
        is AnyCustom -> 3
    }

    return -1
}

fun test2(value: Any): Int = when (value) {
    is ListBook -> 1
    is IntCustom -> 2
    else -> 4
}

fun test3(value: Any): Int = when (value) {
    is IntCustom -> 1
    else -> 2
}

fun test4(value: Any): Int = when (value) {
    is AnyCustom -> 1
    else -> 2
}

fun test5(value: Any): Int {
    when (value) {
        is ListBook -> return 1
    }

    return -1
}

fun test4(value: Any): Int = when (value) {
    is UnitCustom -> 1
    else -> 2
}

fun test4(value: Any): Int = when (value) {
    is NothingCustom -> 1
    else -> 2
}
