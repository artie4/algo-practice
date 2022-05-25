package leetcode

import java.util.Arrays

class TwoArraysIntersection {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set = nums1.toHashSet()
        return nums2.filter { set.remove(it) }.toIntArray()
    }
}

fun main() {
    val inst = TwoArraysIntersection()
    assert(Arrays.compare(inst.intersection(intArrayOf(1,2,2,1), intArrayOf(2,2)), intArrayOf(2)) == 0)
    assert(Arrays.compare(inst.intersection(intArrayOf(3,4), intArrayOf(1,2)), intArrayOf()) == 0)
    assert(Arrays.compare(inst.intersection(intArrayOf(3,4), intArrayOf(5,8,4,3)), intArrayOf(4,3)) == 0)
}