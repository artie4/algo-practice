package leetcode

import leetcode.algo_1_path.ListNode

class LinkedListCycle {

    fun hasCycle(head: ListNode?): Boolean {
        head ?: return false
        var pointer = head
        var fastPointer = head
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next!!.next
            pointer = pointer!!.next
            if (fastPointer == pointer) return true
        }
        return false
    }
}

fun main() {

    val inst = LinkedListCycle()

    val repeatedNode = ListNode(1)
    val head1 = repeatedNode.apply { next = ListNode(2).apply { next = repeatedNode } }
    val head2 = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } }
    assert(inst.hasCycle(head1))
    assert(!inst.hasCycle(head2))
}