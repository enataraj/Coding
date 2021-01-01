package tree;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class BFSTreeTraversal {
    public static void main(String[] args) {
        TreeNode node = TreeUtil.constructBinaryTree();
        traversalBFS(node);

    }

    private static void traversalBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(" " + node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }
    }

}
