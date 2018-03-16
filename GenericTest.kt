/**
 *Created by jinyangyang on 16/03/2018 10:28 PM.
 */
class Abcd<T>(var clazz:Class<T>){
    fun printGenericName() = clazz.canonicalName
}

class Person{

}

class Abcde<T>(var clazz:Class<T>){
    fun printGenericName() = clazz.canonicalName
    companion object {
        inline  operator  fun <reified  T> invoke() = Abcde(T::class.java)
    }
}

fun main(args: Array<String>) {
//    var abcd = Abcd<Person>(Person::class.java)
//    println(abcd.printGenericName())

    var abcde = Abcde<Person>()
    println(abcde)
}