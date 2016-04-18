package com.rolex.haro.scala.samples.oop

/**
  * Created with IntelliJ IDEA.
  * User: rolex
  * Date: 2016/4/18
  * version: 1.0
  */
class Apply {
    def apply() = println("apply method in class")

    def foo: Unit = {
        println("foo in class")
    }
}

object Apply {
    def apply() = {
        println("apply method  in object")
        new Apply
    }
}

object ApplyTest {
    def main(args: Array[String]) {
        val a = Apply() // 调用的是伴生对象的apply
        a.foo

        val b = new Apply
        b() // 调用伴生类中的apply
        b.foo

        val arr = Array(1,2,3,4) // 调用Array object的apply
    }
}