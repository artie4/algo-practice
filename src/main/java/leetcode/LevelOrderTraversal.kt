package leetcode

import java.util.*

class LevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        root ?: return emptyList()
        val resultList = mutableListOf<MutableList<Int>>()
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            var count = queue.size
            val levelNodes = mutableListOf<Int>()
            while (count-- > 0) {
                val node = queue.poll()
                levelNodes.add(node.`val`)
                node.left?.run { queue.add(this) }
                node.right?.run { queue.add(this) }
            }
            resultList.add(levelNodes)
        }
        return resultList
    }
}

fun main() {
    val tree = TreeNode(
        5,
        TreeNode(3, TreeNode(1, null, null), TreeNode(2, null, null)),
        TreeNode(7, TreeNode(8, null, null), TreeNode(9, null, null))
    )
    val inst = LevelOrderTraversal()
    assert(inst.levelOrder(tree) == (listOf(listOf(5), listOf(3, 7), listOf(1, 2, 8, 9))))
}