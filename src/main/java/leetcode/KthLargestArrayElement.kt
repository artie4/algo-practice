package leetcode

class KthLargestArrayElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        nums.sort()
        return nums[nums.lastIndex - k + 1]
    }
}

fun main() {
    val inst = KthLargestArrayElement()

    assert(inst.findKthLargest(intArrayOf(3,4,1,2), 3) == 2)
    assert(inst.findKthLargest(intArrayOf(3,1,2,2,2), 3) == 2)
    assert(inst.findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4) == 4)
}