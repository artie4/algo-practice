package leetcode;

import leetcode.algo_1_path.TreeNode;

public class BalanceBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.getLeft());
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.getRight());
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
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
