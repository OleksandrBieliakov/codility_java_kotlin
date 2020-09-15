package lesson7

fun solutionBrackets(S: String): Int {
    val openingBracketsTypes = arrayOf('(', '[', '{')
    val bracketsEncountered = mutableListOf<Char>()
    for (ch in S) {
        if (ch in openingBracketsTypes) {
            bracketsEncountered.add(ch)
        } else if (ch == ')' && (bracketsEncountered.size == 0 || bracketsEncountered.removeLast() != '(')) {
            return 0
        } else if (ch == ']' && (bracketsEncountered.size == 0 || bracketsEncountered.removeLast() != '[')) {
            return 0
        } else if (ch == '}' && (bracketsEncountered.size == 0 || bracketsEncountered.removeLast() != '{')) {
            return 0
        }
    }
    if (bracketsEncountered.size != 0) {
        return 0
    }
    return 1
}

fun solutionFish(A: IntArray, B: IntArray): Int {
    val downstream = mutableListOf<Int>()
    var survived = 0
    for (i in B.indices) {
        if (B[i] == 0) {
            if (downstream.isEmpty()) {
                survived++
            } else {
                val currentUpstream = A[i]
                var currentSurvived = true
                var lastDownstream = downstream.last()
                while (downstream.isNotEmpty()) {
                    if (lastDownstream > currentUpstream) {
                        currentSurvived = false
                        break
                    }
                    downstream.removeAt(downstream.size - 1)
                    if (downstream.isNotEmpty()) {
                        lastDownstream = downstream.last()
                    }
                }
                if (currentSurvived) {
                    survived++
                }
            }
        } else {
            downstream.add(A[i])
        }
    }
    return survived + downstream.size
}

fun solutionBrackets2(S: String): Int {
    val bracketsEncountered = mutableListOf<Char>()
    for (ch in S) {
        if (ch == '(') {
            bracketsEncountered.add(ch)
        } else if (ch == ')' && (bracketsEncountered.size == 0 || bracketsEncountered.removeAt(bracketsEncountered.size - 1) != '(')) {
            return 0
        }
    }
    if (bracketsEncountered.size != 0) {
        return 0
    }
    return 1
}

fun solution(H: IntArray): Int {
    var counter = 0
    var minStackHeight = 0
    val stackHeights = mutableSetOf<Int>()
    for(height in H) {
       if (height < minStackHeight) {
            counter += stackHeights.size
            stackHeights.clear()
        }
        if(minStackHeight == 0 || height < minStackHeight) {
            minStackHeight = height
        }
        if(height != 0) {
            stackHeights.add(height)
        }
    }
    return counter + stackHeights.size
}




fun main() {
}