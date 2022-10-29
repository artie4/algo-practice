package leetcode;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode leftNode(TreeNode _left) {
        left = _left;
        return this;
    }

    public TreeNode rightNode(TreeNode _right) {
        right = _right;
        return this;
    }
}