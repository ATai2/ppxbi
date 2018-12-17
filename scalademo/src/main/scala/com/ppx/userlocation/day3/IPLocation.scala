package com.ppx.userlocation.day3

import org.apache.spark.{SparkConf, SparkContext}

object IPLocation {

  def ip2Long(ip: String): Long = {
    val fragments = ip.split("[.]")
    var ipNum = 0L
    for (i <- 0 until fragments.length) {
      ipNum = fragments(i).toLong | ipNum << 8L
    }
    ipNum
  }

  def binarySearch(lines: Array[(String, String, String)], ip: Long): Int = {
    var low = 0
    var high = lines.length - 1
    while (low <= high) {
      val middle = (low + high) / 2
      if ((ip >= lines(middle)._1.toLong) && (ip <= lines(middle)._2.toLong))
        return middle
      if (ip < lines(middle)._1.toLong)
        high = middle - 1
      else {
        low = middle + 1
      }
    }
    -1
  }

  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[2]").setAppName("IpLocation")
    val sc = new SparkContext(conf)
    val ipRulesRdd = sc.textFile("D:\\code\\ppxbi\\scalademo\\src\\main\\scala\\files\\ip\\ip.txt")
      .map(line => {
        val fields = line.split("\\|")
        val start_num = fields(2)
        val end_num = fields(3)
        val province = fields(6)
        (start_num, end_num, province)
      })
    //全部的ip映射规则
    val ipRulesArrary = ipRulesRdd.collect()
    //广播规则
    val ipRulesBroadcast = sc.broadcast(ipRulesArrary)
    //加载要处理的数据
    val ipsRDD = sc.textFile("D:\\code\\ppxbi\\scalademo\\src\\main\\scala\\files\\ip\\20090121000132.394251.http.format").map(line => {
      val fields = line.split("\\|")
      fields(1)
    })

    val result = ipsRDD.map(ip => {
      val ipNum = ip2Long(ip)
      val index = binarySearch(ipRulesBroadcast.value, ipNum)
      val info = ipRulesBroadcast.value(index)
      info
    })
    println(result.collect().toBuffer)
    sc.stop()
  }
}
