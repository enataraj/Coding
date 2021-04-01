package leetcode;

import java.util.ArrayList;
import java.util.List;

import tree.util.TreeNode;

public class LC897IncreasingOrderSearchTree {
    List<TreeNode> nodeList = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return root;
        dfsHelpher(root);
        root = nodeList.get(0);
        root.left = null;
        TreeNode node = root;
        TreeNode newNode = null;
        for (int i = 1; i < nodeList.size(); i++) {
            newNode = nodeList.get(i);
            node.right = newNode;
            newNode.left = null;
            node = node.right;

        }
        if (newNode != null) {
            newNode.right = null;
        }
        return root;

    }

    private void dfsHelpher(TreeNode node) {
        if (node == null) {
            return;
        }

        dfsHelpher(node.left);
        nodeList.add(node);
        dfsHelpher(node.right);
    }

    public static void main(String[] args) {
        LC897IncreasingOrderSearchTree obj = new LC897IncreasingOrderSearchTree();
    }

}
