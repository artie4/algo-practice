package leetcode

import java.util.*

class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        val head = root
        helper(root)
        return head
    }

    private fun helper(root: TreeNode?): TreeNode? {
        root ?: return null
        val temp = root.left
        root.left = helper(root.right)
        root.right = helper(temp)
        return root
    }

    fun invertTreeBFS(root: TreeNode?): TreeNode? {
        root ?: return null
        val queue = LinkedList<TreeNode>()
        queue.push(root)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            val temp = node.left
            node.left = node.right
            node.right = temp
            node.left?.run { queue.push(this) }
            node.right?.run { queue.push(this) }
        }
        return root
    }
}

fun main() {
    val tree = TreeNode(
        5,
        TreeNode(3, TreeNode(1, null, null), TreeNode(2, null, null)),
        TreeNode(7, TreeNode(8, null, null), TreeNode(9, null, null))
    )
    val inst = InvertBinaryTree()
//    inst.invertTree(tree)
    inst.invertTreeBFS(tree)
    println("left = ${tree.left.`val`}; right = ${tree.right.`val`}")
}