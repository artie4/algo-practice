package leetcode

import java.io.FileInputStream

class MedianOfTwoSortedArrays {

    fun findMedian(nums1: IntArray, nums2: IntArray): Int {
        val smallArr: IntArray
        val bigArr: IntArray
        if (nums1.size < nums2.size) {
            smallArr = nums1
            bigArr = nums2
        } else {
            smallArr = nums2
            bigArr = nums1
        }

        // index for binary search in smaller array
        var left = 0
        var right = smallArr.lastIndex
        val totalSize = smallArr.size + bigArr.size
        val half = totalSize / 2

        while (true) {
            val sIndex = if (left <= right) { left + (right - left) / 2 } else -1
            val bIndex = if (left <= right) { half - sIndex - 2 } else bigArr.lastIndex

            val sLeft = if (sIndex >= 0) smallArr[sIndex] else Int.MIN_VALUE
            val sRight = if (sIndex < smallArr.lastIndex) smallArr[sIndex + 1] else Int.MAX_VALUE
            val bLeft = if (bIndex >= 0) bigArr[bIndex] else Int.MIN_VALUE
            val bRight = if (bIndex < bigArr.lastIndex) bigArr[bIndex + 1] else Int.MAX_VALUE

            if (sLeft <= bRight && bLeft <= sRight) {
                if (totalSize % 2 == 0) {
                    return (maxOf(sLeft, bLeft) + minOf(bRight, sRight)) / 2
                } else {
                    return minOf(bLeft, sRight)
                }
            }
            if (sLeft > bRight) {
                right = sIndex - 1
            }
            if (sRight < bLeft) {
                left = sIndex + 1
            }
        }
    }
}

fun main() {

    val fileInputStream = FileInputStream("file.bin")
    val inst = MedianOfTwoSortedArrays()

    println(inst.findMedian(intArrayOf(1,2,3,6), intArrayOf(4,5)))
//    println(inst.findMedian(intArrayOf(1,2,3), intArrayOf(4,5)))
//    assert(inst.findMedian(intArrayOf(1,2,3), intArrayOf(4,5)) == 3)
//    println(inst.findMedian(intArrayOf(1,3), intArrayOf(2,4)))
//    assert(inst.findMedian(intArrayOf(1,3), intArrayOf(2,4)) == 2)

}