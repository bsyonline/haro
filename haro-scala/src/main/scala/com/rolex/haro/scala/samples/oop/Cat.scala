package com.rolex.haro.scala.samples.oop

/**
  * 构造器
  *
  * User: rolex
  * Date: 2016/4/8
  * version: 1.0
  */
class Cat private(var age: Int) {// var 或 val 修饰的变量会声明为成员，使用private会将构造器声明为私有

    // 声明变量必须赋初值，_为占位符
    var name: String = _

    def this(name: String) {
        this(10) // 每个类都有默认构造器，任何副构造器都必须最终调用主构造器
        this.name = name
    }

    // 构造器只能使用this，和Java不同
    def Cat(age: Int) {
        println("not constructor cat")
    }

    def this(name: String, age: Int) {
        this(10)
        println("overload constructor")
    }
}
object CatTest {

    def main(args: Array[String]) {
        var cat = new Cat("",10)
    }

}