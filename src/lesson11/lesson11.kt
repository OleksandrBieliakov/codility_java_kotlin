package lesson11

import kotlin.math.sqrt

fun sieve(n: Int): IntArray {
    val factors = IntArray(n + 1) { 0 }
    val sqrtN = sqrt(n.toDouble()).toInt()
    for (i in 2..sqrtN)
        if (factors[i] == 0)
            for (k in (i * i)..n step i)
                if (factors[k] == 0)
                    factors[k] = i
    return factors
}

fun putFactor(factor: Int, factors: MutableMap<Int, Int>) {
    val counter = factors[factor]
    if (counter == null) {
        factors[factor] = 1
    } else {
        factors[factor] = counter + 1
    }
}

fun primeFactors(n: Int, sieve: IntArray): Map<Int, Int> {
    val primeFactors = mutableMapOf<Int, Int>()
    var x = n
    while (sieve[x] > 0) {
        putFactor(sieve[x], primeFactors)
        x /= sieve[x]
    }
    if (n != 1) {
        putFactor(x, primeFactors)
    }
    putFactor(1, primeFactors)
    return primeFactors
}

fun allPrimeFactors(numbers: IntArray, sieve: IntArray): List<Map<Int, Int>> {
    val allPrimeFactors = mutableListOf<Map<Int, Int>>()
    for (number in numbers) {
        allPrimeFactors.add(primeFactors(number, sieve))
    }
    return allPrimeFactors
}

fun isDivisor(divisorPrimeFactors: Map<Int, Int>, dividendPrimeFactors: Map<Int, Int>): Boolean {
    for (factor in divisorPrimeFactors.keys) {
        if (!dividendPrimeFactors.containsKey(factor) || dividendPrimeFactors[factor]!! < divisorPrimeFactors[factor]!!) {
            return false
        }
    }
    return true
}

fun nonDivisorsNumber(index: Int, allPrimeFactors: List<Map<Int, Int>>): Int {
    var nonDivisorsNumber = 0
    val checkedPrimeFactors = allPrimeFactors[index]
    for (i in allPrimeFactors.indices) {
        if (i != index && !isDivisor(allPrimeFactors[i], checkedPrimeFactors)) {
            nonDivisorsNumber++
        }
    }
    return nonDivisorsNumber
}

fun allNonDivisorsNumbers(allPrimeFactors: List<Map<Int, Int>>): IntArray {
    val allNonDivisorsNumbers = IntArray(allPrimeFactors.size)
    for (i in allPrimeFactors.indices) {
        allNonDivisorsNumbers[i] = nonDivisorsNumber(i, allPrimeFactors)
    }
    return allNonDivisorsNumbers
}

fun solution(A: IntArray): IntArray {
    val sieve = sieve(A.max()!!)
    val allPrimeFactors = allPrimeFactors(A, sieve)
    //println(allPrimeFactors)
    return allNonDivisorsNumbers(allPrimeFactors)
}

fun main() {
    val arr = intArrayOf(3, 1, 2, 3, 6) //[2, 4, 3, 2, 0]
    //val arr = intArrayOf(2, 4) //[1, 0]
    //val arr = intArrayOf(1) //[1, 0]
    println(solution(arr).contentToString())
}