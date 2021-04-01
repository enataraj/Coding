package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.TreeNode;

public class LC226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode leftNode = node.left;
                TreeNode rightNode = node.right;
                if (leftNode != null) {
                    queue.add(leftNode);
                }
                if (rightNode != null) {
                    queue.add(rightNode);
                }
                node.right = leftNode;
                node.left = rightNode;
            }
        }
        return root;
    }

    public TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTreeDFS(root.left);
        TreeNode right = invertTreeDFS(root.left);
        root.left = right;
        root.right = left;
        return root;

    }

    public TreeNode invertTreePre(TreeNode root) {

        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreePre(root.left);
        invertTreePre(root.right);

        return root;

    }

    public static void main(String[] args) {
        LC226InvertBinaryTree obj = new LC226InvertBinaryTree();
    }

}
