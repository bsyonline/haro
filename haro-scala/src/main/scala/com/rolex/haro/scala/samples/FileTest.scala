package com.rolex.haro.scala.samples

import scala.io.Source

/**
  * Created by rolex on 2016/3/28.
  */
object FileTest {

    def main(args: Array[String]) {
        val file = Source.fromFile("D:\\IdeaProjects\\haro\\haro-scala\\src\\readme.md")
        for (line <- file) {
            print(line)
        }

        val html = Source.fromURL("http://spark.apache.org")
        for (line <- html.getLines()) {
            println(line)
        }
    }

}
