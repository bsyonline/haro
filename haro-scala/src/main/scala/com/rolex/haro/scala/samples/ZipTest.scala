package com.rolex.haro.scala.samples

/**
  * Created with IntelliJ IDEA.
  * User: rolex
  * Date: 2016/4/3
  * version: 1.0
  */
object ZipTest {

    def main(args: Array[String]) {
        val x = Array(1, 2, 3)
        val y = Array(1, 1, 1)
        val z = x.zip(y)
        for ((x, y) <- z) {
            println(x - y)
        }
    }

}
