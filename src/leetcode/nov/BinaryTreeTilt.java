package leetcode.nov;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class BinaryTreeTilt {

    int result = 0;

    public int findTilt(TreeNode root) {

        postOrderDFSHelper(root);
        return result;

    }

    private int postOrderDFSHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lSum = postOrderDFSHelper(node.left);
        int rSum = postOrderDFSHelper(node.right);
        result += Math.abs(lSum - rSum);
        return lSum + rSum + node.val;

    }

    public static void main(String[] args) {
        BinaryTreeTilt obj = new BinaryTreeTilt();

        TreeNode root = TreeUtil.constructBinaryTreeTilt();
        System.out.println(obj.findTilt(root));

    }

}
