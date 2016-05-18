package com.rolex.haro.scala.samples.basic

/**
  * Created with IntelliJ IDEA.
  * User: rolex
  * Date: 2016/05/18
  * Version: 1.0
  */
class StringTest {


}

object StringTest {

    def main(args: Array[String]) {
        val s = "hello spark"
        val s0: String = "hi" // scala的String类型为java.lang.String

        var s1 = "hello scala"

        s1 = "hello hadoop" // 字符串是不可变的，为字符串赋新值会重新创建一个对象

        println(s1)

        val s2 = new StringBuilder // 创建可修改的string
        s2.append("this")
        s2.append(" ")
        s2.append("is")
        s2.appendAll(" test")

        println(s2.length)

        val s3 = "spark"
        println(s3.length)

        val s4 = "hello".concat(" spark") // 字符串连接，和+等效
        println(s4)

        val a = 12.03
        val b = 100

        printf("%f,%d",a,b)
        //println(sf)
    }
}