package com.samuelaroman.adventofcode.day1

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day01KtTest : FunSpec({

    val input = listOf(
        "1",
        "2",
        "3",
        "",
        "4",
        "5",
        "6",
        "",
        "7",
        "8",
        "9",
        "",
        "10",
        "11",
        "12",
    )

    test("part1") {
        part1(input) shouldBe Pair(4, 33)
    }

    test("part2") {
        part2(input) shouldBe 45
    }
})
