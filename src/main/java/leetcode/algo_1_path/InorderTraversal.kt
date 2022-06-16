package leetcode.algo_1_path

import model.TreeNode
import java.util.Stack


class InorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        root ?: return emptyList()
        val stack: Stack<TreeNode> = Stack()
        val result = mutableListOf<Int>()
        var curNode = root

        while (curNode != null || stack.isNotEmpty()) {
            while (curNode != null) {
                stack.push(curNode)
                curNode = curNode.left
            }
            curNode = stack.pop()
            result.add(curNode.`val`)
            curNode = curNode.right
        }
        return result
    }


    fun inorderTraversalRecursive(root: TreeNode?): List<Int> {
        root ?: return emptyList()
        val result = mutableListOf<Int>()
        recursive(root, result)
        return result
    }

    fun recursive(node: TreeNode?, list: MutableList<Int>) {
        if (node != null) {
            recursive(node.left, list)
            list.add(node.`val`)
            recursive(node.right, list)
        }
    }
}

fun main() {
    val tree1 = TreeNode(6).apply {
        left = TreeNode(3).apply { left = TreeNode(4); right = TreeNode(5) }
        right = TreeNode(8).apply { left = TreeNode(7); right = TreeNode(9) }
    }

    val inst = InorderTraversal()
    val expected = listOf(4, 3, 5, 6, 7, 8, 9)
    assert(inst.inorderTraversal(tree1) == expected)
    assert(inst.inorderTraversalRecursive(tree1) == expected)
}
