package com.rolex.haro.scala.samples.basic

/**
  * 运算符.
  * User: rolex
  * Date: 2016/05/14
  * Version: 1.0
  */
class OperatorTest {

}

object OperatorTest{

    def main(args: Array[String]) {
        // 算数运算符 : + - * /
        // 关系运算符 : == != >= <= > <
        // 逻辑运算符 : && || !
        // 位运算符 : ~ & | ^ >> << >>>
        // 赋值运算符 : = += -= *= /= %= <<= >>= &= ^= |=

        // 优先级:
        // 指针最优，单目运算优于双目运算。如正负号。
        // 先乘除（模），后加减。
        // 先算术运算，后移位运算，最后位运算。请特别注意：1 << 3 + 2 & 7 等价于 (1 << (3 + 2))&7
        // 逻辑运算最后计算
    }

}
