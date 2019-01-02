package com.ppx.spark.day1

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 2016/5/16.
  */
object UserLocation {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("MoblieLocation").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val rdd1 = sc.textFile("c://bs_log").map(x => {
      val arr = x.split(",")
      val mb = (arr(0),arr(2))
      val flag = arr(3)
      var time = arr(1).toLong
      if (flag == "1") time = -time
      (mb, time)
    })
    val rdd2 = rdd1.reduceByKey(_+_)

    val rdd3 = sc.textFile("c://loc_info.txt").map(x => {
      val arr = x.split(",")
      val bs = arr(0)
      (bs, (arr(1), arr(2)))
    })

    val rdd4 = rdd2.map(t => (t._1._2, (t._1._1, t._2)))

    val rdd5 = rdd4.join(rdd3)


    val rdd6 = rdd2.map(t => (t._1._1, t._1._2, t._2)).groupBy(_._1).values.map(it => {
      it.toList.sortBy(_._3).reverse
    })
    println(rdd5.collect.toBuffer)
  }
}
