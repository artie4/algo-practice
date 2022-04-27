package leetcode


fun main() {
    val largestPlusSign = LargestPlusSign()
    largestPlusSign.orderOfLargestPlusSign(5, arrayOf(intArrayOf(1,1), intArrayOf(1, 3)))
}

class LargestPlusSign {

    fun orderOfLargestPlusSign(n: Int, mines: Array<IntArray>): Int {
        val matrix = Array(n) { IntArray(n) { 1 } }
        for (mine in mines) {
            matrix[mine[0]][mine[1]] = 0
        }

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) continue
                matrix[i][j] += minOf(
                        minOf(countTop(i, j, matrix), countBot(i, j, matrix)),
                        minOf(countLeft(i, j, matrix), countRight(i, j, matrix))
                )
            }
        }

        val result = matrix.reduce { l1: IntArray, l2: IntArray -> intArrayOf(l1.maxOrNull()!!, l2.maxOrNull()!!) }.maxOrNull()
        return when (result) {
            0 -> 0
            null -> 0
            else -> result
        }
    }

    fun countTop(y: Int, x: Int, matrix: Array<IntArray>): Int {
        var count = 0
        for (i in y - 1 downTo 0) {
            if (matrix[i][x] == 0) return count
            count++
        }
        return count
    }

    fun countBot(y: Int, x: Int, matrix: Array<IntArray>): Int {
        var count = 0
        for (i in y + 1..matrix.lastIndex) {
            if (matrix[i][x] == 0) return count
            count++
        }
        return count
    }

    fun countLeft(y: Int, x: Int, matrix: Array<IntArray>): Int {
        var count = 0
        for (i in x - 1 downTo 0) {
            if (matrix[y][i] == 0) return count
            count++
        }
        return count
    }

    fun countRight(x: Int, y: Int, matrix: Array<IntArray>): Int {
        var count = 0
        for (i in y + 1..matrix[x].lastIndex) {
            if (matrix[x][i] == 0) return count
            count++
        }
        return count
    }

}


