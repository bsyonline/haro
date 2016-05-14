package com.rolex.haro.scala.samples.basic

/**
  * 运算符.
  * User: rolex
  * Date: 2016/05/14
  * Version: 1.0
  */
class OperatorTest {

}

object OperatorTest {

    def main(args: Array[String]) {
        // 算数运算符 : + - * /
        var a = 10;
        var b = 20;
        var c = 25;
        var d = 25;
        println("a + b = " + (a + b));
        println("a - b = " + (a - b));
        println("a * b = " + (a * b));
        println("b / a = " + (b / a));
        println("b % a = " + (b % a));
        println("c % a = " + (c % a));
        // 关系运算符 : == != >= <= > <
        a = 10;
        b = 20;
        println("a == b = " + (a == b));
        println("a != b = " + (a != b));
        println("a > b = " + (a > b));
        println("a < b = " + (a < b));
        println("b >= a = " + (b >= a));
        println("b <= a = " + (b <= a));
        // 逻辑运算符 : && || !
        var e = true;
        var f = false;
        println("e && f = " + (e && f));
        println("e || f = " + (e || f));
        println("!(e && f) = " + !(e && f));
        // 位运算符 : ~ & | ^ >> << >>>
        a = 60; /* 60 = 0011 1100 */
        b = 13; /* 13 = 0000 1101 */
        c = 0;

        c = a & b; /* 12 = 0000 1100 */
        println("a & b = " + c);

        c = a | b; /* 61 = 0011 1101 */
        println("a | b = " + c);

        c = a ^ b; /* 49 = 0011 0001 */
        println("a ^ b = " + c);

        c = ~a; /* -61 = 1100 0011 */
        println("~a = " + c);

        c = a << 2; /* 240 = 1111 0000 */
        println("a << 2 = " + c);

        c = a >> 2; /* 215 = 1111 */
        println("a >> 2  = " + c);

        c = a >>> 2; /* 215 = 0000 1111 */
        println("a >>> 2 = " + c);
        // 赋值运算符 : = += -= *= /= %= <<= >>= &= ^= |=
        a = 10;
        b = 20;
        c = 0;

        c = a + b;
        println("c = a + b  = " + c);

        c += a;
        println("c += a  = " + c);

        c -= a;
        println("c -= a = " + c);

        c *= a;
        println("c *= a = " + c);

        a = 10;
        c = 15;
        c /= a;
        println("c /= a  = " + c);

        a = 10;
        c = 15;
        c %= a;
        println("c %= a  = " + c);

        c <<= 2;
        println("c <<= 2  = " + c);

        c >>= 2;
        println("c >>= 2  = " + c);

        c >>= 2;
        println("c >>= a  = " + c);

        c &= a;
        println("c &= 2  = " + c);

        c ^= a;
        println("c ^= a  = " + c);

        c |= a;
        println("c |= a  = " + c);

        // 优先级:
        // 指针最优，单目运算优于双目运算。如正负号。
        // 先乘除（模），后加减。
        // 先算术运算，后移位运算，最后位运算。请特别注意：1 << 3 + 2 & 7 等价于 (1 << (3 + 2))&7
        // 逻辑运算最后计算
    }

}
