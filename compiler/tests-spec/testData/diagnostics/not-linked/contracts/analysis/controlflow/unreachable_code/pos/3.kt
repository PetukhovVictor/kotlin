// !LANGUAGE: +AllowContractsForCustomFunctions +UseCallsInPlaceEffect
// !WITH_CONTRACT_FUNCTIONS

/*
 KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (POSITIVE)

 SECTION: Contracts
 CATEGORY: analysis, controlflow, unreachable_code
 NUMBER: 3
 DESCRIPTION: Unreachable code detection based on the local functions or labdas combined with contract functions with callsInPlace effect
 */

// CASE DESCRIPTION: unreachable code detection with 'exactly once' calls in place effect
fun case_1() {
    funWithExacltyOnceCallsInPlace {
        throw Exception()
    }
    <!UNREACHABLE_CODE!>println("1")<!>
}

// CASE DESCRIPTION: unreachable code detection with 'at least once' calls in place effect
fun case_2() {
    funWithAtLeastOnceCallsInPlace {
        throw Exception()
    }
    <!UNREACHABLE_CODE!>println("1")<!>
}

// CASE DESCRIPTION: unreachable code with 'exactly once' calls in place effect and non-local return
fun case_3() {
    funWithExacltyOnceCallsInPlace {
        return
    }
    <!UNREACHABLE_CODE!>println("1")<!>
}

// CASE DESCRIPTION: unreachable code with 'at least once' calls in place effect and non-local return
fun case_4() {
    funWithAtLeastOnceCallsInPlace {
        return
    }
    <!UNREACHABLE_CODE!>println("1")<!>
}

// CASE DESCRIPTION: unreachable code with 'at least once' calls in place effect and explicit labeled return to nested function
fun case_5(args: Array<String>) {
    fun case_5_nestedFun_1() {
        funWithAtLeastOnceCallsInPlace {
            return@case_5_nestedFun_1
        }
        <!UNREACHABLE_CODE!>println("1")<!>
    }
    fun case_5_nestedFun_3() {
        args.forEach {
            funWithAtLeastOnceCallsInPlace {
                return@forEach
            }
            <!UNREACHABLE_CODE!>println("1")<!>
        }
    }
    fun case_5_nestedFun_5() {
        fun case_5_nestedFun_6() {
            funWithAtLeastOnceCallsInPlace {
                return@case_5_nestedFun_6
            }
            <!UNREACHABLE_CODE!>println("1")<!>
        }
        println("1")
    }
}

// CASE DESCRIPTION: unreachable code with 'at least once' calls in place effect and explicit labeled return to lambda
fun case_6(args: Array<String>) {
    args.forEach {
        funWithExacltyOnceCallsInPlace {
            return@forEach
        }
        <!UNREACHABLE_CODE!>println("1")<!>
    }
    args.forEach {
        fun case_6_nestedFun_2() {
            funWithExacltyOnceCallsInPlace {
                return@case_6_nestedFun_2
            }
            <!UNREACHABLE_CODE!>println("1")<!>
        }
    }
    args.forEach {
        fun case_6_nestedFun_3() {
            funWithExacltyOnceCallsInPlace {
                return
            }
            <!UNREACHABLE_CODE!>println("1")<!>
        }
    }
}
