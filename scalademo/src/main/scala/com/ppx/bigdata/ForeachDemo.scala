package com.ppx.bigdata

import org.apache.spark.{SparkConf, SparkContext}

object ForeachDemo {
  //  本地开发， loacal【*】 用几个线程
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ForeachDemo").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd1 = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 9), 3)
    rdd1.foreach(x => println(x))
    sc.stop()
  }
}
