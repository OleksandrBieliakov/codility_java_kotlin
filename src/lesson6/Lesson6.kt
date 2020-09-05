package lesson6

import java.lang.Integer.max
import java.lang.reflect.Array

fun solutionDistinct(A: IntArray): Int {
    return HashSet<Int>(A.asList()).size
}

fun solutionTripletProduct(A: IntArray): Int {
    val size = A.size
    val sorted = A.sorted()

    val bottomTwo = sorted.slice(0..1)
    val topTwo = sorted.slice(size - 2 until size)

    val multiply = {acc: Int, i: Int -> acc * i}

    val topTwoProduct = topTwo.reduce(multiply)
    val bottomTwoProduct = bottomTwo.reduce(multiply)

    val biggestOfTopThree = sorted.last()
    val smallestOfTopThree = sorted[size - 3]

    val variant1 = topTwoProduct * smallestOfTopThree // topTwoProduct > bottomTwoProduct && smallestOfTopThree > 0
    val variant2 = bottomTwoProduct * biggestOfTopThree // bottomTwoProduct > topTwoProduct && biggestOfTopThree > 0 OR biggestOfTopThree is the only one of topThree greater than 0

    return max(variant1, variant2)
}

fun main() {
    val arr = intArrayOf(-5, 5, -5, 4)
    println(solutionTripletProduct(arr))
}
