package leetcode.algo_1_path

class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n
        var i = n - 2
        var oneStepAgo = 2
        var twoStepAgo = 1
        var current = 0
        while (i-- > 0) {
            current = twoStepAgo + oneStepAgo
            twoStepAgo = oneStepAgo
            oneStepAgo = current
        }
        return current
    }
}

fun main() {
    val inst = ClimbingStairs()
    assert(inst.climbStairs(0) == 0)
    assert(inst.climbStairs(1) == 1)
    assert(inst.climbStairs(2) == 2)
    assert(inst.climbStairs(4) == 5)
    assert(inst.climbStairs(5) == 8)
}