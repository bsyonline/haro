package com.rolex.haro.scala.samples.basic

/**
  * 闭包.
  * User: rolex
  * Date: 2016/05/14
  * Version: 1.0
  */
class ConclusionTest {

    // 闭包是一个函数，返回值依赖于声明在函数外部的一个或多个变量

}

object ConclusionTest {
    def main(args: Array[String]) {
        println("muliplier(1) value = " + multiplier(1))
        println("muliplier(2) value = " + multiplier(2))
    }

    var factor = 3
    val multiplier = (i: Int) => i * factor

}