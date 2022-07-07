package leetcode

import model.Node
import java.util.*

class NaryTreeTraversal {
    fun postorder(root: Node?): List<Int> {
        root ?: return emptyList()
        val stack = Stack<Node>()
        stack.push(root)
        val result = LinkedList<Int>()
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            result.addFirst(node.`val`)
            val children = node.children
            if (children != null && children.isNotEmpty()) {
                for(i in 0..children.lastIndex) {
                    children[i]?.run { stack.push(this) }
                }
            }
        }
        return result
    }
}

fun main() {
    val node = Node(1, listOf(
            Node(3, listOf(Node(27), Node(81), Node(243))),
            Node(6),
            Node(9),
        ))
    val inst = NaryTreeTraversal()
    assert(inst.postorder(node) == listOf(27, 81, 243, 3, 6, 9, 1))
}