package com.rolex.haro.scala.samples.basic

/**
  * 访问修饰符.
  * User: rolex
  * Date: 2016/05/14
  * Version: 1.0
  */
class AccessControlTest {

    // scala有三种访问修饰符,private protected public,缺省都是public的
    class Outer{
        class Inner{// private仅在声明了private成员的对象或类的内部可见
            private def f(){println("f")}
            class InnerMost{
                f() // 正确
            }
        }
        // (new Inner).f() // 错误
    }
}
package p{
    class Super{
        protected def f() {println("f")} // protected 只在子类中可见,在同包中不可见(对比java)
    }
    class Sub extends Super{
        f()
    }
    class Other{
        // (new Super).f() // 错误
    }
}

package bobsrocckets{
    /*package navigation{
        private[bobsrockets] class Navigator{
            // private[xxx] 表示xxx包内可见,对xxx包以外私有
            protected[navigation] def useStarChart(){}
            class LegOfJourney{
                private[Navigator] val distance = 100
            }
            private[this] var speed = 200
        }
    }
    package launch{
        import navigation._
        object Vehicle{
            private[launch] val guide = new Navigator
        }
    }*/
}