package com.rolex.haro.scala.samples.basic

import scala.collection.mutable.ArrayBuffer

/**
  * Created with IntelliJ IDEA.
  * User: rolex
  * Date: 2016/3/29
  * version: 1.0
  */
class ArrayTest {}

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
        c.foreach(i => print(i + " "))
        // _ 为占位符
        c.filter(_ % 2 == 0).map(_ + 1)

        val d = c.mkString("[", ",", "]")
        print(d)

        // 多维数组声明
        val e = Array.ofDim[Int](2, 2)
        val f = new Array[Array[Int]](2)
        f(0) = new Array[Int](2)
        f(1) = new Array[Int](2)

        // 数组合并
        var arr1 = Array(1, 2, 3)
        var arr2 = Array(2, 3, 4)

        var arr3 = Array.concat(arr1, arr2)

        println(arr3)

        // 创建区间数组
        val arr4 = Range(1, 10)
        val arr5 = Range(1, 20, 5) // 5是步长
        for(i <- arr5){
            print(i + " ")
        }

    }
}
