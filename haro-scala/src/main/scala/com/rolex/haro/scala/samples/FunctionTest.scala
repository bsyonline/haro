package com.rolex.haro.scala.samples

/**
  * Created by rolex on 2016/3/28.
  */
object FunctionTest {

    def main(args: Array[String]) {
        //scala函数具有返回值，可直接作为函数的参数使用，一般情况下:Int可省略
        def foo(x: Int): Int = x + 1
        println(foo(1))

        //匿名函数可直接参与运算
        val foo1 = (x: Int) => x + 2
        println(foo1(1))

        //递归调用必须声明函数的返回类型，:Int 不能省略
        def fibonacci(n: Int): Int = if (n <= 0) 1 else n * fibonacci(n - 1)
        println(fibonacci(10))

        //默认参数
        def contact(a: String, b: String = "world") = a + " " + b
        println(contact("hello"))
        println(contact("hello", "scala"))

        //可变参数
        def foo2(args: Int*) = {
            var sum = 0
            for (arg <- args) {
                sum += arg
            }
            sum
        }
        println(foo2(1, 2, 3))
        println(foo2(1, 2, 3, 4, 5))

        //函数返回类型可省略,等价于
        /*
            def foo3(x : Int) ：Int = {
                return x+1:Int
            }
         */
        def foo3(x : Int) = {
            x+1
        }
        println(foo3(2))
    }

}
