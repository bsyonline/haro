package com.rolex.haro.scala.samples.basic

import scala.util.control._

/**
  * break.
  * User: rolex
  * Date: 2016/05/14
  * Version: 1.0
  */
class BreakTest {

}

object BreakTest {

    def main(args: Array[String]) {

        // scala 么有break, 2.8 以后可使用scala.util.control.Breaks
        val br = new Breaks;

        for (i <- 1 to 10) {
            if (i > 5) {
                br.break()
            }
            print(i + " ")
        }

        var a = 0;
        val numList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        val loop = new Breaks;
        loop.breakable {
            for (a <- numList) {
                println("Value of a: " + a);
                if (a == 4) {
                    loop.break;
                }
            }
        }
        println("After the loop");


        a = 0;
        var b = 0;
        val numList1 = List(1,2,3,4,5);
        val numList2 = List(11,12,13);

        val outer = new Breaks;
        val inner = new Breaks;

        outer.breakable {
            for( a <- numList1){
                println( "Value of a: " + a );
                inner.breakable {
                    for( b <- numList2){
                        println( "Value of b: " + b );
                        if( b == 12 ){
                            inner.break;
                        }
                    }
                } // 内嵌循环中断
            }
        } // 外部循环中断
    }
}
