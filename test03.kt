import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.*
import kotlin.coroutines.experimental.intrinsics.*//需要手动的导入


//https://aisia.moe/2018/02/08/kotlin-coroutine-kepa/

// Kotlin 1.2.30 以后才能这样写
val suspendLambda = suspend {
    suspendCoroutine<String> {
        println("jyy")
        //it.resume("yyy")
        COROUTINE_SUSPENDED
    }
    "Hello world!"
}
// suspendLambda 的类型将被自动推导为 suspend () -> String

val suspendLambda1: suspend () -> String = {
    "Hello world!"
}

fun main(args: Array<String>) {

    suspendLambda.startCoroutine( object :Continuation<Any>{
        override  var context: CoroutineContext = EmptyCoroutineContext
        override fun resume(value: Any) { println("$value 11")}
        override fun resumeWithException(exception: Throwable) {}

    })


    Thread.sleep(3000)

}
