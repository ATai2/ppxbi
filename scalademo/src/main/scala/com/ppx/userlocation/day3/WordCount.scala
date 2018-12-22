package com.ppx.userlocation.day3

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]) {
    //非常重要，是通向Spark集群的入口
    val conf = new SparkConf().setAppName("WC")
      .setJars(Array("D:\\code\\ppxbi\\scalademo\\target\\scalademo-2.0.jar"))
      .setMaster("spark://mini1:7077")
    val sc = new SparkContext(conf)

    sc.textFile(args(0)).flatMap(_.split(" ")).map((_, 1))
      .reduceByKey(_ + _).sortBy(_._2, false).saveAsTextFile(args(1))
    sc.stop()
  }
}
