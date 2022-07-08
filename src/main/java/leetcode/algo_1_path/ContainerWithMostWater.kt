package leetcode.algo_1_path

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var maxArea = Int.MIN_VALUE
        var left = 0
        var right = height.lastIndex
        while (left < right) {
            val minHeight = minOf(height[left], height[right])
            maxArea = maxOf(maxArea, (right - left) * minHeight)
            while (height[left] <= minHeight && left < right) left++
            while (height[right] <= minHeight && left < right) right--
        }
        return maxArea
    }
}

fun main() {
    val inst = ContainerWithMostWater()
    assert(inst.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)) == 49)
}