package leetcode.algo_1_path

import leetcode.TreeNode

import java.util.*


class TreePostOrderTraversal {

    fun postorderTraversal(root: TreeNode?): List<Int> {
        root ?: return emptyList()
        val stack: Stack<TreeNode> = Stack<TreeNode>()
        val result: LinkedList<Int> = LinkedList()
        stack.push(root)
        while (!stack.isEmpty()) {
            val pop: TreeNode = stack.pop()
            result.addFirst(pop.`val`)
            if (pop.left != null) {
                stack.add(pop.left)
            }
            if (pop.right != null) {
                stack.add(pop.right)
            }
        }
        return result
    }

    fun postorderTraversalRecursive(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        recursive(root, result)
        return result
    }

    private fun recursive(root: TreeNode?, list: MutableList<Int>) {
        if (root != null) {
            recursive(root.left, list)
            recursive(root.right, list)
            list.add(root.`val`)
        }
    }
}

fun main() {

    val inst = TreePostOrderTraversal()

    val tree = TreeNode(5, TreeNode(3, TreeNode(1), TreeNode(2)), TreeNode(7, TreeNode(6), TreeNode(8)))
    val expected = listOf(1, 2, 3, 6, 8, 7, 5)
    assert(inst.postorderTraversalRecursive(tree) == expected)
    assert(inst.postorderTraversal(tree) == expected)

}
