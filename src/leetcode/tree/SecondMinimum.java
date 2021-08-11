package leetcode.tree;

import tree.util.TreeNode;

public class SecondMinimum {

    int globalmin = Integer.MAX_VALUE;
    boolean found = false;

    public int findSecondMinimumValueSOl(TreeNode root) {
        dfs(root, root.val);
        if (!found) {
            return -1;
        }
        return globalmin;
    }

    public void dfs(TreeNode node, int min) {
        if (node == null) {
            return;
        }
        if (node.val > min) {
            found = true;
            globalmin = Math.min(globalmin, node.val);
        }
        dfs(node.left, min);
        dfs(node.right, min);

    }

    int result = -1;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }
        dfsHelper(root);
        /*  if(result == Integer.MAX_VALUE){
            return -1;
        }*/
        return result;

    }

    private void dfsHelper(TreeNode node) {
        if (node == null || node.left == null) {
            return;
        }
        if (node.left != null) {
            if (result != -1) {

                result = Math.max(result, node.val);
            } else if (node.left != null && result == -1 && node.right.val != node.val) {
                result = Math.max(result, node.val);
            }
        }
        dfsHelper(node.left);
        dfsHelper(node.right);

    }

    public static void main(String[] args) {
        SecondMinimum obj = new SecondMinimum();

        System.out.println();
    }
}
