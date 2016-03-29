package com.rolex.haro.scala.samples

import scala.collection.mutable.ArrayBuffer

/**
  * Created with IntelliJ IDEA.
  * User: rolex
  * Date: 2016/3/29
  * version: 1.0
  */
object ArrayTest {

    def main(args: Array[String]) {
        // 数组声明
        val a = new Array[Int](3)
        val b = Array("hello", "world")
        val c = ArrayBuffer[Int]()

        // 数组操作
        a(1) = 1
        c += 1
        c +=(2, 3)
        // 为啥是这个写法? 数组对象的++方法
        // a ++ b 等效于 a.++(b) 是将b数组追加到a数组，生成新的数组，a数组不变
        // a ++= b 是将b数组追加到a数组，生成新的数组，并赋值给a
        c ++= Array(4, 5, 6)

        for (i <- c if i % 2 == 0) print(i + " ")
        // 每个集合都有map和foreach函数，map返回对象，foreach返回unit，只用于遍历
        c.foreach(i=> print(i + " "))
        // _ 为占位符
        c.filter(_ % 2 == 0).map(_+1)

        val d = c.mkString("[",",","]")
        print(d)

        // 多维数组声明
        val e = Array.ofDim[Int](2,2)
        val f = new Array[Array[Int]](2)
        f(0) = new Array[Int](2)
        f(1) = new Array[Int](2)
    }
}
