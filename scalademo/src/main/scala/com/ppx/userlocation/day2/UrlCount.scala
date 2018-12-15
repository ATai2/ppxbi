package com.ppx.userlocation.day2

import java.net.URL

import org.apache.spark.{SparkConf, SparkContext}

/**
  * 取出学科点击前三的
  */
object UrlCount extends App {
  val conf = new SparkConf().setAppName("UrlCount").setMaster("local[2]")
  val sc = new SparkContext(conf)

  //rdd1将数据切分，元组中放的是（URL， 1）
  val rdd1 = sc.textFile("D:\\code\\ppxbi\\scalademo\\src\\main\\scala\\files\\webit\\itcast.log")
    .map(line => {
      val f = line.split("\t")
      (f(1), 1)
    })
  val rdd2 = rdd1.reduceByKey(_ + _)
  println("rdd2  "+rdd2.collect().toBuffer)
  val rdd3 = rdd2.map(t => {
    val url = t._1
    val host = new URL(url).getHost
    (host, url, t._2)
  })
  println("rdd3  "+rdd3.collect().toBuffer)
  val rdd4 = rdd3.groupBy(_._1).mapValues(it => {
    it.toList.sortBy(_._3).reverse.take(3)
  })

  println(rdd4.collect().toBuffer)
  sc.stop()

}


