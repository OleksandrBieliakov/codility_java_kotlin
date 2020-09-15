package lesson8

import kotlin.random.Random

fun solutionDominator(A: IntArray): Int {
    var candidate = -1
    var size = 0
    for (n in A) {
        if (size == 0) {
            candidate = n
            size = 1
        } else {
            if (candidate == n)
                size++
            else
                size--
        }
    }
    return if (size > 0 && A.count { it == candidate } > A.size / 2) A.indexOf(candidate) else -1
}

fun solutionEquiLeader(A: IntArray): Int {
    val leaderFirstIndex = solutionDominator(A)
    if(leaderFirstIndex == -1) return 0
    val leader = A[leaderFirstIndex]
    var counter = 0
    var leaderCounterLeft = 0
    var leaderCounterRight = A.count { it == leader }
    val size = A.size
    var halfSizeLeft: Int
    var halfSizeRight: Int
    for(i in leaderFirstIndex until size) {
        if(A[i] == leader) {
            leaderCounterLeft++
            leaderCounterRight--
        }
        halfSizeLeft = (i + 1) / 2
        halfSizeRight = (size - (i + 1)) / 2
        if(leaderCounterLeft > halfSizeLeft && leaderCounterRight > halfSizeRight)
            counter++
    }
    return counter
}

// success with probability m/n
fun event(m: Int, n: Int): Boolean {
    return Random.nextInt(n) > n - (m + 1)
}

fun gates(n: Int): Double {
    var success = 0
    for(i in 0..n) {
        if((event(2, 3) && event(2, 3)) || event(2, 3))
            success++
    }
    return success.toDouble()/n
}

fun main() {
    println(gates(1_000_000))
}