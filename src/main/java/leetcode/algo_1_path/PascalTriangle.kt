package leetcode.algo_1_path

class PascalTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        for (i in 0 until numRows) {
            if (i == 0) {
                result.add(mutableListOf(1))
            } else if (i == 1) {
                result.add(mutableListOf(1,1))
            } else {
                val prev = result[i - 1]
                val list = mutableListOf(1)
                for (j in 0 until prev.lastIndex) {
                    list.add(prev[j] + prev[j+1])
                }
                list.add(1)
                result.add(list)
            }
        }
        return result
    }
}

fun main() {
    val inst = PascalTriangle()
    inst.generate(8).joinToString("\n") { it.joinToString(" ") }.let { println(it) }
}