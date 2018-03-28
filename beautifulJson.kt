package com.caap.jweb.caapfinance

import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import java.io.File

/**
* Created by JINYANGYANG096 on 2018-03-28.
*/
fun beautifulJSONArray(jsonArray: JSONArray, dep: Int = 0) {
    var prefix = getLinePrefix(dep)//前面的空格
    jsonArray.forEachIndexed { index, it ->
        var comma = if (index != jsonArray.size - 1) "," else ""
        when (it) {
            is JSONObject -> { //jsonarry里面是jsonobject
                print("$prefix{")
                beatutifulJSON(it, dep + 1)
                println("$prefix}$comma")
            }
            else -> println(it) //jsonarray是普通对象
        }
    }
}

fun beatutifulJSON(jsonObject: JSONObject, dep: Int = 0) {
    var prefix = getLinePrefix(dep)//前面的空格
    if (dep == 0)  println("{") else println()
    val size = jsonObject.size
    var comma = ","
    jsonObject.keys.mapIndexed { index: Int, k: String? ->
        var v = jsonObject.get(k)
        print("$prefix \"$k\": ")
        if (index == size -1 ) comma = ""//最后一个属性字段不需要加,
        when (v) {
            is JSONArray -> {
                println("[")
                beautifulJSONArray(v, dep + 3)
                println("$prefix]$comma")
            }
            is JSONObject -> {
                print("{")
                beatutifulJSON(v, dep + 1)
                println("$prefix}$comma")
            }
            else -> println("\"$v\"$comma") //字符串等
        }
    }
    if (dep == 0) {
        println("}")
    }
}

private fun getLinePrefix(dep: Int): String {
    var str = ""
    repeat(dep) {
        str += " "
    }
    return str
}

fun main(args: Array<String>) {
    var path = "D:\\study\\caap-tms\\src\\main\\kotlin\\com\\" +
            "caap\\jweb\\caapfinance\\1.json"

    File(path).readText().let {
        JSONObject.parseObject(it).also { beatutifulJSON(it) }
    }
}
