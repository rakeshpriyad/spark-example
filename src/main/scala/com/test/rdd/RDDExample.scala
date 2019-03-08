package com.test.rdd

import org.apache.spark.sql.SparkSession

object RDDExample {
  def main(args: Array[String]) {
    // $example on:init_session$
    val spark = SparkSession
      .builder
      .appName("Spark Examples")
      .config("spark.master", "local")
      .getOrCreate()

    // Importing the SparkSession gives access to all the SQL functions and implicit conversions.
    import spark.implicits._
    // $example off:init_session$
    createRDD(spark)
    createRDD1(spark)
    createRDDFromCSV(spark)
    createRDDFromTXT(spark)
    createRDDFromExistingRDD(spark)
  }

  def createRDDFromExistingRDD(spark : SparkSession ): Unit ={
    val words=spark.sparkContext.parallelize(Seq("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"))
    val wordPair = words.map(w => (w.charAt(0), w))
    wordPair.foreach(println)
  }

  def createRDD(spark : SparkSession ): Unit ={
    val data=spark.sparkContext.parallelize(Seq(("maths",52),("english",75),("science",82), ("computer",65),("maths",85)))
    val sorted = data.sortByKey()
    sorted.foreach(println)
  }

  def createRDD1(spark : SparkSession ): Unit ={
    val rdd1 = spark.sparkContext.parallelize(Array("jan","feb","mar","april","may","jun"),3)
    val result = rdd1.coalesce(2)
    result.foreach(println)
  }

  def createRDDFromCSV(spark : SparkSession ): Unit ={
    val dataRDD = spark.read.csv("src/main/resources/people.csv").rdd
    //val result = rdd1.coalesce(2)
    dataRDD.foreach(println)
  }
  def createRDDFromTXT(spark : SparkSession ): Unit = {
    val dataRDD = spark.read.textFile("src/main/resources/kv1.txt").rdd
    dataRDD.foreach(println)
  }
}
