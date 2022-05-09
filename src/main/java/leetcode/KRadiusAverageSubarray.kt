package leetcode

import java.util.Arrays

class KRadiusAverageSubarray {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        if (k == 0) return nums
        val resultArray = IntArray(nums.size) { -1 }
        val avgRange = 2*k + 1
        if (avgRange > nums.size) return resultArray
        var currentSum = sum(nums, 0, avgRange - 1)
        resultArray[k] = (currentSum / avgRange).toInt()
        for (i in k + 1..nums.lastIndex - k) {
            val subtract = nums[i - k - 1]
            val add =  nums[i + k]
            currentSum = currentSum - subtract + add
            resultArray[i] = (currentSum / avgRange).toInt()
        }
        return resultArray
    }

    fun sum(nums: IntArray, start: Int, end: Int): Long {
        var sum = 0L
        for (i in start..end) {
            sum += nums[i]
        }
        return sum
    }
}

fun main() {
    val inst = KRadiusAverageSubarray()
    val result = inst.getAverages(intArrayOf(7,4,3,9,1,8,5,2,6),3)
    assert(Arrays.compare(result, intArrayOf(-1,-1,-1,5,4,4,-1,-1,-1)) == 0)
}