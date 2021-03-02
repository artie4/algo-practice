package leetcode

fun main() {

    val matrix = mutableListOf(
        mutableListOf(1, 1, 1, 1, 1),
        mutableListOf(1, 0, 1, 0, 1),
        mutableListOf(1, 1, 1, 1, 1),
        mutableListOf(1, 1, 1, 1, 1),
        mutableListOf(1, 1, 1, 0, 1)
    )
    findMaxPlusInMatrix(matrix)
}

fun findMaxPlusInMatrix(matrix: MutableList<MutableList<Int>>) {

//    val copy = MutableList(matrix.size) { matrix[it].toMutableList() }

    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == 0) continue
            matrix[i][j] += 2 * minOf(
                minOf(countTop(i, j, matrix), countBot(i, j, matrix)),
                minOf(countLeft(i, j, matrix), countRight(i, j, matrix))
            )
        }
    }

    matrix.forEach { println(it.joinToString(" ")) }

    val result = matrix.reduce { l1, l2 -> mutableListOf(l1.maxOrNull()!!, l2.maxOrNull()!!) }.maxOrNull()
    println(result)
}

fun countTop(y: Int, x: Int, matrix: List<List<Int>>): Int {
    var count = 0
    for (i in y - 1 downTo 0) {
        if (matrix[i][x] == 0) return count
        count++
    }
    return count
}

fun countBot(y: Int, x: Int, matrix: List<List<Int>>): Int {
    var count = 0
    for (i in y + 1..matrix.lastIndex) {
        if (matrix[i][x] == 0) return count
        count++
    }
    return count
}

fun countLeft(y: Int, x: Int, matrix: List<List<Int>>): Int {
    var count = 0
    for (i in x - 1 downTo 0) {
        if (matrix[y][i] == 0) return count
        count++
    }
    return count
}

fun countRight(x: Int, y: Int, matrix: List<List<Int>>): Int {
    var count = 0
    for (i in y + 1..matrix[x].lastIndex) {
        if (matrix[x][i] == 0) return count
        count++
    }
    return count
}
