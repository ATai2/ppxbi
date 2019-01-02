package com.ppx.spark.day5

//import kafka.serializer.StringDecoder
import io.netty.handler.codec.string.StringDecoder
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
//import org.apache.spark.streaming.kafka.{KafkaManager, KafkaUtils}
import org.apache.spark.streaming.{Seconds, StreamingContext}


object DirectKafkaWordCount {

  /*  def dealLine(line: String): String = {
      val list = line.split(',').toList
  //    val list = AnalysisUtil.dealString(line, ',', '"')// 把dealString函数当做split即可
      list.get(0).substring(0, 10) + "-" + list.get(26)
    }*/

  def processRdd(rdd: RDD[(String, String)]): Unit = {
    val lines = rdd.map(_._2)
    val words = lines.map(_.split(" "))
    val wordCounts = words.map(x => (x, 1L)).reduceByKey(_ + _)
    wordCounts.foreach(println)
  }

  def main(args: Array[String]) {
    if (args.length < 3) {
      System.err.println(
        s"""
           |Usage: DirectKafkaWordCount <brokers> <topics> <groupid>
           |  <brokers> is a list of one or more Kafka brokers
           |  <topics> is a list of one or more kafka topics to consume from
           |  <groupid> is a consume group
           |
        """.stripMargin)
      System.exit(1)
    }

    Logger.getLogger("org").setLevel(Level.WARN)

    val Array(brokers, topics, groupId) = args

    // Create context with 2 second batch interval
    val sparkConf = new SparkConf().setAppName("DirectKafkaWordCount")
    sparkConf.setMaster("local[*]")
    sparkConf.set("spark.streaming.kafka.maxRatePerPartition", "5")
    sparkConf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")

    val ssc = new StreamingContext(sparkConf, Seconds(2))

    // Create direct kafka stream with brokers and topics
    val topicsSet = topics.split(",").toSet
    val kafkaParams = Map[String, String](
      "metadata.broker.list" -> brokers,
      "group.id" -> groupId,
      "auto.offset.reset" -> "smallest"
    )

//    val km = new KafkaManager(kafkaParams)
//
//    val messages = km.createDirectStream[String, String, StringDecoder, StringDecoder](
//      ssc, kafkaParams, topicsSet)
//
//    messages.foreachRDD(rdd => {
//      if (!rdd.isEmpty()) {
//        // 先处理消息
//        processRdd(rdd)
//        // 再更新offsets
//        km.updateZKOffsets(rdd)
//      }
//    })

    ssc.start()
    ssc.awaitTermination()
  }
}
