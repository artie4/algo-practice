package leetcode.data_1_path


class MaxSubArray {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        var currentSum = nums[0]
        var bestSum = nums[0]

        for (i in 1..nums.lastIndex) {
            currentSum = maxOf2(nums[i], currentSum + nums[i])
            bestSum = maxOf2(bestSum, currentSum)
        }
        return bestSum
    }

    fun maxOf2(val1: Int, val2: Int) : Int {
        return if (val1 > val2) val1 else val2
    }
}

fun main() {

    val inst = MaxSubArray()

    val array1 = intArrayOf(0, -1, 2, 1)
    val array2 = intArrayOf(0, 1, -2, 1)
    val array3 = intArrayOf(0, -1, -2, -1)

    assert(inst.maxSubArray(array1) == 3)
    assert(inst.maxSubArray(array2) == 1)
    assert(inst.maxSubArray(array3) == 0)
}