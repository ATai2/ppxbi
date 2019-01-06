package com.ppx

import com.ppx.spark.day5.{LoggerLevels, StateFulWordCount}
import com.ppx.streaming.StreamingWordCount
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Hello world!
  *
  */
object App {
  def main(args: Array[String]): Unit = {
    LoggerLevels.setStreamingLogLevels()
//    StreamingWordCount.runProc(args)
//    StateFulWordCount.runProc(args)
    StateFulWordCount.runProc(args)
  }
}

//object App extends Application {
//  println( "Hello World!" )
//}
