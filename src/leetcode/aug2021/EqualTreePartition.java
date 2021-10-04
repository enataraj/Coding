package leetcode.aug2021;

import java.util.HashMap;
import java.util.Map;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class EqualTreePartition {

    Map<Integer, Integer> map = new HashMap<>();
    public boolean checkEqualTree(TreeNode root) {
        int sum = dfs(root);
        if (sum == 0)
            return map.get(0) > 1;
        return sum % 2 == 0 && map.containsKey(sum / 2);
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int sum = root.val + dfs(root.left) + dfs(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

    /*  int totalSum = 0;
    boolean result = false;
    int currentSum = 0;
    int numOfNode = 0;
    
    public boolean checkEqualTree(TreeNode root) {
        calculateTotalSum(root);
        System.out.println(totalSum);
        Set<Integer> cache = new HashSet<>();
        dfsHelper(root,cache);
        return result;
    }
    
    private void calculateTotalSum(TreeNode node) {
        if (node == null) {
            return;
        }
        totalSum += node.val;
        numOfNode++;
        calculateTotalSum(node.left);
        calculateTotalSum(node.right);
    }
    
    private void dfsHelper(TreeNode node, Set<Integer> cache) {
        if (node == null) {
            return;
        }
        currentSum += node.val;
       
        if (numOfNode!=0 && cache.contains(totalSum - currentSum)) {
            result = true;
        } else {
            System.out.println(currentSum);
            cache.add(currentSum);
        }
        numOfNode--;
        dfsHelper(node.left, cache);
        dfsHelper(node.right, cache);
    }*/

    public static void main(String[] args) {
        TreeNode root = TreeUtil.constructBTreeForEqual1();
        EqualTreePartition obj = new EqualTreePartition();
        System.out.println(obj.checkEqualTree(root));
        //{46,31,46,10,36,#,49,8,24,34,42,48,#,4,9,14,25,31,36,41,43,46,#,0,6,#,#,11,20,#,28,#,34,#,#,36,#,#,44,#,#,#,1,5,7,#,12,19,21,25,29,32,#,#,38,#,#,#,3,#,#,#,#,#,14,18,#,#,22,#,27,#,#,#,#,#,39,2,#,#,#,14,#,#,23,#,#,#,41,#,#,#,16,#,#,#,#,#,17}

    }

}
