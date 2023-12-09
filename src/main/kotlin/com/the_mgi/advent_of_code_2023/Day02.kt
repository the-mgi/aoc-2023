package com.the_mgi.advent_of_code_2023

import java.io.File

val valueMap = mapOf(
  "red" to 12,
  "green" to 13,
  "blue" to 14
)

fun calculateTotalSumOfGameIds(inputFile: String, initialMap: Map<String, Int> = valueMap) = File(inputFile)
  .readLines()
  .filter {
    val string = it.lowercase()
    val (_, sets) = string.split(":")
    sets.split(";").forEach { set ->
      val currentMap = mutableMapOf<String, Int>()
      set.split(",").forEach { colorAndCount ->
        val (totalCount, color) = colorAndCount.trim().split(" ")
        val trimmedColor = color.trim()
        if (!currentMap.containsKey(trimmedColor)) {
          currentMap[trimmedColor] = 0
        }

        currentMap[trimmedColor] = currentMap[trimmedColor]!! + totalCount.trim().toInt()
      }

      if (currentMap.size <= initialMap.size && initialMap.keys.containsAll(currentMap.keys)) {
        for (key in currentMap.keys) {
          val initialMapValue = initialMap[key]!!
          val currentMapValue = currentMap[key]!!
          if (currentMapValue > initialMapValue) return@filter false
        }
      }
    }

    return@filter true
  }
  .sumOf {
    val (gameId, _) = it.split(":")
    gameId.split(" ")[1].trim().toInt()
  }


fun calculateMinimumNumberPowerSet(inputFile: String) = File(inputFile)
  .readLines()
  .sumOf {
    val string = it.lowercase()
    val (_, sets) = string.split(":")
    val minValueMap = mutableMapOf<String, Int>()
    sets.split(";").forEach { set ->
      set.split(",").forEach { colorAndCount ->
        val (totalCount, color) = colorAndCount.trim().split(" ")
        val intValue = totalCount.trim().toInt()
        val trimmedColor = color.trim()
        if (!minValueMap.containsKey(trimmedColor)) {
          minValueMap[trimmedColor] = intValue
        }

        if (minValueMap[trimmedColor]!! < intValue) {
          minValueMap[trimmedColor] = intValue
        }
      }
    }
    minValueMap.values.reduce { acc, i -> acc * i }
  }