package com.rolex.haro.scala.samples

/**
  * Created with IntelliJ IDEA.
  * User: rolex
  * Date: 2016/3/21
  * version: 1.0
  */
object TupleTest {

    def main(args: Array[String]) {
        val tuple4 = (1,"2",3,"4")

        print(tuple4._2)
    }

    // 元组中包含不同类型的数据
    val tuple = (1,2,3,"java","scala")

    // 元组可反向赋值
    val (one, two, three, four, _) = tuple

    println("Java SDK".partition(_.isUpper))
    
}
