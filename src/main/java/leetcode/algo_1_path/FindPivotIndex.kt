package leetcode.algo_1_path

class FindPivotIndex {

    fun pivotIndex(nums: IntArray): Int {
        if (nums.size == 1) return 0
        var rightSum = nums.sum()
        var leftSum = 0
        for (i in 0..nums.lastIndex) {
            rightSum -= nums[i]
            if (rightSum == leftSum) return i
            leftSum += nums[i]
        }
        return -1
    }
}

fun main() {
    val inst = FindPivotIndex()
    assert(inst.pivotIndex(intArrayOf(1)) == 0)
    assert(inst.pivotIndex(intArrayOf(2,1,3)) == -1)
    assert(inst.pivotIndex(intArrayOf(3,1,3)) == 1)
    assert(inst.pivotIndex(intArrayOf(1,2,3,4,6)) == 3)
}