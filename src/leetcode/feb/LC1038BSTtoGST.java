package leetcode.feb;

import java.util.Deque;
import java.util.LinkedList;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC1038BSTtoGST {
    Deque<Integer> queue = new LinkedList<Integer>();
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null)
            return root;
        dfsHelpher(root, false);
        dfsHelpher(root, true);
        return root;

    }

    private void dfsHelpher(TreeNode node, boolean isSum) {
        if (node == null) {
            return;
        }

        dfsHelpher(node.left, isSum);
        if (!isSum) {
            sum += node.val;
            if (queue.isEmpty()) {
                queue.add(node.val);
            } else {
                queue.add(node.val + queue.peekLast());
            }
        } else {
            node.val = node.val + sum - queue.poll();
        }
        dfsHelpher(node.right, isSum);

    }

    public TreeNode convertBSTSol(TreeNode root) {
        if (root == null)
            return root;
        convertBST(root.right);
        sum = sum + root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return root;
        convertBST(root, 0);
        return root;

    }

    private int convertBST(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        root.val += convertBST(root.right, sum);
        return convertBST(root.left, root.val);

    }

    public static void main(String[] args) {
        LC1038BSTtoGST obj = new LC1038BSTtoGST();
        TreeNode root = TreeUtil.constructBalancedBinaryTreeBSTToGST();
        // TreeUtil.printBinaryTreeInorder(root);
        // root = obj.bstToGst(root);
        root = obj.convertBST(root);
        TreeUtil.printBinaryTreeInorder(root);

    }

}
