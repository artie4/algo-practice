package leetcode.data_1_path

import java.util.Arrays

class IntersectionOfTwoArrays {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums1.forEach {
            map.merge(it, 1) { old: Int, new: Int -> old + new }
        }
        return nums2.filter {current ->
            val count = map[current]
            if (count == null) {
                false
            } else if (count > 0) {
                map[current] = count - 1
                true
            } else false
        }.toIntArray()
    }
}

fun main() {
    val inst = IntersectionOfTwoArrays()

    assert(Arrays.compare(inst.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)), intArrayOf(2, 2)) == 0)
    assert(Arrays.compare(inst.intersect(intArrayOf(2, 2, 3, 2, 2, 2), intArrayOf(2, 1, 2)), intArrayOf(2, 2)) == 0)
    assert(Arrays.compare(inst.intersect(intArrayOf(0, 1, 2, 2, 1, 0), intArrayOf(2, 1, 2)), intArrayOf(2, 1, 2)) == 0)
}