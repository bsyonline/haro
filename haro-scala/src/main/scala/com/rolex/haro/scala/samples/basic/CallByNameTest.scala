package com.rolex.haro.scala.samples.basic

/**
  * 传名调用.
  * User: rolex
  * Date: 2016/05/14
  * Version: 1.0
  */
class CallByNameTest {

}

object CallByNameTest {

    def main(args: Array[String]) {
        // 传值调用（call-by-value）：先计算参数表达式的值，再应用到函数内部
        // 传名调用（call-by-name）：将未计算的参数表达式直接应用到函数内部,在函数内部进行参数表达式的值计算
        //                         每次使用传名调用时，解释器都会计算一次表达式的值
        delayed(time());
    }

    def time() = {
        println("获取时间，单位为纳秒")
        System.nanoTime
    }
    def delayed( t: => Long ) = { // 传名调用
        println("在 delayed 方法内")
        println("参数： " + t)
    }
}
