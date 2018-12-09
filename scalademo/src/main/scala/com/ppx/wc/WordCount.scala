package com.ppx.wc

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("wc")
    val sc = new SparkContext()
    sc.textFile(args(0)).flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_+_, 1)
      .sortBy(_._2, ascending = false)
      .saveAsTextFile(args(1))
    sc.stop()
  }
}
