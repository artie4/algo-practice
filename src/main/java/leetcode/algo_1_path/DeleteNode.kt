package leetcode.algo_1_path

import utils.Utils

class DeleteNode {
}

class ListNode(var `val`: Int) { var next: ListNode? = null }

fun deleteNode(node: ListNode?) {
    var prev = node!!
    var current = node.next
    while(current!!.next != null) {
        prev.`val` = current.`val`
        prev = current
        current = current.next
    }
    prev.`val` = current.`val`
    prev.next = null
}

fun main() {
    val nodeForDeletion = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } }
    val tree1 = ListNode(2).apply { next = nodeForDeletion }
    Utils.traverseLinkedList(tree1)
    deleteNode(nodeForDeletion)
    Utils.traverseLinkedList(tree1)
    assert(tree1.next!!.`val` == 4)
}
