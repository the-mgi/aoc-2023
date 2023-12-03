package com.the_mgi.advent_of_code_2023.day_01

import java.io.File

fun calibrationValues(filePath: String) =
    File(filePath)
        .readLines()
        .sumOf {
            (it.first { char -> char.isDigit() }.toString() + it.last { char -> char.isDigit() }.toString()).toInt()
        }

val map = mapOf(
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9
)

fun calibrateValuesWithStringNames(filePath: String) = File(filePath)
    .readLines()
    .sumOf { str ->
        val firstIndexString = str.findAnyOf(map.keys)
        val firstIndexInt = str.indexOfFirst { char -> char.isDigit() }
        var finalString = ""
        if (firstIndexString != null) {
            finalString += if (firstIndexString.first < firstIndexInt || firstIndexInt == -1) map[firstIndexString.second]!! else str[firstIndexInt].toString()
        } else {
            finalString += str[firstIndexInt]
        }

        val secondIndexString = str.findLastAnyOf(map.keys)
        val secondIndexInt = str.indexOfLast { char -> char.isDigit() }
        if (secondIndexString != null) {
            finalString += if (secondIndexString.first > secondIndexInt || secondIndexInt == -1) map[secondIndexString.second]!! else str[secondIndexInt].toString()
        } else {
            finalString += str[secondIndexInt]
        }
        finalString.toInt()
    }

fun main() {
    val basePath =
        "/Users/themgi/open-source/advent-of-code-2023/src/test/kotlin/com/the_mgi/advent_of_code_2023/day_01/"

    val partOneCase01 = calibrationValues("${basePath}input-day-01-part-01-case-01")
    assert(partOneCase01 == 142)
    val part01Case02 = calibrationValues("${basePath}input-day-01-part-01-case-02")
    assert(part01Case02 == 54081)
    println(partOneCase01)
    println(part01Case02)

    val part02Case01 = calibrateValuesWithStringNames("${basePath}input-day-01-part-02-case-01")
    assert(part02Case01 == 281)
    val part02Case02 = calibrateValuesWithStringNames("${basePath}input-day-01-part-02-case-02")
    assert(part02Case02 == 54649)
    println(part02Case01)
    println(part02Case02)
}