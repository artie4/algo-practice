package leetcode;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {

    public static List<Integer> preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var tree = new TreeNode(5,
                new TreeNode(3, new TreeNode(1, null, null), new TreeNode(2, null, null)),
                new TreeNode(7, new TreeNode(8, null, null), new TreeNode(9, null, null))
        );
        assert(preorder(tree).equals(List.of(5, 3, 1, 2, 7, 8, 9)));
    }
}
