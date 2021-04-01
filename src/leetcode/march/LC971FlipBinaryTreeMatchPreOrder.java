package leetcode.march;

import java.util.ArrayList;
import java.util.List;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC971FlipBinaryTreeMatchPreOrder {
    private List<Integer> result;
    private int idx;
    private int[] voyage;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        result = new ArrayList<>();
        idx = 0;
        if (dfsHelpher(root)) {
            return result;
        }
        result = new ArrayList<>();
        result.add(-1);
        return result;

    }

    private boolean dfsHelpher(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.val != voyage[idx++])
            return false;
        if (node.left != null && node.left.val != voyage[idx]) {
            result.add(node.val);
            return dfsHelpher(node.right) && dfsHelpher(node.left);

        }
        return dfsHelpher(node.left) && dfsHelpher(node.right);

    }

    public static void main(String[] args) {
        LC971FlipBinaryTreeMatchPreOrder obj = new LC971FlipBinaryTreeMatchPreOrder();
        TreeNode root = TreeUtil.constructVoyageMatch();
        int[] voyage = { 1, 3, 2 };
        System.out.println(obj.flipMatchVoyage(root, voyage));

    }

}
