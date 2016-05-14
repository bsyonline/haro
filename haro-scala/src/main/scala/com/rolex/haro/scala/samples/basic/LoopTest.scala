package com.rolex.haro.scala.samples.basic

/**
  * 循环语句.
  * User: rolex
  * Date: 2016/05/14
  * Version: 1.0
  */
class LoopTest {

}

object LoopTest {

    def main(args: Array[String]) {

        // while
        var a = 10;
        while (a < 20) {
            println("Value of a: " + a);
            a = a + 1;
        }

        // do while
        a = 10;
        do {
            println("Value of a: " + a);
            a = a + 1;
        } while (a < 20)

        // for
        println("----------for 循环1----------")
        a = 0;
        for (a <- 1 to 10) {
            println("Value of a: " + a);
        }
        println("----------for 循环2----------")
        a = 0;
        for (a <- 1 until 10) {
            println("Value of a: " + a);
        }

        println("----------for 循环多个区间----------")
        a = 0;
        var b = 0;
        // for 循环多个区间
        for (a <- 1 to 3; b <- 1 to 4) {
            print("[" + a + "," + b + "]");
            if (b % 4 == 0) {
                println()
            }
        }
        println("----------for 循环集合----------")
        a = 0;
        val numList = List(1, 2, 3, 4, 5, 6);
        // for 循环集合
        for (a <- numList) {
            println("Value of a: " + a);
        }
        println("----------for 循环过滤----------")
        a = 0;
        val numList1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // for 循环过滤
        for (a <- numList1 if a != 3; if a < 8) {
            println("Value of a: " + a);
        }
        println("----------for 循环的返回值作为一个变量存储----------")
        a = 0;
        val numList2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // for 循环的返回值作为一个变量存储
        val retVal = for {a <- numList2 if a != 3; if a < 8} yield a

        // 输出返回值
        for (a <- retVal) {
            println("Value of a: " + a);
        }
    }
}
