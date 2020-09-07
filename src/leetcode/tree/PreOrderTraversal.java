package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tree.util.TreeNode;

public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
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
        resultList.add(node.val);
        helper(node.left, resultList);
        helper(node.right, resultList);
    }

}
