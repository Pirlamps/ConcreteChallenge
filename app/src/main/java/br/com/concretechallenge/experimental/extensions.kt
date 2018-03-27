package br.com.concretechallenge.experimental


//public inline fun <T, R> T.errorLet(block: (T) -> R): R {
//    contract {
//        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
//    }
//    return block(this)
//}

fun <T> async(block: suspend () -> T) {}