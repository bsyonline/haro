package com.rolex.haro.scala.samples

import scala.io.Source

/**
  * Created by rolex on 2016/3/28.
  */
object LazyTest {

    def main(args: Array[String]) {
        // lazy 声明的变量或常量，会在第一次使用的时候，才进行实例化
        lazy val file = Source.fromFile("d:/test.md")
        println("scala")
        for(line <- file.getLines()){

        }
    }

}
