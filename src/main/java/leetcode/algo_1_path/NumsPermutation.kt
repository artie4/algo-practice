package leetcode.algo_1_path

import java.util.*

class NumsPermutation {
}

fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val seq = mutableListOf<Int>()
    val numList = nums.toMutableList()
    innerPermute(numList, seq, result)
    return result
}

fun innerPermute(nums: MutableList<Int>, sequence: MutableList<Int>, container: MutableList<List<Int>>) {
    if (nums.isEmpty()) {
        container.add(sequence.toList())
        sequence.clear()
        return
    }

    for (i in nums.indices) {
        val num = nums[i]
        val subLeft = mutableListOf<Int>()
        Collections.copy(subLeft, nums.subList(0, i))

        val subRight = if (nums.lastIndex > i) {
            val dest = mutableListOf<Int>()
            Collections.copy(dest, nums.subList(i + 1, nums.lastIndex).toList())
            dest
        } else mutableListOf()
        val rest = subLeft + subRight
        sequence.add(num)
        innerPermute(rest.toMutableList(), sequence, container)
    }
}

fun main() {
    val array = intArrayOf(1,2,3)
    println(permute(array))
}