package com.ppx.spark.day2

import java.net.URL

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/5/16.
  */
object UrlCount {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("UrlCount").setMaster("local[2]")
    val sc = new SparkContext(conf)

    //rdd1将数据切分，元组中放的是（URL， 1）
    val rdd1 = sc.textFile("c://itcast.log").map(line => {
      val f = line.split("\t")
      (f(1), 1)
    })
    val rdd2 = rdd1.reduceByKey(_+_)

    val rdd3 = rdd2.map(t => {
      val url = t._1
      val host = new URL(url).getHost
      (host, url, t._2)
    })

    val rdd4 = rdd3.groupBy(_._1).mapValues(it => {
      it.toList.sortBy(_._3).reverse.take(3)
    })

    println(rdd4.collect().toBuffer)
    sc.stop()

  }
}
