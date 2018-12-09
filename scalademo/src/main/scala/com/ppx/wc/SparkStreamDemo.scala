package com.ppx.wc

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreamDemo extends App {
  val batch=10
//  val ssc=new StreamingContext(sc,Seconds(batch))
  val conf=new SparkConf().setAppName("NginxAnay")
  val ssc=new StreamingContext(conf,Seconds(batch))
  val lines=ssc.textFileStream("hdfs:///mini1:9000/streaming")
  lines.count().print()

}
