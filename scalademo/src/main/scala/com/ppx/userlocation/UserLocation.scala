package com.ppx.userlocation

import org.apache.spark.{SparkConf, SparkContext}

object UserLocation extends App {

  val conf=new SparkConf().setAppName("Foreach")
    .setMaster("local[2]")

  val sc=new SparkContext(conf)
  sc.textFile()

}
