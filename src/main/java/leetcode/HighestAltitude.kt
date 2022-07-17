package leetcode

import kotlin.math.max

class HighestAltitude {
    fun largestAltitude(gain: IntArray): Int {
        var height = 0
        var maxHeight = 0
        for (g in gain) {
            height += g
            maxHeight = maxOf(height, maxHeight)
        }
        return maxHeight
    }
}

fun main() {
    val highestAltitude = HighestAltitude()
    assert(highestAltitude.largestAltitude(intArrayOf(2,-4,6,-2,5,-3)) == 7)
    assert(highestAltitude.largestAltitude(intArrayOf(2,1,3)) == 6)
}