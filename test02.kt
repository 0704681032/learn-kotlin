import java.util.concurrent.Executors

/**
 *Created by jinyangyang on 16/03/2018 10:06 PM.
 */


class Instance private constructor(){
    companion object {
        val name = "jyy"
        //必须要是val 才能使用by lazy
        private val inner:Instance by lazy {
            Instance()
        }
        fun say() = println(name)
        fun getInstance():Instance = inner
    }
}


fun main(args: Array<String>) {
    println(Instance.name)
    println(Instance.say())
    println(Instance.getInstance())

    var es = Executors.newFixedThreadPool(10)

    for (i in 1..10) {
        es.submit{
            println(Thread.currentThread().name)
            println(Instance.getInstance())
        }

    }


}