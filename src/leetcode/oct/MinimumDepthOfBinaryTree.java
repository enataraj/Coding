package leetcode.oct;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

           
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                } 
                if (node.right != null) {

                    queue.add(node.right);
                }

            }
        }
        return depth;
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree obj = new MinimumDepthOfBinaryTree();
        TreeNode root = TreeUtil.constructBinaryTreeDepth();
        System.out.println(obj.minDepth(root));

    }

}
