package com.ppx.streaming

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}


//  nc -lk 8888  input any strings.
object StreamingWordCount {
  def runProc(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("StreamingWordCount").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(5))

    val lines = ssc.socketTextStream("mini1", 8888)
    val words = lines.flatMap(_.split(' '))
    val pairs = words.map(word => (word, 1))
    val wordCount = pairs.reduceByKey(_ + _)
    wordCount.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
