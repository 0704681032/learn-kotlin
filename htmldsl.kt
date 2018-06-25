package htmldsl

/**
* Created by JINYANGYANG096 on 2018-06-25.
*/

fun html(block:HTML.()->Unit):Node {
  return HTML().apply(block)
}

fun HTML.head(block:Head.()->Unit) {
  this@head.childList.add( Head().apply(block) )
}

fun HTML.body(block:Body.()->Unit) {
  this@body.childList.add( Body().apply(block) )
}

class  HTML : Tag("html")

class  Head : Tag("head")

class  Body : Tag("body")

fun main(args: Array<String>) {
//  1.传统方式
//  val  tag = Tag("html")
//  tag.properties += "id" to "htmlid"
//
//  tag.properties += "height" to "300px"
//
//  val div = Tag("div")
//
//  div.properties += "id" to "div1"
//
//  tag.childList.add(div)
//
//  println(tag.render())

  // 2. more step
//  var html = html {
//    "id" ("htmlId")
//    "name" ("htmlname")
//    "head" {
//      "id" ("headId")
//      "height" ("300px")
//     }
//     +"我是内容"
//  }
//  println(html.render())

  //3. more more step

  var html = html {
    "id" ("htmlId")
    "name" ("htmlname")
     head {
       "id" ("headId")
     }
    body {
      "id"("bodyId")
      +"我是内容"
      "div"{
        "id"("divId")
      }
    }

  }
  println(html.render())

}
