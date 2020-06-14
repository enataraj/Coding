package tree;

import java.util.ArrayList;
import java.util.List;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class InorderLeetCode {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorderTraversal(root, result);
        System.out.println("Result " + result);
        return result;

    }

    private static void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);

    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBinaryTree();
        new InorderLeetCode().inorderTraversal(root);

    }

}
