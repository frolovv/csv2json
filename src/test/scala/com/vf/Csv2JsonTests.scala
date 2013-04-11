package com.vf

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import scala.util.parsing.json.{JSONObject, JSONArray}

class Csv2JsonTests extends ShouldMatchers with FlatSpec {
  "Csv2Json" should "build Json " in {
    val lines = List("1,2").iterator
    val columns = List("first", "second")

    val json = JSONArray(List(JSONObject(Map("first" -> "1", "second" -> "2"))))

    Csv2Json.buildJson(lines, columns) should equal(json)
  }
}
