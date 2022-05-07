package leetcode

import leetcode.algo_1_path.ListNode

class IntersectionOfTwoLinkedLists {
    fun getIntersectionNode(headA: ListNode?, headB:ListNode?):ListNode? {
        headA ?: return null
        headB ?: return null

        var head1 = headA
        var head2 = headB

        while (head1 != head2) {
            head1 = if (head1 == null) headB else head1.next
            head2 = if (head2 == null) headA else head2.next

        }
        return head1
    }
}

fun main() {

    val inst = IntersectionOfTwoLinkedLists()
    val common = ListNode(6).apply { next = ListNode(8) }
    val head1 = ListNode(1).apply { next = ListNode(2).apply { next = common } }
    val head2 = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) }.apply { next = common } }
    assert(inst.getIntersectionNode(null, head2) == null)
    assert(inst.getIntersectionNode(head1, null) == null)
    assert(inst.getIntersectionNode(head1, head2) == common)

}