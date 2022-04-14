package leetcode.algo_1_path

class SearchInBST {
}

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    return root?.let {
        if (`val` == it.`val`) {
            it
        } else if (`val` < it.`val`) {
            searchBST(it.left, `val`)
        } else {
            searchBST(it.right, `val`)
        }
    }
}

fun main() {
    val root = TreeNode(8).apply {
        left = TreeNode(4).apply { left = TreeNode(2); right = TreeNode(6) }
        right = TreeNode(12).apply { right = TreeNode(15) }
    }

    assert(searchBST(root, 12)?.`val` == 12)
    assert(searchBST(root, 5)?.`val` == null)
    assert(searchBST(root, 15)?.`val` == 15)
}