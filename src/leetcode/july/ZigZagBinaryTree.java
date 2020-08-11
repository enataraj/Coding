package leetcode.july;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import tree.util.TreeNode;

public class ZigZagBinaryTree {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Deque<TreeNode> queue = new ArrayDeque();
        queue.add(root);

        boolean flag = true;

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {

                if (flag) {
                    TreeNode node = queue.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                } else {
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }

            }

            resultList.add(list);
            flag = !flag;

        }

        return resultList;

    }

    public List<List<Integer>> zigzagLevelOrderOpt(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        explore(root, 0, result);
        return result;
    }

    public void explore(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        if (result.size() == level) {
            result.add(new ArrayList<Integer>());
        }
        if (level % 2 == 0)
            result.get(level).add(root.val);
        else
            result.get(level).add(0, root.val);
        explore(root.left, level + 1, result);
        explore(root.right, level + 1, result);
    }

    public static void main(String[] args) {

        ZigZagBinaryTree obj = new ZigZagBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        root.left.right = null;

        root.right.left = null;

        root.right.right = new TreeNode(5);

        List<List<Integer>> result = obj.zigzagLevelOrder(root);
        System.out.println(result);

    }

}
