package com.rolex.haro.scala.samples.basic

/**
  * 变量声明.
  * User: rolex
  * Date: 2016/05/14
  * Version: 1.0
  */
object VariableTest {

    def main(args: Array[String]) {
        var a = 1
        a = 2 + 1 // var 声明变量
        println("a = " + a)

        val b :Int = 1 // 声明时可不指定类型,scala会自动推断类型
        //b = 2; // val 声明常量

        var c,d = 10 // 声明多个变量

    }

}
