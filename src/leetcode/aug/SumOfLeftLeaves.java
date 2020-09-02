package leetcode.aug;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root.left, true) + dfs(root.right, false);

    }

    private int dfs(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            if (isLeft) {
                return node.val;
            }
            return 0;
        } else if (node.left == null) {
            return dfs(node.right, false);
        } else if (node.right == null) {
            return dfs(node.left, true);
        } else {
            return dfs(node.left, true) + dfs(node.right, false);
        }

    }

    public int sumOfLeftLeavesOpt(TreeNode root) {

        int[] sum = new int[1];
        sumOfLeftLeavesHelper(root, sum, false);
        return sum[0];
    }

    private void sumOfLeftLeavesHelper(TreeNode root, int[] sum, boolean left) {

        if (root == null)
            return;

        else if (root.left == null && root.right == null && left) {
            sum[0] += root.val;
        }

        else {
            sumOfLeftLeavesHelper(root.left, sum, true);
            sumOfLeftLeavesHelper(root.right, sum, false);
        }

    }

    class Data {
        TreeNode node;
        boolean isleft = false;

        public Data(TreeNode node, boolean isleft) {
            this.node = node;
            this.isleft = isleft;
        }
    }

    public int sumOfLeftLeavesBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(root, false));

        int sum = 0;

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Data data = queue.poll();
                if (data.node.left == null && data.node.right == null) {
                    if (data.isleft) {
                        sum = sum + data.node.val;
                    }
                } else {
                    if (data.node.left != null) {
                        queue.add(new Data(data.node.left, true));
                    }

                    if (data.node.right != null) {
                        queue.add(new Data(data.node.right, false));
                    }
                }
            }
        }

        return sum;

    }

    public static void main(String[] args) {

        SumOfLeftLeaves obj = new SumOfLeftLeaves();
        TreeNode root = TreeUtil.constructBinaryTree();
        System.out.println(obj.sumOfLeftLeaves(root));
        System.out.println(obj.sumOfLeftLeavesBFS(root));

    }

}
