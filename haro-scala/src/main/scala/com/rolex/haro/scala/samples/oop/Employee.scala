package com.rolex.haro.scala.samples.oop

/**
  * 继承
  *
  * User: rolex
  * Date: 2016/4/28
  * version: 1.0
  */
class Employee {

    def this(name: String, salary: Double) {
        this()
        this.name = name
        this.salary = salary
    }

    var age = 20
    var name = "tom1"
    var salary = 100.0
    def work = "coding"

    override def toString = "i am employee."

}

// 子类继承父类时，需要指定所继承的父类的构造器，并通过主构造器赋值
class Manager(name: String, salary: Double) extends Employee(name, salary) {

    // 重写函数或是成员都要声明override
    override def toString = "i am manager. my work is " + super.work
}

object EmployeeTest {
    def main(args: Array[String]) {
        val e = new Employee("tom", 100)
        val m = new Manager("bob", 200)
        println(e.toString)
        println(m.toString)
        println(m.name)
    }

}
