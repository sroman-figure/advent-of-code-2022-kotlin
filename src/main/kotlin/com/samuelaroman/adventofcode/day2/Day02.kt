package com.samuelaroman.adventofcode.day2

import com.samuelaroman.common.readInput

// A & X - Rock
// B & Y - Paper
// C & Z - Scissors
// 0 - Lost
// 6 - Won
// 3 - Draw
val scoreMapPart1 = hashMapOf<String, Int>(
    pairs = arrayOf(
        "A X" to 1 + 3,
        "A Y" to 2 + 6,
        "A Z" to 3 + 0,
        "B X" to 1 + 0,
        "B Y" to 2 + 3,
        "B Z" to 3 + 6,
        "C X" to 1 + 6,
        "C Y" to 2 + 0,
        "C Z" to 3 + 3,
    )
)

fun part1(input: List<String>) {
    var totalScore = 0
    input.forEach { round ->
        scoreMapPart1[round]?.let {
            totalScore += it
        }
    }

    println("part1: totalScore = $totalScore")
}

// A & X - Rock
// B & Y - Paper
// C & Z - Scissors
// X - lose
// Y - draw
// Z - win
val myMoveLookUp = hashMapOf<String, String>(
    pairs = arrayOf(
        // they select Rock
        "A X" to "Z",
        "A Y" to "X",
        "A Z" to "Y",

        // They select Paper
        "B X" to "X",
        "B Y" to "Y",
        "B Z" to "Z",

        // they select Scissors
        "C X" to "Y",
        "C Y" to "Z",
        "C Z" to "X"
    )
)

fun part2(input: List<String>) {
    var totalScore = 0
    input.forEach { round ->
        val myMove = myMoveLookUp.get(round)
        val myOpponentsMove = round.split(" ").get(0)

        val score = scoreMapPart1["$myOpponentsMove $myMove"]
        score?.let {
            totalScore += it
        }
    }

    println("part2: totalScore = $totalScore")
}

fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02")
    part1(testInput)

    part2(testInput)
}
