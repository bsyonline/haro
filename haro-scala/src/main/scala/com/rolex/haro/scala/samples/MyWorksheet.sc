import scala.collection.mutable.ArrayBuffer

val a = new Array[Int](3)
val b = Array("hello", "world")
val c = ArrayBuffer[Int]()

a(1) = 1
c += 1
c +=(2, 3)
c ++= Array(4, 5, 6)

c.++(Array(1,2))

c

for (i <- c if i % 2 == 0) yield print(i)

val f = new Array[Array[Int]](2)
f(0) = new Array[Int](2)
f(1) = new Array[Int](2)
