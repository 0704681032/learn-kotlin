import java.io.File
import java.util.concurrent.Executors

/**
 *Created by jinyangyang on 03/03/2018 8:12 PM.
 */

fun main(args: Array<String>) {

    1..10 step 2

    "jyy".let {

    }


    var file:File = "jyy".let(::File)

    val executor = Executors.newSingleThreadScheduledExecutor {
        Thread(it, "scheduler").apply { isDaemon = true }
    }

    val executor1 = Executors.newSingleThreadScheduledExecutor {
        run -> Thread(run, "scheduler").apply { isDaemon = true }
    }


}