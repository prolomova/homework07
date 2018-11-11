package fintech.homework07

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Реализовать алгоритмы quick-sort и merge-sort
  *  использую *подходящие* *мутабельные* коллекции
  */

object Sorting{
  def quickSort[T](arr: ArrayBuffer[T])(implicit ordering: Ordering[T]): Unit = {
    sort(0, arr.length - 1)

    def sort(l: Int, r: Int)(implicit ordering: Ordering[T]): Unit = {
      val pivot = arr((l + r) / 2)
      var i = l
      var j = r
      while (i <= j) {
        while (ordering.compare(arr(i), pivot) < 0) i += 1
        while (ordering.compare(arr(j), pivot) > 0) j -= 1
        if (i <= j) {
          val t = arr(i)
          arr(i) = arr(j)
          arr(j) = t
          i += 1
          j -= 1
        }
      }
      if (l < j) sort(l, j)
      if (j < r) sort(i, r)
    }
  }

  def mergeSort[T](list : mutable.MutableList[T])(implicit ordering: Ordering[T]): Unit= {
    def mergeSortRec(list : mutable.MutableList[T]) : mutable.MutableList[T] = {
      def merge(left: mutable.MutableList[T], right: mutable.MutableList[T])
               (implicit ordering: Ordering[T]): mutable.MutableList[T] = {
        (left, right) match {
          case (mutable.MutableList(), mutable.MutableList()) => left
          case (mutable.MutableList(), _) => right
          case (_, mutable.MutableList()) => left
          case (_, _) =>
            if (ordering.compare(left.head, right.head) <= 0)
              left.head +: merge(left.tail, right)
            else
              right.head +: merge(left, right.tail)
        }
      }
      if (list.length == 1) list
      else {
        val mid = list.length / 2
        val (left, right) = list.splitAt(mid)
        merge(mergeSortRec(left), mergeSortRec(right))
      }
    }
    val t = mutable.MutableList.empty[T]
    mergeSortRec(list).foreach(x => t += x)
    list.clear()
    t.foreach(x => list += x)
  }
}
