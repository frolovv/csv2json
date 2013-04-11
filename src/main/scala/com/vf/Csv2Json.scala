package com.vf

import scala.util.parsing.json.{JSONType, JSONArray, JSONObject}
import java.io.FileWriter

object Csv2Json {
  def main(args: Array[String]) {
    val inputFile = args(0)
    val outputFile = args(1)
    val columns = splitLines(args(2))

    val lines = io.Source.fromFile(inputFile).getLines()

    val json = buildJson(lines, columns)

    writeTo(outputFile, json)
  }


  def writeTo(path: String, obj: Any) {
    val out = new FileWriter(path)
    out.write(obj.toString)
    out.close()
  }

  def buildJson(lines: Iterator[String], columns: Seq[String]): JSONType = {
    val apps = lines map {
      line =>
        val fields = splitLines(line)
        val zipped = columns zip fields

        JSONObject(zipped.toMap)
    }

    JSONArray(apps.toList)
  }


  def splitLines(line: String): Seq[String] = {
    line.split(",") map (_.trim)
  }
}
