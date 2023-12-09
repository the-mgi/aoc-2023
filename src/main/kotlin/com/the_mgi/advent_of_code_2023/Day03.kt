package com.the_mgi.advent_of_code_2023

import java.io.File
import java.util.regex.Pattern

typealias Matrix = List<List<String>>

fun doParsing(allLines: Matrix): Int {
  var totalSum = 0

  val totalLines = allLines.size
  for ((i, str) in allLines.withIndex()) {
    val lineLength = str.size
    for ((j, nested) in str.withIndex()) {
      val currentNumberValue = str[j].toIntOrNull()
      if (i == 0 || j == 0 || i > totalLines - 1 || j > lineLength - 1 || currentNumberValue == null) {
        // special case will handle later
        continue
      }

      if (str[j + 1].toIntOrNull() == null && str[j + 1] != ".") totalSum += str[j].toInt() // right case
      if (str[j - 1].toIntOrNull() == null && str[j - 1] != ".") totalSum += str[j].toInt() // left case
    }
  }


  return totalSum
}

fun parse(inputFile: String): Matrix {
  val pattern = Pattern.compile("\\d+")
  return File(inputFile)
    .readLines()
    .map {
      val lengthRow = it.length
      val matcher = pattern.matcher(it)
      val elementList = mutableListOf<String>()

      for (c in it) {
        if (c.isDigit()) break
        elementList.add(c.toString())
      }

      while (matcher.find()) {
        val matchedValue = matcher.group() ?: continue
        val startSymbolIndex = it.indexOf(matchedValue) + matchedValue.length
        elementList.add(matchedValue)
        for (i in startSymbolIndex..<lengthRow) {
          if (it[i].isDigit()) break
          elementList.add(it[i].toString())
        }
      }
      elementList
    }
}

fun printMatrix(allLines: Matrix) {
  println("[")
  for (str in allLines) {
    for ((index, nested) in str.withIndex()) {
      print(nested)
      if (index < str.size - 1) {
        print(", ")
      } else {
        println()
      }
    }
  }
  println("]")
}
//
//fun main() {
// TODO()
//  val allLines =
//    parse("/Users/themgi/open-source/advent-of-code-2023/src/test/kotlin/com/the_mgi/advent_of_code_2023/day_03/input-day-03-part-01-case-01")
//}