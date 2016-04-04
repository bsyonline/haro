package com.rolex.haro.scala.samples

/**
  * Created with IntelliJ IDEA.
  * User: rolex
  * Date: 2016/3/21
  * version: 1.0
  */
object MapTest {

    def main(args: Array[String]) {
        // val 声明为常量， var 声明为变量
        // 声明不可变map
        val map = Map(1 -> "scala", 2 -> "java")

        for ((k, v) <- map) {
            println(k + " - " + v)
        }

        for ((_, v) <- map) print(v + " ")

        // 声明可变的map
        val map1 = scala.collection.mutable.Map("java" -> 1, "scala" -> 2)

        map1 += ("c" -> 3)

        for ((k, v) <- map1) {
            println(k + "," + v)
            // print(k, v) 这样写是啥意思？
        }

        println(map1.getOrElse("java", null)) // 有返回java的值，没有返回null

        // 删除
        map1 -= "c"

        // 排序的map
        val map2 = scala.collection.immutable.SortedMap("java" -> 1, "scala" -> 2, "groovy" -> 3)


    }
}
