package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC617MergeTwoBinaryTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(t1);
        queue2.add(t2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();

                node1.val = node1.val + node2.val;

                if (node1.left == null && node2.left != null) {
                    node1.left = new TreeNode(0);
                    queue1.add(node1.left);
                    queue2.add(node2.left);
                } else if (node1.left != null && node2.left == null) {
                    node2.left = new TreeNode(0);
                    queue1.add(node1.left);
                    queue2.add(node2.left);
                } else if (node1.left != null && node2.left != null) {
                    queue1.add(node1.left);
                    queue2.add(node2.left);
                }

                if (node1.right == null && node2.right != null) {
                    node1.right = new TreeNode(0);
                    queue1.add(node1.right);
                    queue2.add(node2.right);
                } else if (node1.right != null && node2.right == null) {
                    node2.right = new TreeNode(0);
                    queue1.add(node1.right);
                    queue2.add(node2.right);
                } else if (node1.right != null && node2.right != null) {
                    queue1.add(node1.right);
                    queue2.add(node2.right);
                }

            }

        }

        return t1;

    }

    public TreeNode mergeTreesDFS(TreeNode t1, TreeNode t2) {
        return helper(t1, t2);
    }

    public TreeNode helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;

        if (t1 == null)
            return t2;

        if (t2 == null)
            return t1;

        TreeNode root = new TreeNode(t1.val + t2.val);

        root.left = helper(t1.left, t2.left);

        root.right = helper(t1.right, t2.right);

        return root;
    }

    public TreeNode mergeTreesOptSol(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }

    public static void main(String[] args) {
        LC617MergeTwoBinaryTree obj = new LC617MergeTwoBinaryTree();
        TreeNode root1 = TreeUtil.MergeTree1();
        TreeNode root2 = TreeUtil.MergeTree2();

        TreeUtil.printBinaryTreeInorder(obj.mergeTrees(root1, root2));
    }

}
