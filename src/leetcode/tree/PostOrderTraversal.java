package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tree.util.TreeNode;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
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
        helper(node.right, resultList);
        resultList.add(node.val);
    }

}
