package leetcode.may;

import java.util.HashSet;
import java.util.Set;

import tree.util.TreeNode;

public class LC968BinaryTreeCameras {

    Set<TreeNode> coveredNodes;
    int cameras = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        coveredNodes = new HashSet<>();
        coveredNodes.add(null);
        dfsHelper(root, null);
        return cameras;

    }

    private void dfsHelper(TreeNode node, TreeNode parent) {
        if (node != null) {
            dfsHelper(node.left, node);
            dfsHelper(node.right, node);
            if (parent == null && !coveredNodes.contains(node) || !coveredNodes.contains(node.left)
                    || !coveredNodes.contains(node.right)) {
                cameras++;
                coveredNodes.add(node);
                coveredNodes.add(parent);
                coveredNodes.add(node.left);
                coveredNodes.add(node.right);
            }
        }

    }

    public int minCameraCoverSol(TreeNode root) {
        // there are two cases
        // case1: place camera, for sure the current node is covered, state 1;
        // case2: no camera at the current node
        // case2A: but one of its child or parent has camera, so it is covered, state 2
        // case2B: none of its neighbor has camaera, it is not covered, state 0;
        cameras = 0;
        if (dfs(root) == 0) {
            cameras++;
        }
        return cameras;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 2;

        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == 0 || right == 0) {// if any of its child is not covered, a camera is a must here
            cameras++;
            return 1;
        } else if (left == 2 && right == 2) {
            return 0;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        LC968BinaryTreeCameras obj = new LC968BinaryTreeCameras();
    }

}
