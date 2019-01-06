package com.ppx.spark.day5


import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.{HashPartitioner, SparkConf}
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.{Seconds, StreamingContext}

object KafkaWordCount {

  val updateFunc = (iter: Iterator[(String, Seq[Int], Option[Int])]) => {
    //iter.flatMap(it=>Some(it._2.sum + it._3.getOrElse(0)).map(x=>(it._1,x)))
    iter.flatMap { case (x, y, z) => Some(y.sum + z.getOrElse(0)).map(i => (x, i)) }
  }

  def runProc(args: Array[String]) {
    val sparkConf = new SparkConf().setAppName("KafkaWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(sparkConf, Seconds(5))
    ssc.checkpoint("c://ck2")

    val kafkaStream = KafkaUtils.createRDD(streamingContext,
      [ZK quorum], [consumer group id], [per-topic number of Kafka partitions to consume])

    stream.map(record => (record.key, record.value))
    //    val data = KafkaUtils.createStreamcreateStream(ssc, zkQuorum, group, topicMap, StorageLevel.MEMORY_AND_DISK_SER)
    //    val words = stream.map(_._2).flatMap(_.split(" "))
    //    val wordCounts = words.map((_, 1)).updateStateByKey(updateFunc, new HashPartitioner(ssc.sparkContext.defaultParallelism), true)
    ssc.start()
    ssc.awaitTermination()
  }
}
