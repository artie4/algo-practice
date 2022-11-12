package leetcode;

public class LowestCommonAncestorBST {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        var current = root;
        while (current != null) {
            if (current.val < min) {
                current = current.right;
            } else if (current.val > max) {
                current = current.left;
            } else {
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        var bst = new TreeNode(5)
                .leftNode(new TreeNode(3)
                        .leftNode(new TreeNode(2).leftNode(new TreeNode(1)))
                        .rightNode(new TreeNode(4)))
                .rightNode(new TreeNode(7)
                        .leftNode(new TreeNode(6))
                        .rightNode(new TreeNode(8))
                );

        assert(lowestCommonAncestor(bst, new TreeNode(2), new TreeNode(4)).val == 3);
        assert(lowestCommonAncestor(bst, new TreeNode(1), new TreeNode(8)).val == 5);
    }
}
