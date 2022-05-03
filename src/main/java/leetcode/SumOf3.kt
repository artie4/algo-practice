package leetcode

import java.util.Arrays

class SumOf3 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) return emptyList()
        Arrays.sort(nums)
        val result = mutableListOf<List<Int>>()
        for (i in 0 until nums.lastIndex) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            val current = nums[i]
            var left = i + 1
            var right = nums.lastIndex

            while (left < right) {
                val threeSum = current + nums[left] + nums[right]
                if (threeSum > 0) {
                    right--
                } else if (threeSum < 0) {
                    left++
                } else {
                    result.add(listOf(nums[i], nums[left], nums[right]))
                    left++

                    while (nums[left - 1] == nums[left] && left < right) {
                        left++
                    }
                }
            }
        }
        return result
    }
}