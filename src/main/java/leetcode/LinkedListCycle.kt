package leetcode

import leetcode.algo_1_path.ListNode

class LinkedListCycle {

    fun hasCycle(head: ListNode?): Boolean {
        head ?: return false
        var pointer = head
        var fastPointer = head
        while (fastPointer?.next != null) {
            fastPointer = fastPointer.next!!.next
            pointer = pointer!!.next
            if (fastPointer == pointer) return true
        }
        return false
    }
}