package leetcode.algo_1_path;

import java.util.Arrays

class RotateArray {

    fun rotate(nums: IntArray, k: Int) {
        if (nums.size < 2) return
        val shift = k % nums.size
        reverse(nums, 0, nums.lastIndex)
        reverse(nums, 0, shift - 1)
        reverse(nums, shift, nums.lastIndex)
    }

    fun reverse(nums: IntArray, start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left++
            right--
        }
    }
}

fun main() {
    val array1 = intArrayOf(1, 0, 0, 0, 0)
    val array2 = intArrayOf(0)
    val inst = RotateArray()
    inst.rotate(array1, 2)
    inst.rotate(array2, 10)
    assert(Arrays.compare(array1, intArrayOf(0,0,1,0,0)) == 0)
    assert(Arrays.compare(array2, intArrayOf(0)) == 0)
}
