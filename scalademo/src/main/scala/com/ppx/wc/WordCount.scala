package com.ppx.wc

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val conf=new SparkConf().setAppName("wc")
    val sc=new SparkContext()
    sc.textFile(args(0)).flatMap(_.split(" "))
      .map((_,1))
      .reduceByKey(_+_)
      .sortBy(_._2,false)
    sc.stop()
  }
}
