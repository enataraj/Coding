package leetcode.july2021;

import tree.util.TreeNode;

public class LC235LowestCommonAnscestor {
    TreeNode resultNode;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;

        TreeNode left = null;
        TreeNode right = null;

        if (root.val < p.val && root.val < q.val) {
            right = lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            left = lowestCommonAncestor(root.left, p, q);
        } else {

            left = lowestCommonAncestor(root.left, p, q);
            right = lowestCommonAncestor(root.right, p, q);
        }

        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }

    public TreeNode lowestCommonAncestorOpt(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans;
        if (p.val > q.val) {
            ans = getLCA(root, q.val, p.val);
        } else {
            ans = getLCA(root, p.val, q.val);
        }
        return ans;
    }

    private TreeNode getLCA(TreeNode node, int p, int q) {
        if (node == null) {
            return null;
        }

        if (p <= node.val && node.val <= q) {
            return node;
        } else if (node.val > q) {
            return getLCA(node.left, p, q);
        } else if (node.val < q) {
            return getLCA(node.right, p, q);
        }

        return null;
    }
    
    public TreeNode lowestCommonAncestorSol(TreeNode root, TreeNode p, TreeNode q) {

        // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }

    public static void main(String[] args) {
        LC235LowestCommonAnscestor obj = new LC235LowestCommonAnscestor();
    }

}
