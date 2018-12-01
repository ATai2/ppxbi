package com.ppx.generic

/**
  * Created by ZX on 2016/3/31.
  * 在scala中泛型与java中的表示方式不同用"[]"
  * 例如[T <: Comparable[T]]表示上界，传入的为Comparable的子类
  */
class Pair[T <% Comparable[T]](val first: T, val second: T){
  def bigger = if(first.compareTo(second) > 0) first else second
}


object UpperBound {
  def main(args: Array[String]) {
    val p = new Pair(1, 5)
    println(p.bigger)
  }
}




