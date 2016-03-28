package com.rolex.haro.scala.samples

/**
  * Created by rolex on 2016/3/28.
  */
object ForTest {

    def main(args: Array[String]) {
        for (i <- 1 to 2; j <- 1 to 2 if i == j) print((100 * i + j) + " ")
    }

}
