package com.samuelaroman.common

import java.io.File
import java.math.BigInteger
import java.nio.file.Paths
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun getPath() =
    Paths.get("").toAbsolutePath().toString()

fun readInput(name: String) =
    File(
        getPath() + File.separator + "/src/main/kotlin/com/samuelaroman/adventofcode/day" + name.get(name.lastIndex),
        "$name.txt"
    )
        .readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')
