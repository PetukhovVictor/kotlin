// !WITH_SEALED_CLASSES
// !WITH_CLASSES
// !WITH_OBJECTS
// !WITH_TYPEALIASES

/*
 KOTLIN DIAGNOSTIC SPEC TEST (POSITIVE)

 SECTION 16.30: When expression
 PARAGRAPH: 7
 SENTENCE 1: Type test condition: type checking operator followed by type.
 NUMBER: 5
 DESCRIPTION: 'When' with bound value and type test condition (with invert type checking operator).
 */

// CASE DESCRIPTION: 'When' with two subtypes of the sealed class covered and all subtypes other than specified covered via invert type checking operator.
fun case_1(value: _SealedClass): String = when (value) {
    is _SealedChild1 -> ""
    !is _SealedChild3 -> ""
    <!USELESS_IS_CHECK!>is _SealedChild3<!> -> ""
}

// CASE DESCRIPTION: 'When' with three invert type checking operators on the all sybtypes of the sealed class.
fun case_2(value: _SealedClass): String {
    <!DEBUG_INFO_IMPLICIT_EXHAUSTIVE!>when (value) {
        !is _SealedChild1 -> return ""
        !is _SealedChild2 -> return ""
        !is _SealedChild3 -> return ""
    }<!>

    <!UNREACHABLE_CODE!>return ""<!>
}

// CASE DESCRIPTION: 'When' with direct and invert type checking operators on the same subtype of thee sealed class.
fun case_3(value: _SealedClass): String = when (value) {
    is _SealedChild2 -> ""
    !is _SealedChild2 -> ""
}

// CASE DESCRIPTION: 'When' as statement with direct and invert type checking operators on the same subtype of thee sealed class, and 'else' branch.
fun case_4(value: _SealedClass): String {
    when (value) {
        is _SealedChild2 -> return ""
        !is _SealedChild2 -> return ""
        else -> return ""
    }
}

// CASE DESCRIPTION: 'When' as expression with direct (in the first position) and invert (in the second position) type checking operators on the same subtype of the sealed class, and 'else' branch.
fun case_5(value: _SealedClass): String = when (value) {
    is _SealedChild2 -> ""
    !is _SealedChild2 -> ""
    <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> ""
}

// CASE DESCRIPTION: 'When' with direct (in the second position) and invert (in the first position) type checking operators on the same subtype of the sealed class, and 'else' branch (redundant).
fun case_6(value: _SealedClass): String = when (value) {
    !is _SealedChild1 -> ""
    <!USELESS_IS_CHECK!>is _SealedChild1<!> -> ""
    <!REDUNDANT_ELSE_IN_WHEN!>else<!> -> ""
}

// CASE DESCRIPTION: 'When' as expression with direct (in the second position) and invert (in the first position) type checking operators on the same subtype of the sealed class.
fun case_7(value: _SealedClass): String = when (value) {
    !is _SealedChild1 -> ""
    <!USELESS_IS_CHECK!>is _SealedChild1<!> -> ""
}

// CASE DESCRIPTION: 'When' as statement with direct (in the second position) and invert (in the first position) type checking operators on the same subtype of the sealed class.
fun case_8(value: _SealedClass): String {
    <!DEBUG_INFO_IMPLICIT_EXHAUSTIVE!>when (value) {
        !is _SealedChild1 -> return ""
        <!USELESS_IS_CHECK!>is _SealedChild1<!> -> return ""
    }<!>
}

// CASE DESCRIPTION: 'When' with one invert type checking operator on the some subtype of the sealed class, and 'else' branch.
fun case_9(value: _SealedClass): String = when (value) {
    !is _SealedChild1 -> ""
    else -> ""
}

// CASE DESCRIPTION: 'When' with one direct type checking operator on the some subtype of the sealed class, and 'else' branch.
fun case_10(value: _SealedClass): String = when (value) {
    is _SealedChild1 -> ""
    else -> ""
}

// CASE DESCRIPTION: 'When' with three basic types (Int, Boolean, String) covered and all types other than specified covered via invert type checking operator, and 'else' branch.
fun case_11(value: Any): String = when (value) {
    is Int -> ""
    is Boolean -> ""
    !is String -> ""
    <!USELESS_IS_CHECK!>is String<!> -> ""
    else -> ""
}

// CASE DESCRIPTION: 'When' with direct and invert type checking operators on the basic type (String).
fun case_12(value: Any): String = when (value) {
    is String -> ""
    !is String -> ""
    else -> ""
}

// CASE DESCRIPTION: 'When' with two subtypes of the sealed class covered and all subtypes other than specified covered via invert type checking operator.
fun case_13(value: _SealedClass?): String = when (value) {
    is _SealedChild1? -> ""
    !is _SealedChild3 -> ""
    <!USELESS_IS_CHECK!>is _SealedChild3<!> -> ""
    else -> ""
}

// CASE DESCRIPTION: 'When' with two subtypes of the sealed class covered and all subtypes other than specified covered via invert type checking operator.
fun case_14(value: _SealedClass?): String = when (value) {
    is _SealedChild1 -> ""
    !is _SealedChild3? -> ""
    <!USELESS_IS_CHECK!>is _SealedChild3?<!> -> ""
    else -> ""
}

// CASE DESCRIPTION: 'When' with two subtypes of the sealed class covered and all subtypes other than specified covered via invert type checking operator.
fun case_15(value: _SealedClass?): String = when (value) {
    is _SealedChild1 -> ""
    !is _SealedChild3 -> ""
    <!USELESS_IS_CHECK!>is _SealedChild3?<!> -> ""
    else -> ""
}

// CASE DESCRIPTION: 'When' with two subtypes of the sealed class covered and all subtypes other than specified covered via invert type checking operator.
fun case_16(value: _SealedClass?): String = when (value) {
    is _SealedChild1 -> ""
    !is _SealedChild3 -> ""
    <!USELESS_IS_CHECK!>is _SealedChild3<!> -> ""
    null -> ""
}

// CASE DESCRIPTION: 'When' with two subtypes of the sealed class covered and all subtypes other than specified covered via invert type checking operator.
fun case_17(value: _SealedClass?): String = when (value) {
    is _SealedChild1 -> ""
    !is _SealedChild3? -> ""
    is _SealedChild3 -> ""
    null -> ""
}

// CASE DESCRIPTION: 'When' with two subtypes of the sealed class covered and all subtypes other than specified covered via invert type checking operator.
fun case_18(value: _SealedClass?): String = when (value) {
    is _SealedChild1 -> ""
    !is _SealedChild3 -> ""
    <!USELESS_IS_CHECK!>is _SealedChild3?<!> -> ""
    null -> ""
}

// CASE DESCRIPTION: 'When' with 'else' branch and type test condition on the various nullable basic types (two nullable type check).
fun case_19(value: Number): String = when (value) {
    is Byte -> ""
    is Float -> ""
    !is Double -> ""
    else -> ""
}

// CASE DESCRIPTION: 'When' with 'else' branch and type test condition on the various nullable basic types (two nullable type check).
fun case_20(value: Number?): String = when (value) {
    is Byte -> ""
    is Float -> ""
    !is Double -> ""
    <!USELESS_IS_CHECK!>is Double<!> -> ""
    is Long -> "" // redundant Float type check
    else -> ""
}

// CASE DESCRIPTION: 'When' with 'else' branch and type test condition on the various nullable basic types (two nullable type check).
fun case_21(value: Number?): String = when (value) {
    is Byte -> ""
    is Float -> ""
    !is Double -> ""
    <!USELESS_IS_CHECK!>is Double<!> -> ""
    null -> "" // redundant null check
    else -> ""
}

// CASE DESCRIPTION: 'When' with 'else' branch and type test condition on the various nullable basic types (two nullable type check).
fun case_22(value: Number?): String = when (value) {
    is Byte -> ""
    is Float -> ""
    !is Double? -> ""
    is Double -> ""
    null -> "" // not redundant null check
    else -> ""
}

// CASE DESCRIPTION: 'When' with type checking operator on the one typealias which is not equal to the source type, and 'else' branch.
fun case_23(value: Any): String = when (value) {
    !is _TypeAliasUnit -> ""
    else -> ""
}

// CASE DESCRIPTION: 'When' with type checking operator on the two typealiases (one of which is equal to the source type).
fun case_24(value: Any): String {
    when (value) {
        !is _TypeAliasInt -> return ""
        <!USELESS_IS_CHECK!>!is _TypeAliasAny<!> -> return ""
    }

    return ""
}

// CASE DESCRIPTION: 'When' with type checking operator on the two typealiases (one of which is equal to the source type).
fun case_25(value: Any): String {
    when (value) {
        is _TypeAliasInt -> return ""
        <!USELESS_IS_CHECK!>!is _TypeAliasAny<!> -> return ""
    }

    return ""
}

// CASE DESCRIPTION: 'When' with type checking operator on the two typealiases (one of which is equal to the source type).
fun case_26(value: Any): String {
    when (value) {
        !is _TypeAliasInt -> return ""
        <!USELESS_IS_CHECK!>is _TypeAliasAny<!> -> return ""
    }

    return ""
}

// CASE DESCRIPTION: 'When' with type checking operator on the two typealiases (one of which is equal to the source type).
fun case_27(value: Any): String {
    when (value) {
        !is _EmptyObject -> return ""
    }

    return ""
}

// CASE DESCRIPTION: 'When' with type checking operator on the two typealiases (one of which is equal to the source type).
fun case_28(value: Any): String {
    when (value) {
        !is _EmptyObject -> return ""
        !is _ClassWithCompanionObject.Companion -> return ""
    }

    return ""
}

// CASE DESCRIPTION: 'When' with type checking operator on the two typealiases (one of which is equal to the source type).
fun case_29(value: Any): String {
    when (value) {
        !is _EmptyObject -> return ""
        is _ClassWithCompanionObject.Companion -> return ""
    }

    return ""
}

// CASE DESCRIPTION: 'When' with type checking operator on the two typealiases (one of which is equal to the source type).
fun case_30(value: Any): String {
    when (value) {
        is _EmptyObject -> return ""
        !is _ClassWithCompanionObject.Companion -> return ""
    }

    return ""
}
