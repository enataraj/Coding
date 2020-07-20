package leetcode.july;

import tree.util.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val)
            return false;

       return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val)
            return false;

       return helper(p.left, q.left) && helper(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;

        root.right.left = null;
        root.right.right = new TreeNode(5);
        
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = null;

        root1.right.left = null;
        root1.right.right = new TreeNode(5);

        SameTree obj = new SameTree();
        System.out.println(obj.isSameTree(root, root1));
        
        

    }

}
