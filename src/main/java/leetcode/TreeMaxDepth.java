package leetcode;

import model.TreeNode;

import java.util.Stack;

public class TreeMaxDepth {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<NodeWrap> nodeStack = new Stack<>();
        int depth = 1;
        int maxDepth = 1;
        nodeStack.push(new NodeWrap(root, depth));

        while (!nodeStack.isEmpty()) {
            NodeWrap nodeWrap = nodeStack.pop();
            if (nodeWrap.depth > maxDepth) maxDepth = nodeWrap.depth;
            if (nodeWrap.treeNode.left != null) {
                nodeStack.push(new NodeWrap(nodeWrap.treeNode.left, nodeWrap.depth + 1));
            }
            if (nodeWrap.treeNode.right != null) {
                nodeStack.push(new NodeWrap(nodeWrap.treeNode.right, nodeWrap.depth + 1));
            }
        }
        return maxDepth;
    }

    public static class NodeWrap {
        public NodeWrap(TreeNode treeNode, int depth) {
            this.depth = depth;
            this.treeNode = treeNode;
        }

        int depth;
        TreeNode treeNode;
    }
}
