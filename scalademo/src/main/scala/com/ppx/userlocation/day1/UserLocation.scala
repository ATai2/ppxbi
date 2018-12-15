package com.ppx.userlocation.day1

import org.apache.spark.{SparkConf, SparkContext}

object UserLocation {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("MoblieLocation").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val rdd1 = sc.textFile("E:\\code\\java\\ppxbi\\scalademo\\src\\main\\scala\\files\\userlocal\\19735E1C66.log").map(x => {
      val arr = x.split(",")
      val mb = (arr(0),arr(2))
      val flag = arr(3)
      var time = arr(1).toLong
      if (flag == "1") time = -time
      (mb, time)
    })
    println("rdd1:"+rdd1.collect.toBuffer)

    val rdd2 = rdd1.reduceByKey(_+_)
    println("rdd2:"+rdd2.collect.toBuffer)
    val rdd3 = sc.textFile("E:\\code\\java\\ppxbi\\scalademo\\src\\main\\scala\\files\\userlocal\\loc_info.txt").map(x => {
      val arr = x.split(",")
      val bs = arr(0)
      (bs, (arr(1), arr(2)))
    })
    println("rdd3:"+rdd3.collect.toBuffer)
    val rdd4 = rdd2.map(t => (t._1._2, (t._1._1, t._2)))
    println("rdd4:"+rdd4.collect.toBuffer)
    val rdd5 = rdd4.join(rdd3)
    println("rdd5:"+rdd5.collect.toBuffer)

    val rdd6 = rdd2.map(t => (t._1._1, t._1._2, t._2)).groupBy(_._1).values.map(it => {
      it.toList.sortBy(_._3).reverse
    })
    println(rdd6.collect.toBuffer)
  }
}
