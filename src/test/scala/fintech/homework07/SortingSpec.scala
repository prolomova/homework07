package fintech.homework07
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class SortingSpec extends FlatSpec with Matchers {
  val resultForInt = ArrayBuffer(-3, -2, -1, 0, 1, 2, 3)
  val resultForString = ArrayBuffer("a", "aa", "b", "c")
  val resultForDouble = ArrayBuffer(1, 1.1, 2.0, 3.4, 5.6)

  "Merge sort" should "work correctly with integers" in {
    val arr = mutable.MutableList(1, 3, 2, -1, 0, -2, -3)
    Sorting.mergeSort(arr)
    arr shouldEqual resultForInt
  }

  "Merge sort" should "work correctly with other types" in {
    val intArr = mutable.MutableList("aa", "c", "b", "a")
    val doubleArr = mutable.MutableList(1.1, 3.4, 5.6, 2.0, 1)
    Sorting.mergeSort(intArr)
    Sorting.mergeSort(doubleArr)
    intArr shouldEqual resultForString
    doubleArr shouldEqual resultForDouble
  }

  "Quick sort" should "work correctly with integers" in {
    val arr = ArrayBuffer(1, 3, 2, -1, 0, -2, -3)
    Sorting.quickSort(arr)
    arr shouldEqual resultForInt
  }

  "Quick sort" should "work correctly with other types" in {
    val intArr = ArrayBuffer("aa", "c", "b", "a")
    val doubleArr = ArrayBuffer(1.1, 3.4, 5.6, 2.0, 1)
    Sorting.quickSort(intArr)
    Sorting.quickSort(doubleArr)
    intArr shouldEqual resultForString
    doubleArr shouldEqual resultForDouble
  }
}