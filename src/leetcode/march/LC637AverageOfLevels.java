package leetcode.march;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.util.TreeNode;

public class LC637AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return null;

        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum = sum + node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

            }
            result.add(sum / size);
        }
        return result;
    }

    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> sum = new ArrayList<Double>();
        List<Double> count = new ArrayList<Double>();

        cnt(root, 0, sum, count);

        for (int i = 0; i < sum.size(); i++) {
            sum.set(i, sum.get(i) / count.get(i));
        }
        return sum;
    }

    public void cnt(TreeNode root, int curLevel, List<Double> sum, List<Double> count) {
        if (root == null) {
            return;
        }

        if (sum.size() <= curLevel) {
            sum.add(new Double(root.val));
            count.add(new Double(1));
        } else {
            sum.set(curLevel, sum.get(curLevel) + root.val);
            count.set(curLevel, count.get(curLevel) + 1);
        }

        cnt(root.left, curLevel + 1, sum, count);
        cnt(root.right, curLevel + 1, sum, count);
    }

    public static void main(String[] args) {
        LC637AverageOfLevels obj = new LC637AverageOfLevels();
    }

}
