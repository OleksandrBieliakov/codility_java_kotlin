package lesson9

fun solutionStockMarket(A: IntArray): Int {
    val size = A.size
    if (size < 2) {
        return 0
    }
    var bestBuyPrice = A[0]
    var bestProfit = 0
    var currentPrice: Int
    var currentProfit: Int
    for (day in 1 until size) {
        currentPrice = A[day]
        if (currentPrice < bestBuyPrice) {
            bestBuyPrice = currentPrice
        } else if (currentPrice > bestBuyPrice) {
            currentProfit = currentPrice - bestBuyPrice
            if (currentProfit > bestProfit) {
                bestProfit = currentProfit
            }
        }
    }
    return bestProfit
}

fun solutionWithNegative(A: IntArray): Int {
    var lastSum = A[0]
    var bestSum = A[0]
    var n: Int
    for (i in 1 until A.size) {
        n = A[i]
        if (bestSum < 0) {
            if (n < 0) {
                bestSum = maxOf(bestSum, n)
            } else {
                lastSum = n
                bestSum = n
            }
        } else {
            lastSum = maxOf(lastSum + n, 0)
            bestSum = maxOf(lastSum, bestSum)
        }
    }
    return bestSum
}


//incorrect solution and not in a state which passed tests for 92%
fun solution(A: IntArray): Int {
    val size = A.size
    var globalMax = 0

    //the must be one skipped value
    var skipped = A[1]
    var skippedLeftmostNegative = skipped < 0

    var currentSlice = 0
    var value: Int

    for (i in 2 until size - 1) {
        value = A[i]

        //the skipped value is non-negative
        if (skipped >= 0 && value < skipped) {
            if(currentSlice == 0) {
                skippedLeftmostNegative = true
            }
            currentSlice += skipped
            skipped = value
            globalMax = maxOf(currentSlice, globalMax)
        }

        //may want to skip a value if it's negative
        else if (value < 0 && currentSlice != 0) {

            //current slice is capped when adding value to the right of the slice will result in negative slice sum for any skipped value of the slice
            if (currentSlice + skipped < 0 && currentSlice + value < 0) {
                globalMax = maxOf(currentSlice, globalMax)
                skipped = 0
                currentSlice = 0
            }
            //comparison of a slice with old skipped value against a slice where the the old skipped value is
            //included and the current encountered negative value is skipped
            else {
                if (skippedLeftmostNegative) {
                    skipped = value
                    skippedLeftmostNegative = false
                } else {
                    currentSlice += maxOf(value, skipped)
                    skipped = minOf(value, skipped)
                    globalMax = maxOf(currentSlice, globalMax)
                }
            }
        }

        //if a value is non-negative it's added to the current slice sum
        else {
            currentSlice += value
            globalMax = maxOf(currentSlice, globalMax)
        }
    }

    globalMax = maxOf(globalMax, currentSlice)
    return globalMax
}

fun main() {
    //val arr = intArrayOf(3, 2, 6, -1, 4, 5, -1, 2)
    //val arr = intArrayOf(5, 17, 0, 3)
    //val arr = intArrayOf(0, 10, -5, -2, 0)
    val arr = intArrayOf(1, -1, 1, -1, 1, -1)
    println(solution(arr))
}