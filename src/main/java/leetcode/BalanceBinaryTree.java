package leetcode;

import leetcode.algo_1_path.TreeNode;

import java.util.Stack;

public class BalanceBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return checkHeight(root) != -1;
    }

    public static int checkHeight(TreeNode root) {
        if (root == null) return 0;
        int l = checkHeight(root.getLeft());
        int r = checkHeight(root.getRight());

        if (l == -1 || r == -1 || Math.abs(l - r) > 1) return -1;
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        var balancedTree = new TreeNode(5,
                new TreeNode(3, new TreeNode(1, null, null), new TreeNode(2, null, null)),
                new TreeNode(7, new TreeNode(8, null, null), new TreeNode(9, null, null))
        );
        var unbalancedTree = new TreeNode(5,
                new TreeNode(3, new TreeNode(1, new TreeNode(7, new TreeNode(8, null, null), new TreeNode(9, null, null)), null), new TreeNode(2, null, null)),
                null
        );
        assert(isBalanced(balancedTree));
        assert(!isBalanced(unbalancedTree));
    }

}
