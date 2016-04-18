package com.rolex.haro.scala.samples.oop

/**
  * 伴生类和伴生对象
  *
  * User: rolex
  * Date: 2016/4/18
  * version: 1.0
  */
class Dog {// 伴生类
    val id = Dog.newName // 可以访问伴生对象的所有方法和属性，包括private
    private var age = 10
    def aClass(age:Int): Unit = {
        this.age += age
    }
}

// object通常用于存储静态的公共的方法和属性
// 静态的内容不会在加载的时候执行，而是在第一次执行时加载
object Dog{ // 伴生对象
    var name = "a"
    /*private*/ def newName = { // 加上private后，伴生类仍然可以访问，外部对象不能访问
        name = "b"
        name
    }
}

object DogTest {

    def main(args: Array[String]) {
        println(Dog.newName)
    }

}