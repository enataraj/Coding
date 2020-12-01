package leetcode.nov;

import java.util.HashMap;
import java.util.Map;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class HouseRobber3 {

    
    // Most Optimized Solution
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] res = helper(root);
        return Math.max(res[0], res[1]);

    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }

        int[] leftres = helper(node.left);
        int[] rightres = helper(node.right);
        int res[] = new int[2];
        res[0] = node.val + leftres[1] + rightres[1];
        res[1] = Math.max(leftres[0], leftres[1]) + Math.max(rightres[0], rightres[1]);
        return res;

    }
    
    
    // Memo and Rob or not Rob flag

    public int rob_Memo(TreeNode root) {
        Map<TreeNode, Integer> robValues = new HashMap<>();
        Map<TreeNode, Integer> notRobValues = new HashMap<>();
        return rob(root, robValues, notRobValues, false);
    }

    private Integer rob(TreeNode node, Map<TreeNode, Integer> robValues, Map<TreeNode, Integer> notRobValues,
            boolean parentRobbed) {
        if (node == null)
            return 0;
        Integer val;
        if (parentRobbed) {
            if (robValues.containsKey(node))
                return robValues.get(node);
            val = rob(node.left, robValues, notRobValues, false) + rob(node.right, robValues, notRobValues, false);
            robValues.put(node, val);
        } else {
            if (notRobValues.containsKey(node))
                return notRobValues.get(node);
            int notRobValue = rob(node.left, robValues, notRobValues, false)
                    + rob(node.right, robValues, notRobValues, false);

            int robValue = node.val + rob(node.left, robValues, notRobValues, true)
                    + rob(node.right, robValues, notRobValues, true);
            val = Math.max(notRobValue, robValue);
            notRobValues.put(node, val);
        }
        return val;
    }
    
    
    //// Map Memorization

    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob_map(TreeNode root) {
        if (root == null)
            return 0;

        if (map.containsKey(root))
            return map.get(root);

        int cost = 0;
        if (root.left != null)
            cost += rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            cost += rob(root.right.left) + rob(root.right.right);

        int total = cost + root.val;

        map.put(root, Math.max(total, rob(root.left) + rob(root.right)));

        return map.get(root);

    }

    public static void main(String[] args) {
        HouseRobber3 obj = new HouseRobber3();
        TreeNode root = TreeUtil.constructTreeRobber3();
        System.out.println(obj.rob(root));

    }

}
