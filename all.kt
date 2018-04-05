import io.netty.bootstrap.ServerBootstrap

sealed class Expr {
    class Const(val number: Double) : Expr()
    class Sum(val e1: Expr, val e2: Expr) : Expr()
    object NotANumber : Expr()
}

fun quanpai(str:String):MutableList<MutableList<Char>>{
    //str = str.toUpperCase()
    if ( str.length ==1 ) {
        return mutableListOf( mutableListOf(str[0]) )
    }

    var set:MutableSet<Char> = str.fold(mutableSetOf()) {
        acc, c ->  acc.apply{ add(c) }
    }

    //println(set)

    //var list = set.toList()
    //println(list)
    var result = mutableListOf<MutableList<Char>>()
    set.forEach{ c1 ->
        var index = str.indexOf(c1)
        var str1 = str.filterIndexed{ i2,c2 ->
            i2 != index
        }
        //println("$c1=$str1")
        var local:MutableList<MutableList<Char>> = quanpai(str1)
        local.forEach { list->
            //println(list)
            list.add(0,c1)
            result.add(list)
        }
    }


    return result

}

fun main(args: Array<String>) {

    var s : ServerBootstrap

     //println ( mutableSetOf("AAbcb".chars()) )

//    var str = "AAbcb"
//
//   var list = mutableListOf('A','C')
//
//    list.add(0,'B')
//
//    println(list)

    var result = quanpai("ABAC")
    println(result)

}
