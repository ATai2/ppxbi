package com.ppx.userlocation.day2

import org.apache.spark.{SparkConf, SparkContext}

/**
  * ((fields(0),fields(2)), timeLong) -->reduceByKey(_+_).map --> (lac, (mobile, time))
  *     -->rdd1.join(rdd2).map-->(mobile, lac, time, x, y)
  *     --> groupBy().mapValues(以时间排序,取出前2个) --> (手机->((m,s,t)(m,s,t)))
  * Created by root on 2016/5/16.
  */
object AdvUserLocation {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("AdvUserLocation").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val rdd0 = sc.textFile("D:\\code\\ppxbi\\scalademo\\src\\main\\scala\\files\\userlocal").map( line => {
      val fields = line.split(",")
      val eventType = fields(3)
      val time = fields(1)
      val timeLong = if(eventType == "1")  -time.toLong else time.toLong
      ((fields(0),fields(2)), timeLong)
    })
    val rdd1 = rdd0.reduceByKey(_+_).map(t => {
      val mobile = t._1._1
      val lac = t._1._2
      val time = t._2
      (lac, (mobile, time))
    })
    val rdd2 = sc.textFile("D:\\code\\ppxbi\\scalademo\\src\\main\\scala\\files\\loc").map(line => {
      val f = line.split(",")
      //(基站ID， （经度，纬度）)
      (f(0), (f(1), f(2)))
    })
    //rdd1.join(rdd2)-->(CC0710CC94ECC657A8561DE549D940E0,((18688888888,1300),(116.303955,40.041935)))
    val rdd3 = rdd1.join(rdd2).map(t => {
      val lac = t._1
      val mobile = t._2._1._1
      val time = t._2._1._2
      val x = t._2._2._1
      val y = t._2._2._2
      (mobile, lac, time, x, y)
    })
    //rdd4分组后的
    val rdd4 = rdd3.groupBy(_._1)
    val rdd5 = rdd4.mapValues(it => {
      it.toList.sortBy(_._3).reverse.take(2)
    })
        println(rdd1.join(rdd2).collect().toBuffer)
        println(rdd5.collect().toBuffer)
    rdd5.saveAsTextFile("out")
    sc.stop()
  }
}
