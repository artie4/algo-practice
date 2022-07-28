package leetcode

import java.util.*


class SmallestInfiniteSet {

    var current = 1
    val set = TreeSet<Int>()

    fun popSmallest(): Int {
        if (set.isNotEmpty()) {
            val num = set.first()
            set.remove(num)
            return num
        }
        return current++
    }

    fun addBack(num: Int) {
        if (num < current) {
            set.add(num)
        }
    }
}

fun main() {
    val smallestInfiniteSet = SmallestInfiniteSet()
    assert(smallestInfiniteSet.popSmallest() == 1)
    assert(smallestInfiniteSet.popSmallest() == 2)
    assert(smallestInfiniteSet.popSmallest() == 3)
    smallestInfiniteSet.addBack(2)
    smallestInfiniteSet.addBack(3)
    assert(smallestInfiniteSet.popSmallest() == 2)
    assert(smallestInfiniteSet.popSmallest() == 3)
}