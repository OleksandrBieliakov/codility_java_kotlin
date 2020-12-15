package lesson10

import kotlin.math.sqrt

fun solutionFactorsCounter(N: Int): Int {
    var factors = 0
    var i = 1
    val sqrtN = sqrt(N.toDouble())
    while (i < sqrtN) {
        if (N % i == 0) {
            factors += 2
            val nByi = N / i
            print("$i $nByi ")
        }
        i++
    }
    if (i.toDouble() == sqrtN) {
        factors++
        print("$i")
    }
    return factors
}

fun solutionMinPerimeter(N: Int): Int {
    var minPerimeter = (N + 1) * 2
    var perimeter: Int
    var i = 1
    val sqrtN = sqrt(N.toDouble())
    while (i < sqrtN) {
        if (N % i == 0) {
            perimeter = (i + N / i) * 2
            minPerimeter = minOf(minPerimeter, perimeter)
        }
        i++
    }
    if (i.toDouble() == sqrtN) {
        minPerimeter = i * 4
    }
    return minPerimeter
}

fun solutionPeaks(A: IntArray): Int {
    //println(A.contentToString())
    if (A.size < 3) {
        return 0
    }
    val peaksCounters = IntArray(A.size)
    for (i in 1 until A.size - 1) {
        if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
            peaksCounters[i] = peaksCounters[i - 1] + 1
        } else {
            peaksCounters[i] = peaksCounters[i - 1]
        }
    }
    peaksCounters[A.size - 1] = peaksCounters[A.size - 2]
    //println(peaksCounters.contentToString())

    var maxBlocks = peaksCounters[peaksCounters.size - 1]
    var success: Boolean
    var lastBlock: Int
    var currentBlock: Int
    var blockSize: Int

    while (maxBlocks > 0) {
        success = true
        if (A.size % maxBlocks == 0) {
            blockSize = A.size / maxBlocks
            lastBlock = peaksCounters[blockSize - 1]
            if (lastBlock == 0) {
                success = false
            } else {
                for (i in 2..maxBlocks) {
                    currentBlock = peaksCounters[i * blockSize - 1]
                    if (currentBlock == lastBlock) {
                        success = false
                        break
                    } else {
                        lastBlock = currentBlock
                    }
                }
            }
            if (success) {
                return maxBlocks
            }
        }
        maxBlocks--
    }

    return maxBlocks
}


fun solutionFlags(A: IntArray): Int {
    val peaks = mutableListOf<Int>()
    for (i in 1 until A.size - 1) {
        if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
            peaks.add(i)
        }
    }

    var flags = peaks.size

    if (flags == 0 || flags == 1) {
        return flags
    }

    //println(peaks)

    val firstPeakInd = peaks[0]
    val lastPeakInd = peaks[peaks.size - 1]
    val distanceFromFirstToLastPeak = lastPeakInd - firstPeakInd

    while (flags * (flags - 1) > distanceFromFirstToLastPeak) {
        flags--
    }

    var currentFlags: Int
    var currentInd: Int
    var currentPeak: Int
    while(flags > 1) {
        currentFlags = 1
        currentInd = firstPeakInd
        currentPeak = 0

        while (currentInd <= lastPeakInd) {
            currentInd += flags

            while (currentPeak < peaks.size) {
                currentPeak++
                if(currentPeak < peaks.size && peaks[currentPeak] >= currentInd) {
                    currentFlags++
                    currentInd = peaks[currentPeak]
                    break
                }
            }

        }

        if(currentFlags == flags) {
            return flags
        }
        flags--
    }

    return flags
}

fun main() {
    //flags
    //val arr = intArrayOf(1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2)
    //val arr = intArrayOf(0, 0, 0, 0, 0, 1, 0, 1, 0, 1)
    //val arr = intArrayOf(1,3,2)
}