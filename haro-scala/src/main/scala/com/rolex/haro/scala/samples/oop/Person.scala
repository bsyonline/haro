package com.rolex.haro.scala.samples.oop

/**
  * 声明变量，常量
  *
  * User: rolex
  * Date: 2016/4/4
  * version: 1.0
  */
class Person {

    // 声明变量或常量默认都是private，必须赋初值
    private val name = "Rolex"
    // 类实例内部可用
    private var age = 20

    // 缺省为private，var默认生成getter和setter, val默认生成getter
    val gender = "male"

    def compare(other: Person): Int = {
        age - other.age
    }

    def add() = {
        age = age + 1
    }

    def getAge() = age

    // 当前对象内部可用
    private[this] val birthDay = "2000-01-01"

    /*def isEquals(other: Person): Boolean = {
        birthDay.equals(other.birthDay)
    }*/

}
object PersonTest {

    def main(args: Array[String]) {
        val person = new Person()
        person.add()
        println(person.getAge())
    }

}