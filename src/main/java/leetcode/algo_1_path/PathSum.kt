package leetcode.algo_1_path

import model.TreeNode
import java.util.*

class PathSum {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        root ?: return false
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node.left != null) {
                node.left.`val` += node.`val`
                queue.offer(node.left)
            }
            if (node.right != null) {
                node.right.`val` += node.`val`
                queue.offer(node.right)
            }
            if (node.right == null && node.left == null && node.`val` == targetSum) return true
        }
        return false
    }
}

fun main() {

    val tree = TreeNode(5,
        TreeNode(4, TreeNode(11, TreeNode(7), TreeNode(2)), null),
        TreeNode(8, TreeNode(13), TreeNode(4, null, TreeNode(1)))
    )
    val inst = PathSum()
    assert(inst.hasPathSum(tree, 22))
    assert(!inst.hasPathSum(tree, 10))
}