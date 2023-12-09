package com.the_mgi.advent_of_code_2023

fun main() {
  // ========================================= Question # 01 ========================================= //
  val basePathQ1 =
    "/Users/themgi/open-source/advent-of-code/aoc-2023/src/test/kotlin/com/the_mgi/advent_of_code_2023/day_01/"

  val partOneCase01Q1 = calibrationValues("${basePathQ1}input-day-01-part-01-case-01")
  assert(partOneCase01Q1 == 142)
  val part01Case02Q1 = calibrationValues("${basePathQ1}input-day-01-part-01-case-02")
  assert(part01Case02Q1 == 54081)
  println(partOneCase01Q1)
  println(part01Case02Q1)

  val part02Case01Q1 = calibrateValuesWithStringNames("${basePathQ1}input-day-01-part-02-case-01")
  assert(part02Case01Q1 == 281)
  val part02Case02Q1 = calibrateValuesWithStringNames("${basePathQ1}input-day-01-part-02-case-02")
  assert(part02Case02Q1 == 54649)
  println(part02Case01Q1)
  println(part02Case02Q1)

  // ========================================= Question # 02 ========================================= //
  val basePathQ2 =
    "/Users/themgi/open-source/advent-of-code/aoc-2023/src/test/kotlin/com/the_mgi/advent_of_code_2023/day_02/"
  val part01Case01Q2 = calculateTotalSumOfGameIds("${basePathQ2}input-day-02-part-01-case-01")
  assert(part01Case01Q2 == 8)
  val part01Case02Q2 = calculateTotalSumOfGameIds("${basePathQ2}input-day-02-part-01-case-02")
  assert(part01Case02Q2 == 2076)
  println(part01Case01Q2)
  println(part01Case02Q2)

  val part02Case01Q2 = calculateMinimumNumberPowerSet("${basePathQ2}input-day-02-part-01-case-01")
  assert(part01Case01Q2 == 2286)
  val part02Case02Q2 = calculateMinimumNumberPowerSet("${basePathQ2}input-day-02-part-01-case-02")
  assert(part01Case01Q2 == 70950)
  println(part02Case01Q2)
  println(part02Case02Q2)

  // ========================================= Question # 04 ========================================= //
  val basePathQ4 =
    "/Users/themgi/open-source/advent-of-code/aoc-2023/src/test/kotlin/com/the_mgi/advent_of_code_2023/day_04/"
  val part01Case01 =
    calculateTotalSumOfWinningNumbers("${basePathQ4}input-day-04-part-01-case-01")
  println(part01Case01)

  val part01Case02 =
    calculateTotalSumOfWinningNumbers("${basePathQ4}input-day-04-part-01-case-02")
  println(part01Case02)

  val part02Case01 =
    calculateTotalNumberOfScratchCards("${basePathQ4}input-day-04-part-01-case-01")
  println(part02Case01)

  val part02Case02 =
    calculateTotalNumberOfScratchCards("${basePathQ4}input-day-04-part-01-case-02")
  println(part02Case02)
}