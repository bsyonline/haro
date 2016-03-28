package com.rolex.haro.scala.samples

/**
  * Created with IntelliJ IDEA.
  * User: rolex
  * Date: 2016/3/21
  * version: 1.0
  */
object HelloWorld {

    def main(args: Array[String]) {
        for (arg <- args)
            println(arg)

        println(foo)
        loop()
    }

    def foo(): String = {
        "hello"
    }

    def loop(): Unit ={
        for(i<-1 to 10){
            println(i)
        }
    }

}
