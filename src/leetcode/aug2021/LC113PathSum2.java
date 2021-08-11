package leetcode.aug2021;

import java.util.ArrayList;
import java.util.List;

import tree.util.TreeNode;

public class LC113PathSum2 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfsHelper(root, new ArrayList<>(), 0, targetSum);
        return result;

    }

    private void dfsHelper(TreeNode node, List<Integer> curPath, int curSum, int targetSum) {
        if (node == null) {
            return;
        }
        curPath.add(node.val);
        curSum += node.val;
        dfsHelper(node.left, curPath, curSum, targetSum);
        dfsHelper(node.right, curPath, curSum, targetSum);

        if (node.left == null && node.right == null && targetSum == curSum) {
            result.add(new ArrayList<>(curPath));
        }
        curPath.remove(curPath.size() - 1);
    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            dfsHelper(root, new ArrayList<>(), 0, targetSum);
            return result;

        }

        private void dfsHelper(TreeNode node, List<Integer> curPath, int curSum, int targetSum) {
            if (node == null) {
                return;
            }
            curPath.add(node.val);
            curSum += node.val;

            if (node.left == null && node.right == null && targetSum == curSum) {
                result.add(new ArrayList<>(curPath));
            }
            dfsHelper(node.left, curPath, curSum, targetSum);
            dfsHelper(node.right, curPath, curSum, targetSum);
            curPath.remove(curPath.size() - 1);
        }
    }

    class Solution2 {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            dfs(root, targetSum, new ArrayList<>(), res);
            return res;
        }

        private void dfs(TreeNode root, int remain, List<Integer> temp, List<List<Integer>> res) {
            if (root == null) {
                return;
            }
            temp.add(root.val);
            if (root.left == null && root.right == null && root.val == remain) {
                res.add(new ArrayList<>(temp));
            }
            dfs(root.left, remain - root.val, temp, res);
            dfs(root.right, remain - root.val, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

}
