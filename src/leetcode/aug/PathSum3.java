package leetcode.aug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class PathSum3 {

    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<Integer>();
        helperDFS(root, list, tmpList);
        
        System.out.println(list);

        return 0;

    }

    private void helperDFS(TreeNode node, List<List<Integer>> list, List<Integer> tmpList) {
        if (node == null) {
            list.add(tmpList);
            tmpList = new ArrayList<Integer>();

            return;
        }
        tmpList.add(node.val);
        helperDFS(node.left, list, tmpList);
        helperDFS(node.right, list, tmpList);
    }

    public static void main(String[] args) {

        PathSum3 obj = new PathSum3();
        TreeNode root = TreeUtil.constructBinaryTreeForPathSum3();
        System.out.println(obj.pathSum(root, 8));

    }
    
    
    
    public int pathSumopt(TreeNode root, int sum) {
        // prefixSum, numOccurrence
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        return dfs(root, sum, map, 0);
    }
    
    private int dfs(TreeNode curr, int target, Map<Integer, Integer> map, int sumSoFar) {
        if (curr == null) return 0;
        
        sumSoFar += curr.val;
        
        int res = map.getOrDefault(sumSoFar - target, 0);
        map.put(sumSoFar, map.getOrDefault(sumSoFar, 0) + 1);
        
        res += dfs(curr.left, target, map, sumSoFar) + dfs(curr.right, target, map, sumSoFar);
        map.put(sumSoFar, map.get(sumSoFar) - 1);
        
        return res;        
    }

}
