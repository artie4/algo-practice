package leetcode.algo_1_path;

import model.TreeNode


class MergeTwoBinaryTrees {}

// run with jvm option -ea
fun main() {
    val tree1 = TreeNode(1)
    val tree2 = TreeNode(3).apply { left = TreeNode(2); right = TreeNode(4) }
    val mergedTree = mergeTrees(tree1, tree2)
    assert(mergedTree!!.`val` == 4)
    assert(mergedTree.left!!.`val` == 2)
    assert(mergedTree.right!!.`val` == 4)
}

fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null) return root2
    if (root2 == null) return root1

    root1.`val` += root2.`val`

    root1.left = mergeTrees(root1.left, root2.left)
    root1.right = mergeTrees(root1.right, root2.right)
    return root1
}