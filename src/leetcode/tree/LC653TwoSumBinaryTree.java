package leetcode.tree;

import java.util.HashSet;
import java.util.Set;

import tree.util.TreeNode;

public class LC653TwoSumBinaryTree {
    private Set<Integer> cache = new HashSet<>();
    private boolean result = false;

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        dfsHelpher(root, k);
        return result;

    }

    private void dfsHelpher(TreeNode node, int k) {
        if (node == null)
            return;
        if (result)
            return;
        if (cache.contains(k - node.val)) {
            result = true;
            return;
        }
        cache.add(node.val);
        dfsHelpher(node.left, k);
        dfsHelpher(node.right, k);
    }

    public boolean findTargetSol(TreeNode root, int k) {
        return findTargetH(root, k, root);
    }

    private boolean findTargetH(TreeNode curr, int k, TreeNode root) {
        if (curr == null) {
            return false;
        }

        TreeNode t = search(root, k - curr.val);
        return (t != null && t != curr) || findTargetH(curr.left, k, root) || findTargetH(curr.right, k, root);

    }

    private TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val > val) {
            return search(root.left, val);
        }
        return search(root.right, val);

    }

    public static void main(String[] args) {
        LC653TwoSumBinaryTree obj = new LC653TwoSumBinaryTree();
    }

}
