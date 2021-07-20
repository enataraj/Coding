package leetcode.july2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tree.util.TreeNode;

public class LeavesOfBinaryTee {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<List<Integer>>();
        findLeavesHelper(root, leaves);
        return leaves;
    }

    private int findLeavesHelper(TreeNode node, List<List<Integer>> leaves) {
        if (node == null)
            return 0;
        int depth = Math.max(findLeavesHelper(node.left, leaves), findLeavesHelper(node.right, leaves));
        if (leaves.size() <= depth)
            leaves.add(new ArrayList<Integer>());
        leaves.get(depth).add(node.val);
        return 1 + depth;
    }
    
    Map<Integer, List<Integer>> leavesOrderMap = new HashMap<Integer, List<Integer>>();
    int max = 0;

    public List<List<Integer>> findLeavesAlt(TreeNode root) {
        maxDepth(root);
        List<List<Integer>> leavesOrder = new ArrayList<List<Integer>>();
        for (int min = 0; min <= max; min++)
            leavesOrder.add(leavesOrderMap.get(min));
        return leavesOrder;
    }

    private int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        int maxDepth = Math.max(maxDepth(node.left), maxDepth(node.right));
        max = Math.max(max, maxDepth);
        leavesOrderMap.computeIfAbsent(maxDepth, z -> new ArrayList<Integer>()).add(node.val);
        return 1 + maxDepth;
    }
}
