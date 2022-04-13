package leetcode.algo_1_path

class SingleNumber {
}

fun singleNumber(nums: IntArray): Int {
    var result = nums[0]
    if (nums.size == 1) {
        return result
    }
    for (i in 1..nums.lastIndex) {
        result = result xor nums[i]
    }
    return result
}

// run with -ea jvm option
fun main() {
    val arr1 = intArrayOf(-1,2,-1,2,6,5,5)
    val arr2 = intArrayOf(-1)
    val arr3 = intArrayOf(1,2,2)
    assert(singleNumber(arr1) == 6)
    assert(singleNumber(arr2) == -1)
    assert(singleNumber(arr3) == 1)
}