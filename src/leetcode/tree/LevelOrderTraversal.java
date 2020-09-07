package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.util.TreeNode;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> subList = null;
        while (!queue.isEmpty()) {
            subList = new ArrayList<>();
            int size = queue.size();  // This is important , Should not put queue.size in for loop in next line.
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);

                TreeNode leftNode = node.left;
                TreeNode rightNode = node.right;
                if (leftNode != null) {
                    queue.add(leftNode);
                }
                if (rightNode != null) {
                    queue.add(rightNode);
                }

            }

            resultList.add(subList);
        }

        return resultList;

    }

}
