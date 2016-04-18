package com.rolex.haro.scala.samples.oop

/**
  * 内部类和外部类
  *
  * User: rolex
  * Date: 2016/4/18
  * version: 1.0
  */
class Outer(val name: String) {
    // 内部类声明
    outer =>

    class Inner(var name: String) {
        def foo(i: Inner): Unit = {
            println("outer=" + outer.name + ", inner=" + i.name)
        }
    }

}

object OuterTest {
    def main(args: Array[String]) {
        val outer1 = new Outer("spark")
        val outer2 = new Outer("hadoop")
        val inner1 = new outer1.Inner("scala") // scala的内部类从属于外部类的实例，java的内部类从属于外部类的对象
        val inner2 = new outer2.Inner("java")
        inner1.foo(inner1)
        inner2.foo(inner2)
    }
}