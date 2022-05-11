package leetcode.algo_1_path

import java.util.Arrays

class TwoSum2 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for(i in 0..numbers.lastIndex) {
            val diff = target - numbers[i]
            val index = binarySearch(numbers, i + 1, numbers.lastIndex, diff)
            if (index != -1) {
                return intArrayOf(i + 1, index + 1)
            }
        }
        return emptyArray<Int>().toIntArray()
    }

    fun binarySearch(array: IntArray, start: Int, end: Int, search: Int): Int {
        var left = start
        var right = end
        var mid = left + (right - left) / 2
        while (left <= right) {
            if (array[mid] == search) {
                return mid
            }
            else if (array[mid] < search) {
                left = mid + 1
                mid = left + (right - left) / 2
            } else {
                right = mid - 1
                mid = left + (right - left) / 2
            }
        }
        return -1
    }
}

fun main() {
    val numbers1 = intArrayOf(2,7,11,15)
    val target1 = 9
    val numbers2 = intArrayOf(2,3,4)
    val target2 = 6
    val numbers3 = intArrayOf(2,3,3)
    val target3 = 6
    val inst = TwoSum2()
    assert(Arrays.compare(inst.twoSum(numbers1, target1), intArrayOf(1,2)) == 0)
    assert(Arrays.compare(inst.twoSum(numbers2, target2), intArrayOf(1,3)) == 0)
    assert(Arrays.compare(inst.twoSum(numbers3, target3), intArrayOf(2,3)) == 0)
}