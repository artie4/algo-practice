package leetcode

import leetcode.algo_1_path.TreeNode
import java.util.Queue
import java.util.LinkedList

class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }
        if (p?.`val` != q?.`val`) {
            return false
        }
        val queue1: Queue<TreeNode> = LinkedList()
        queue1.add(p)
        val queue2: Queue<TreeNode> = LinkedList()
        queue2.add(q)

        while (queue1.isNotEmpty() || queue2.isNotEmpty()) {
            val count1 = queue1.size - 1
            val count2 = queue2.size - 1
            if (count1 != count2) return false
            for (i in 0..count1) {
                val node1 = queue1.poll()
                val node2 = queue2.poll()
                if (node1.`val` != node2.`val`) return false
                if (node1.left == null && node2.left != null || node1.left != null && node2.left == null) return false
                if (node1.right == null && node2.right != null || node1.right != null && node2.right == null) return false

                node1.left?.let { queue1.add(it) }
                node1.right?.let { queue1.add(it) }
                node2.left?.let { queue2.add(it) }
                node2.right?.let { queue2.add(it) }
            }
        }
        return true
    }
}

fun main() {

    val tree1 = TreeNode(1).apply { left = TreeNode(2); right = TreeNode(3) }
    val tree2 = TreeNode(1).apply { left = TreeNode(2); right = TreeNode(3) }

    val tree3 = TreeNode(1).apply { right = TreeNode(2).apply { right = TreeNode(3) } }
    val tree4 = TreeNode(1).apply { left = TreeNode(2); right = TreeNode(3) }

    val inst = SameTree()
    assert(inst.isSameTree(null, null))
    assert(inst.isSameTree(tree1, tree2))
    assert(!inst.isSameTree(tree3, tree4))
}
