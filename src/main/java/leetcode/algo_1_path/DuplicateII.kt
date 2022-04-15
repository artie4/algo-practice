package leetcode.algo_1_path

class DuplicateII {
}

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val savedIndex = map[nums[i]]
        if (savedIndex != null &&  savedIndex >= i - k ) return true
        map[nums[i]] = i
    }
    return false
}

fun main() {
    assert(containsNearbyDuplicate(intArrayOf(1,2,3,4,2),  3))
    assert(containsNearbyDuplicate(intArrayOf(1,2,3,4,2), 4))
    assert(!containsNearbyDuplicate(intArrayOf(1,2,3,4,2), 2))
}