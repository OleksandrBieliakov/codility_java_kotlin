package lesson6

import java.lang.Integer.max

fun solutionDistinct(A: IntArray): Int {
    return HashSet<Int>(A.asList()).size
}

fun solutionTripletProduct(A: IntArray): Int {
    val size = A.size
    val sorted = A.sorted()

    val bottomTwo = sorted.slice(0..1)
    val topTwo = sorted.slice(size - 2 until size)

    val multiply = { acc: Int, i: Int -> acc * i }

    val topTwoProduct = topTwo.reduce(multiply)
    val bottomTwoProduct = bottomTwo.reduce(multiply)

    val biggestOfTopThree = sorted.last()
    val smallestOfTopThree = sorted[size - 3]

    val variant1 = topTwoProduct * smallestOfTopThree // topTwoProduct > bottomTwoProduct && smallestOfTopThree > 0
    val variant2 = bottomTwoProduct * biggestOfTopThree // bottomTwoProduct > topTwoProduct && biggestOfTopThree > 0 OR biggestOfTopThree is the only one of topThree greater than 0

    return max(variant1, variant2)
}

fun main() {

}

fun isTriangle(first: Int, second: Int, third: Int): Boolean {
    return first >= 0 && first > third - second && second > first - third && first > second - third
}

fun solutionTriangle(A: IntArray): Int {
    if (A.size < 3)
        return 0
    A.sort()
    for (i in 0 until A.size - 2)
        if (isTriangle(A[i], A[i + 1], A[i + 2]))
            return 1
    return 0
}

class Disc(center: Int, radius: Int) : Comparable<Disc> {
    private val leftEdge: Int = center - radius
    private val rightEdge: Int = center + radius

    override fun compareTo(other: Disc): Int {
        return this.leftEdge - other.leftEdge
    }

    fun intersects(other: Disc): Boolean {
        return this.rightEdge >= other.leftEdge
    }
}

fun solutionDiscs(A: IntArray): Int {
    val discs = A.mapIndexed { center, radius -> Disc(center, radius) }.sorted()
    var intersections = 0
    for (i in 0 until discs.size - 1)
        for (j in i + 1 until discs.size) {
            if (discs[i].intersects(discs[j])) {
                intersections++
                if (intersections > 10_000_000)
                    return -1
            } else
                break
        }
    return intersections
}