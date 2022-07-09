package leetcode

import model.Node
import java.util.*

class NaryTreePreorderTraversal {
    fun preorder(root: Node?): List<Int> {
        root ?: return emptyList()
        val result = mutableListOf<Int>()
        val stack = Stack<Node>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            result.add(node.`val`)
            if (node.children != null && node.children.isNotEmpty()) {
                for(i in node.children.lastIndex downTo 0) {
                    stack.push(node.children[i])
                }
            }
        }
        return result
    }
}

fun main() {
    val inst = NaryTreePreorderTraversal()
    val node = Node(1, listOf(
        Node(3, listOf(Node(27), Node(81), Node(243))),
        Node(6),
        Node(9),
    ))
    assert(inst.preorder(node) == listOf(1,3,27,81,243,6,9))
}