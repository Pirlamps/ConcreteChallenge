package br.com.concretechallenge.experimental


//public inline fun <T, R> T.errorLet(block: (T) -> R): R {
//    contract {
//        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
//    }
//    return block(this)
//}

//fun <T> async(block: suspend () -> T) {}

//public suspend fun <T : Any> Call<T>.await(): T {
//    return suspendCancellableCoroutine { continuation ->
//        enqueue(object : Callback<T>{
//            override fun onResponse(call: Call<T>?, response: Response<T?>) {
//                if(response.isSuccessful){
//                    val body = response.body()
//                    if(body == null){
//                        continuation.resumeWithException(
//                                NullPointerException("Response Body is Null!: $response")
//                        )
//                    }else{
//                        continuation.resume(body)
//                    }
//                }else{
//                    continuation.resumeWithException(HttpException(response))
//                }
//            }
//
//            override fun onFailure(call: Call<T>, t: Throwable) {
//                if(continuation.isCancelled) return
//                continuation.resumeWithException(t)
//            }
//
//        })
//
//        registerOnCompletion(continuation)
//    }
//}
//
//private fun Call<*>.registerOnCompletion(continuation: CancellableContinuation<*>) {
//    continuation.invokeOnCompletion {
//        if (continuation.isCancelled)
//            try {
//                cancel()
//            } catch (ex: Throwable) {
//                //Ignore cancel exception
//            }
//    }
//}