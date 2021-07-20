package leetcode.topint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC236LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfsHelper(root, p, q);
    }

    private TreeNode dfsHelper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return node;
        }
        if (node == p || node == q) {
            return node;

        }

        TreeNode left = dfsHelper(node.left, p, q);
        TreeNode right = dfsHelper(node.right, p, q);

        if ((left == p || left == q) && (left == q || right == q)) {
            return node;

        }

        if (left == null && right != null) {
            return right;
        }
        if (left != null && right == null) {
            return left;
        }

        return null;

    }

    public TreeNode lowestCommonAncestorSol(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }

    public TreeNode lowestCommonAncestorAlt(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>();
        getParents(root, p, q, null, parents);

        Set<TreeNode> ancestors = new HashSet<TreeNode>();
        while (p != null) {
            ancestors.add(p);
            p = parents.get(p);
        }
        while (!ancestors.contains(q))
            q = parents.get(q);
        return q;
    }

    private void getParents(TreeNode node, TreeNode p, TreeNode q, TreeNode parent, Map<TreeNode, TreeNode> parents) {
        if (node == null)
            return;
        if (parents.containsKey(p) && parents.containsKey(q))
            return;
        parents.put(node, parent);
        getParents(node.left, p, q, node, parents);
        getParents(node.right, p, q, node, parents);
    }

    public static void main(String[] args) {
        LC236LowestCommonAncestor obj = new LC236LowestCommonAncestor();
        TreeNode root = TreeUtil.constructBalancedBinaryTree();
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(3);
        System.out.println(obj.lowestCommonAncestorSol(root, p, q));
    }

}
