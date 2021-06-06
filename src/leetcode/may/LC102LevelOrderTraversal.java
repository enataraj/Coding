package leetcode.may;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import tree.util.TreeNode;

public class LC102LevelOrderTraversal {

    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        List<List<Integer>> resultList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmpList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            resultList.add(tmpList);
        }
        return resultList;
    }

    Map<Integer, List<Integer>> resultMap;

    public List<List<Integer>> levelOrder(TreeNode root) {
        resultMap = new HashMap<>();
        dfsHelper(root, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < resultMap.size(); i++) {
            result.add(resultMap.get(i));
        }
        return result;

    }

    private void dfsHelper(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (resultMap.containsKey(level)) {
            List<Integer> tmpList = resultMap.get(level);
            tmpList.add(node.val);
            resultMap.put(level, tmpList);

        } else {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(node.val);
            resultMap.put(level, tmpList);
        }

        dfsHelper(node.left, level + 1);
        dfsHelper(node.right, level + 1);

    }

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null)
            return;
        if (result.size() == level)
            result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }

}
