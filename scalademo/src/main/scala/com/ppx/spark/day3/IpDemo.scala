package com.ppx.spark.day3

import java.io.{BufferedReader, FileInputStream, InputStreamReader}

import scala.collection.mutable.ArrayBuffer

object IPLocationDemo {

  def ip2Long(ip: String): Long = {
    val fragments = ip.split("[.]")
    var ipNum = 0L
    for (i <- 0 until fragments.length){
      ipNum =  fragments(i).toLong | ipNum << 8L
    }
    ipNum
  }

  def readData(path: String) = {
    val br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))
    var s: String = null
    var flag = true
    val lines = new ArrayBuffer[String]()
    while (flag)
    {
      s = br.readLine()
      if (s != null)
        lines += s
      else
        flag = false
    }
    lines
  }

  def binarySearch(lines: ArrayBuffer[String], ip: Long) : Int = {
    var low = 0
    var high = lines.length - 1
    while (low <= high) {
      val middle = (low + high) / 2
      if ((ip >= lines(middle).split("\\|")(2).toLong) && (ip <= lines(middle).split("\\|")(3).toLong))
        return middle
      if (ip < lines(middle).split("\\|")(2).toLong)
        high = middle - 1
      else {
        low = middle + 1
      }
    }
    -1
  }

  def main(args: Array[String]) {
    val ip = "120.55.185.61"
    val ipNum = ip2Long(ip)
    println(ipNum)
    val lines = readData("c:/ip.txt")
    val index = binarySearch(lines, ipNum)
    print(lines(index))
  }
}
