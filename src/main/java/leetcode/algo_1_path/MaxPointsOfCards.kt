package leetcode.algo_1_path

class MaxPointsOfCards {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        if (k >= cardPoints.size) {
            return cardPoints.sum()
        }
        var window = 0
        for (i in 0 until k) {
            window += cardPoints[i]
        }
        var answer = window
        for (i in 0 until k) {
            window += cardPoints[cardPoints.lastIndex - i] - cardPoints[k - i - 1]
            answer = maxOf(answer, window)
        }
        return answer
    }
}

fun main() {
    val inst = MaxPointsOfCards()
    assert(inst.maxScore(intArrayOf(4,1,2,3), 4) == 10)
    assert(inst.maxScore(intArrayOf(4,1,2,3), 2) == 7)
    assert(inst.maxScore(intArrayOf(1,2,3,4,5,6,1), 3) == 12)
    assert(inst.maxScore(intArrayOf(1,8,5,1,6), 2) == 9)
    assert(inst.maxScore(intArrayOf(1,8,5,1,6), 3) == 15)
}
