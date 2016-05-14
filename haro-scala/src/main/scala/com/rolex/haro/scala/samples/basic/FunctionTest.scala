package com.rolex.haro.scala.samples.basic

import java.util.Date

/**
  * Created by rolex on 2016/3/28.
  */
abstract class FunctionTest {
    def foo // 没有()和方法体,则隐式声明为abstract
}

object FunctionTest {

    def main(args: Array[String]) {


        // scala函数具有返回值，可直接作为函数的参数使用，一般情况下:Int可省略
        def foo(x: Int): Int = x + 1
        println(foo(1))

        // 递归调用必须声明函数的返回类型，:Int 不能省略
        def fibonacci(n: Int): Int = if (n <= 0) 1 else n * fibonacci(n - 1)
        println(fibonacci(10))

        println("---------------默认参数--------------")
        def contact(a: String, b: String = "world") = a + " " + b
        println(contact("hello"))
        println(contact("hello", "scala"))

        println("---------------可变参数--------------")
        def foo2(args: Int*) = {
            var sum = 0
            for (arg <- args) {
                sum += arg
            }
            sum
        }
        println(foo2(1, 2, 3))
        println(foo2(1, 2, 3, 4, 5))

        // 函数返回类型可省略,等价于
        /*
            def foo3(x : Int) ：Int = {
                return x+1:Int
            }
         */
        def foo3(x: Int) = {
            x + 1
        }
        println(foo3(2))

        println("---------------指定参数--------------")
        def printInt(a: Int, b: Int) = {
            println("Value of a : " + a);
            println("Value of b : " + b);
        }
        printInt(b = 1, a = 2)

        println("---------------高阶函数--------------")
        // 高阶函数（Higher-Order Function）就是操作其他函数的函数
        // 函数 f 和 值 v 作为参数，而函数 f 又调用了参数 v
        def apply(f: Int => String, v: Int) = f(v)
        def layout[A](x: A) = "[" + x.toString() + "]"
        println(apply(layout, 10))

        println("---------------函数嵌套--------------")
        def factorial(i: Int): Int = {
            def fact(i: Int, accumulator: Int): Int = {
                if (i <= 1)
                    accumulator
                else
                    fact(i - 1, i * accumulator)
            }
            fact(i, 1)
        }
        println(factorial(3))

        println("---------------匿名函数--------------")
        // 匿名函数可直接参与运算
        val foo1 = (x: Int) => x + 2
        println(foo1(1))
        // 在匿名函数中定义多个参数
        var mul = (x: Int, y: Int) => x * y
        println(mul(3, 4))

        // 不给匿名函数设置参数
        var userDir = () => {
            System.getProperty("user.dir")
        }
        println(userDir)

        println("---------------偏应用函数--------------")
        val date = new Date
        def log(date: Date, message: String) = {
            println(date + "----" + message)
        }
        val logWithDateBound = log(date, _: String) // 使用下划线(_)替换缺失的参数列表，并把这个新的函数值的索引的赋给变量

        logWithDateBound("message1")
        Thread.sleep(1000)
        logWithDateBound("message2")
        Thread.sleep(1000)
        logWithDateBound("message3")

        println("---------------函数柯里化--------------")
        // 柯里化(Currying)指的是将原来接受两个参数的函数变成新的接受一个参数的函数的过程

        val str1: String = "Hello, "
        val str2: String = "Scala!"
        def strcat(s1: String)(s2: String) = {
            s1 + s2
        }
        println("str1 + str2 = " + strcat(str1)(str2))

    }

}
