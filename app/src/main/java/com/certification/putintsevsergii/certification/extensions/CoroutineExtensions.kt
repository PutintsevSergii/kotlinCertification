package com.certification.putintsevsergii.certification.extensions

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI

fun launchOnUI(block: suspend CoroutineScope.() -> Unit): Job {
    return launch(context = UI) { block() }
}


suspend fun <T> asyncAwait(block: suspend CoroutineScope.() -> T): T {
    return async { block() }.await()
}

infix fun <T> Deferred<T>.then(block: (T) -> Unit): Job {
    return launchOnUI {
        block(this@then.await())
    }
}