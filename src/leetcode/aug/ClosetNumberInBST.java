package leetcode.aug;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class ClosetNumberInBST {

    public int closestValue(TreeNode root, double target) {
        
        return 0;

    }

    public static void main(String[] args) {

        ClosetNumberInBST obj = new ClosetNumberInBST();
        TreeNode root = TreeUtil.constructBinarySearchTree();
        System.out.println(obj.closestValue(root, 3.17));

    }

}
