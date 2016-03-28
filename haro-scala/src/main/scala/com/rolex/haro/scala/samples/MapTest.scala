package com.rolex.haro.scala.samples

/**
  * Created with IntelliJ IDEA.
  * User: rolex
  * Date: 2016/3/21
  * version: 1.0
  */
object MapTest {

    def main(args: Array[String]) {
        //val 声明为常量， var 声明为变量
        val map = Map(1 -> "scala", 2 -> "java")

        for ((k, v) <- map) {
            println(k + " - " + v)
        }

        for ((_, v) <- map) print(v + " ")
    }
}
