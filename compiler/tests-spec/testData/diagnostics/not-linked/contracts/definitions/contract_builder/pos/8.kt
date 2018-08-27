// !LANGUAGE: +AllowContractsForCustomFunctions +UseCallsInPlaceEffect
// !DIAGNOSTICS: -INVISIBLE_REFERENCE -INVISIBLE_MEMBER -UNUSED_VARIABLE

/*
 KOTLIN DIAGNOSTICS NOT LINKED SPEC TEST (POSITIVE)

 SECTION: Contracts
 CATEGORY: definitions, contract_builder
 NUMBER: 8
 DESCRIPTION: Contract with callsInPlace effect on the not last function parameter lambda.
 UNEXPECTED BEHAVIOUR
 ISSUES: KT-26229
 */

import kotlin.internal.contracts.*

// CASE DESCRIPTION: two callsInPlace effects — on the first and last function parameter lambda
private inline fun case_1(block_1: () -> Unit, block_2: () -> Unit) {
    contract {
        callsInPlace(block_1, InvocationKind.EXACTLY_ONCE)
        callsInPlace(block_2, InvocationKind.EXACTLY_ONCE)
    }
    block_1()
    block_2()
}

// CASE DESCRIPTION: one callsInPlace effects on the not last function parameter lambda
private inline fun case_2(block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    block()
}
