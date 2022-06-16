package leetcode

import model.TreeNode

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        root ?: return true
        return recursive(root.left, root.right)
    }

    fun recursive(left: TreeNode?, right: TreeNode?): Boolean {
        if (left?.`val` != right?.`val`) {
            return false
        }
        if (left == null) {
            return true
        }
        return recursive(left.left, right?.right) && recursive(left.right, right?.left)
    }
}

fun main() {
    val tree1 = TreeNode(1)
    val tree2 = TreeNode(1).apply { left = TreeNode(2); right = TreeNode(4) }
    val tree3 = TreeNode(1).apply { left = TreeNode(2).apply { right = TreeNode(3) }; right = TreeNode(2).apply { left = TreeNode(3) } }
    val inst = SymmetricTree()
    assert(inst.isSymmetric(tree1))
    assert(!inst.isSymmetric(tree2))
    assert(inst.isSymmetric(tree3))
}