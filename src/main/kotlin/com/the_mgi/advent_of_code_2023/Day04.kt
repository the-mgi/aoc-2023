package com.the_mgi.advent_of_code_2023

import java.io.File

data class Card(
  val id: Int,
  val winningNumbers: List<Int>,
  val myNumbers: List<Int>,
  val totalMatches: Int
)

fun List<String>.takeIfNumber(): List<String> {
  val list = mutableListOf<String>()
  for (i in this) {
    i.toIntOrNull() ?: continue
    list.add(i)
  }
  return list
}

fun String.substringBeforeAndAfter(delimiter: String): Pair<String, String> {
  val indexOfDelimiter = this.indexOf(delimiter)
  return Pair(this.substring(0, indexOfDelimiter), this.substring(indexOfDelimiter + 1))
}

fun winningAndMyCards(s: String): Triple<List<Int>, List<Int>, Int> {
  val (cardId, numbers) = s.substringBeforeAndAfter(":")
  val (winningNumbers, myNumbers) = numbers
    .trim()
    .split("|")
    .map { it.trim().split(" ").takeIfNumber().map { integer -> integer.toInt() } }
  return Triple(winningNumbers, myNumbers, cardId.lowercase().replace("card", "").trim().toInt())
}

fun calculateTotalSumOfWinningNumbers(inputString: String): Int {
  var totalSum = 0
  File(inputString)
    .readLines()
    .forEach { s ->
      val (winningNumbers, myNumbers, _) = winningAndMyCards(s)
      var multiplier = 1
      for (i in winningNumbers) {
        for (j in myNumbers) {
          if (i == j) {
            multiplier *= 2
          }
        }
      }

      totalSum += (multiplier / 2)
    }
  return totalSum
}

fun calculateTotalNumberOfScratchCards(inputString: String): Int {
  val completeList = mutableListOf<Card>()
  File(inputString)
    .readLines()
    .forEach { s ->
      var totalMatches = 0
      val (winningNumbers, myNumbers, cardId) = winningAndMyCards(s)
      for (i in winningNumbers) {
        for (j in myNumbers) {
          if (i == j) totalMatches += 1
        }
      }
      completeList.add(Card(cardId, winningNumbers, myNumbers, totalMatches))
    }

  val matchMap = mutableMapOf<Int, Card>()
  completeList.forEach {
    matchMap[it.id] = it
  }

  var index = 0
  while (index < completeList.size) {
    val card = completeList[index]
    if (card.totalMatches > 0) {
      for (i in 1..card.totalMatches) {
        completeList.add(matchMap[i + card.id]!!)
      }
    }
    index += 1
  }
  return completeList.size
}