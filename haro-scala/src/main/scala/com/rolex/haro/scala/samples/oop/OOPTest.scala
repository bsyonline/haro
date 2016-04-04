package com.rolex.haro.scala.samples.oop

/**
  * Created with IntelliJ IDEA.
  * User: rolex
  * Date: 2016/4/4
  * version: 1.0
  */
object OOPTest {

    def main(args: Array[String]) {
        val person = new Person()
        person.add()
        println(person.getAge())

        // 实际调用的是def gender()
        println(person.gender)

    }

}
