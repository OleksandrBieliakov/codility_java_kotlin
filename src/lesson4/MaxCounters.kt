package lesson4

fun solution(N: Int, A: IntArray): IntArray {
    val c = IntArray(N)
    var max = 0
    var oldMax = 0
    val nPlusOne = N + 1
    A.forEach { x ->
        //if (x == nPlusOne) {
        if (x == nPlusOne && oldMax != max) {
            c.indices.forEach { c[it] = max }
            oldMax = max
        }
        else {
            //array is zero based
            val i = x - 1
            c[i] = c[i] + 1
            if (c[i] > max)
                max = c[i]
        }
    }
    return c
}


