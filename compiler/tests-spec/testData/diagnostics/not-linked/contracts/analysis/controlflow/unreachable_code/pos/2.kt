// !LANGUAGE: +AllowContractsForCustomFunctions +UseCallsInPlaceEffect
// !WITH_CONTRACT_FUNCTIONS

/*
 KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (POSITIVE)

 SECTION: Contracts
 CATEGORY: analysis, controlflow, unreachable_code
 NUMBER: 2
 DESCRIPTION: Check for lack of unreachable code report when 'at most once' and 'unknown' calls in place effect used.
 */

/*
 CASE KEYWORDS:
    effectsUsage
        callsInPlace:atMostOnce
    return
    throw
    unrechableCode
 */
fun case_1() {
    funWithAtMostOnceCallsInPlace {
        throw Exception()
    }
    funWithAtMostOnceCallsInPlace {
        return
    }
    println("1")
}

/*
 CASE KEYWORDS:
    effectsUsage
        callsInPlace:unknown
    return
    throw
    unrechableCode
 */
fun case_2() {
    funWithUnknownCallsInPlace {
        throw Exception()
    }
    funWithUnknownCallsInPlace {
        return
    }
    println("1")
}

/*
 CASE KEYWORDS:
    effectsUsage
        callsInPlace:exactlyOnce
    return:local,nonlocal
    unrechableCode
    fun:nested
 */
fun case_3() {
    funWithExactlyOnceCallsInPlace {
        return@funWithExactlyOnceCallsInPlace
    }
    println("1")
    funWithExactlyOnceCallsInPlace {
        fun nestedFun() {
            return@nestedFun
        }
    }
    println("1")
    fun case_3_nestedFun_1() {
        fun case_3_nestedFun_2() {
            funWithExactlyOnceCallsInPlace {
                return@case_3_nestedFun_2
            }
        }
        println("1")
    }
    println("1")
}

/*
 CASE KEYWORDS:
    effectsUsage
        callsInPlace:atLeastOnce
    return:local,nonlocal
    unrechableCode
    fun:nested
 */
fun case_4() {
    funWithAtLeastOnceCallsInPlace {
        return@funWithAtLeastOnceCallsInPlace
    }
    println("1")
    funWithAtLeastOnceCallsInPlace {
        fun nestedFun() {
            return@nestedFun
        }
    }
    println("1")
    fun case_4_nestedFun_1() {
        fun case_4_nestedFun_2() {
            funWithAtLeastOnceCallsInPlace {
                return@case_4_nestedFun_2
            }
        }
        println("1")
    }
    println("1")
}
