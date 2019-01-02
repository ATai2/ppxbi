package com.ppx.spark.day2

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/5/16.
  */
object ForeachDemo {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("ForeachDemo").setMaster("local")
    val sc = new SparkContext(conf)


    //RDD[(K,V)]
    //
    //

    sc.stop()

  }
}
