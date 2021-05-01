package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import tree.util.TreeNode;

public class InorderTreversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> resultList = new ArrayList<Integer>();
        helper(root, resultList);
        return resultList;

    }

    private void helper(TreeNode node, List<Integer> resultList) {
        if (node == null) {
            return;
        }

        helper(node.left, resultList);
        resultList.add(node.val);
        helper(node.right, resultList);
    }

    public List<Integer> inorderTraversalItr(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> resultList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            resultList.add(node.val);
            node = node.right;
        }
        return resultList;
    }

}
