package leetcode.may;

import tree.util.TreeNode;

public class LC114FlatterenLinkedList {
    public void flatten(TreeNode root) {
        dfsHelper(root);

    }

    private void dfsHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        dfsHelper(left);
        dfsHelper(right);
        node.right = left;

        TreeNode currNode = node;
        while (currNode.right != null) {
            currNode = currNode.right;
        }
        currNode.right = right;
    }

    // Morries Traversal

    public void flattenMorries(TreeNode root) {

        if (root == null) {
            return;
        }

        while (root != null) {
            if (root.left != null) {
                TreeNode left = root.left;
                TreeNode curNode = left;
                while (curNode.right != null) {
                    curNode = curNode.right;
                }
                curNode.right = root.right; // Morris Traversal
                root.left = null;
                root.right = left;
            }
            root = root.right;

        }
    }

    public static void main(String[] args) {
        LC114FlatterenLinkedList obj = new LC114FlatterenLinkedList();
    }

}
