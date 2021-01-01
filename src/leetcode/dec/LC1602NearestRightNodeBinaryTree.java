package leetcode.dec;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.TreeNode;

public class LC1602NearestRightNodeBinaryTree {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        if (root == null)
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size() - 1;
            for (int i = 0; i <= size; i++) {
                TreeNode node = queue.poll();
                if (node == u) {
                    if (i == size) {
                        return null;
                    }
                    return queue.poll();
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

            }
        }

        return null;

    }

    public static void main(String[] args) {
        LC1602NearestRightNodeBinaryTree obj = new LC1602NearestRightNodeBinaryTree();
    }

}
