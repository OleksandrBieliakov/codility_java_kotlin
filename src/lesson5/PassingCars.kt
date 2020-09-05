package lesson5

fun solution(A: IntArray): Int {
    var zeroesCounter = 0
    var pairsCounter = 0
    for (i in A) {
        if (i == 0)
            zeroesCounter++
        else {
            pairsCounter += zeroesCounter
            if (pairsCounter > 1_000_000_000)
                return -1
        }
    }
    return pairsCounter
}