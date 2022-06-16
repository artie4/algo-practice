package leetcode.algo_1_path

import model.TreeNode
import java.util.*

class BinaryTreeDepth {
}

fun maxDepth(root: TreeNode?): Int {
    root ?: return 0
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)
    var levels = 0
    while (queue.isNotEmpty()) {
        val count = queue.size - 1
        for (i in 0..count) {
            val node = queue.poll()
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        ++levels
    }
    return levels
}

fun minDepth(root: TreeNode?): Int {
    root ?: return 0
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)
    var levels = 0
    while (queue.isNotEmpty()) {
        val count = queue.size - 1
        for (i in 0..count) {
            val node = queue.poll()
            if (node.left == null && node.right == null) {
                return ++levels
            }
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        ++levels
    }
    return levels
}

fun main() {
    val tree1 = TreeNode(1)
    val tree2 = TreeNode(3).apply { left = TreeNode(2); right = TreeNode(4) }
    val tree3 = TreeNode(4).apply { left = TreeNode(2).apply { left = TreeNode(1); right = TreeNode(3) }; right = TreeNode(5) }

    assert(maxDepth(null) == 0)
    assert(maxDepth(tree1) == 1)
    assert(maxDepth(tree2) == 2)
    assert(maxDepth(tree3) == 3)
    assert(minDepth(tree3) == 2)
}