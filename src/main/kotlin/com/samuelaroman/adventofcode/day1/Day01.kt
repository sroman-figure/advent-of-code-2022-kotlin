package com.samuelaroman.adventofcode.day1

import com.samuelaroman.common.readInput

fun part1(input: List<String>): Pair<Int, Int> {
    var elfWithMostCalories: Pair<Int, Int> = Pair(0, 0)
    var currentElfCalorieCount: Int = 0
    var currentElfPosition: Int = 1
    input.forEachIndexed { index, foodItem ->
        // when is null or blank it is a different elf
        if (!foodItem.isNullOrBlank() && index != input.size - 1) {
            // Add to elf's calorie count
            foodItem.toInt().let {
                currentElfCalorieCount += it
            }
        } else {
            if (index == input.size - 1) {
                // Add last item
                foodItem.toInt().let {
                    currentElfCalorieCount += it
                }
            }
            if (currentElfCalorieCount > elfWithMostCalories.second) {
                elfWithMostCalories = Pair(currentElfPosition, currentElfCalorieCount)
            }
            currentElfCalorieCount = 0
            currentElfPosition++
        }
    }

    println("part1: mostCaloriesByElf = ${elfWithMostCalories}")

    return elfWithMostCalories
}

// Top 3 Elfs in terms of calories
fun part2(input: List<String>): Int {
    var elfsWithMostCalories = mutableListOf<Int>()
    var currentElfCalorieCount: Int = 0
    input.forEach { foodItem ->
        // when is null or blank, it is a different elf
        if (!foodItem.isNullOrBlank()) {
            // Add to elf's calorie count
            foodItem.toInt().let {
                currentElfCalorieCount += it
            }
        } else {
            // compare elf to top 3
            if (elfsWithMostCalories.size < 3) {
                elfsWithMostCalories.add(currentElfCalorieCount)
            } else {
                elfsWithMostCalories.sort()
                if (currentElfCalorieCount > elfsWithMostCalories[0]) {
                    elfsWithMostCalories[0] = currentElfCalorieCount
                }
            }
            currentElfCalorieCount = 0
        }
    }

    println("part2: array=${elfsWithMostCalories} sum=${elfsWithMostCalories.sum()}")

    return elfsWithMostCalories.sum()
}

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01")
    part1(testInput)

    // part 2
    part2(testInput)
}
