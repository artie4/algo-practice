package leetcode;


import java.util.Stack;

public class ValidBST {

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        var stack = new Stack<TreeNode>();
        var curNode = root;
        TreeNode prev = null;

        while (curNode!= null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            if (prev != null && curNode.val <= prev.val) return false;
            prev = curNode;
            curNode = curNode.right;
        }
        return true;
    }

    public static void main(String[] args) {
        var nonBST = new TreeNode(5)
                .leftNode(new TreeNode(3)
                        .leftNode(new TreeNode(2).leftNode(new TreeNode(1)))
                        .rightNode(new TreeNode(10)))
                .rightNode(new TreeNode(6)
                        .leftNode(new TreeNode(4))
                        .rightNode(new TreeNode(8))
        );
        var validBST = new TreeNode(5)
                .leftNode(new TreeNode(3)
                        .leftNode(new TreeNode(2).leftNode(new TreeNode(1)))
                        .rightNode(new TreeNode(4)))
                .rightNode(new TreeNode(7)
                        .leftNode(new TreeNode(6))
                        .rightNode(new TreeNode(8))
        );
        assert(!isValidBST(nonBST));
        assert(isValidBST(validBST));
    }

    /*
           5
          / \
         3  6
        /   /\
       2    4 8
     /  \
    1   10
    */
}
