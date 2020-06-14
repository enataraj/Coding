package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class InOrderIterative {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBinaryTree();
        List<Integer> list = inorderTraversal(root);
        System.out.println(list);

    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }

        return result;

    }

}
