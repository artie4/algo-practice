package leetcode.algo_1_path

class FindMaxAverage {
}

fun findMaxAverage(nums: IntArray, k: Int): Double {

    var currentSum = sum(nums, 0, k)
    var max: Double = currentSum / k

    for (i in 1..nums.size - k) {
        currentSum = currentSum - nums[i - 1] + nums[i+k-1]
        val avg = currentSum / k
        if (max < avg) {
            max = avg
        }
    }
    return max
}

fun sum(nums: IntArray, start: Int, end: Int): Double {
    var sum = 0.0
    for (i in start until end) {
        sum += nums[i]
    }
    return sum
}

fun main() {
    assert(findMaxAverage(intArrayOf(-3), 1) == -3.0)
    assert(findMaxAverage(intArrayOf(-3, 4,-1,6,3,9), 1) == 9.0)
    assert(findMaxAverage(intArrayOf(-3, 4,2,6,3,-6,9), 3) == 4.0)
}