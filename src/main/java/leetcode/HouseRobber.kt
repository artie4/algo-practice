package leetcode

class HouseRobber {
    fun rob(nums: IntArray): Int {
        var prevprev = 0
        var prev = 0
        nums.forEach {
            val tmp = prev
            prev = maxOf(prevprev + it, prev)
            prevprev = tmp
        }
        return prev
    }
}

fun main() {
    val houseRobber = HouseRobber()
    assert(houseRobber.rob(intArrayOf(2,1,3,8,3,0,9,1,1,7)) == 26)
    assert(houseRobber.rob(intArrayOf(1,3,8)) == 9)
    assert(houseRobber.rob(intArrayOf(0,1)) == 1)
}