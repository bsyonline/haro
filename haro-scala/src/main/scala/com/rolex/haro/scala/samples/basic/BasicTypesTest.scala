package com.rolex.haro.scala.samples.basic

/**
  * Created with IntelliJ DIEA.
  * User: rolex
  * Date: 2016/05/04
  * Version: 1.0
  */
object BasicTypesTest {

    def main(args: Array[String]) {
        /*
         * scala 中没有 java 的原生数据类型，所有都是对象
         *
         * 除了 java 中的几种数据类型外，还有
         *
         *  Unit ： 等同与 void
         *  Null ： null
         *  Nothing ： 等级最低，是任何类型的子类型
         *  Any ： 是其他类的超类
         *  AnyRef ： 所有引用类的超类
         *
         */

        val a = 'a // 调用的是scala.Symbol("a")
        val a1 = scala.Symbol("a")
        println(a)
        println(a1)

        val b =
            """line1
              line2
              line3
            """.stripMargin
    }
}
