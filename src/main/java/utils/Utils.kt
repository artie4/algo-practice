package utils

import leetcode.algo_1_path.ListNode

object Utils {

    fun traverseTree(node: ListNode) {
        var current: ListNode? = node
        val result = mutableListOf<Int>()
        while (current != null) {
            result.add(current.`val`)
            current = current.next
        }
        println(result.joinToString("->"))
    }
}