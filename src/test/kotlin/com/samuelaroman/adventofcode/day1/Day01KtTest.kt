package com.samuelaroman.adventofcode.day1

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day01KtTest : FunSpec({

    val input = listOf(
        "1000",
        "2000",
        "3000",
        "",

        "4000",
        "5000",
        "6000",
        "",

        "7000",
        "8000",
        "9000",
        "",

        "10000",
    )

    test("part1") {
        part1(input) shouldBe Pair(4, 33)
    }

    test("part2") {
        part2(input) shouldBe 45
    }
})
