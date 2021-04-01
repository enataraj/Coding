package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class LC257BinaryTreePath {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        dfsHelpher(root, new StringBuffer());
        return result;
    }

    private void dfsHelpher(TreeNode node, StringBuffer buffer) {
        if (node == null) {
            return;
        }

        if (buffer.length() == 0) {
            buffer.append(node.val);
        } else {
            buffer.append("->" + node.val);
        }
        if (node.left == null && node.right == null) {
            result.add(buffer.toString());
            return;
        }

        dfsHelpher(node.left, new StringBuffer(buffer));
        dfsHelpher(node.right, new StringBuffer(buffer));

    }

    public List<String> binaryTreePathsSol(TreeNode root) {
        List<String> res = new ArrayList<>();
        traverse(root, res, new StringBuilder());
        return res;
    }

    private void traverse(TreeNode root, List<String> res, StringBuilder sb) {
        if (root == null)
            return;
        int length = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            sb.setLength(length);
            return;
        }
        sb.append("->");
        traverse(root.left, res, sb);
        traverse(root.right, res, sb);
        sb.setLength(length);
    }

    public List<String> binaryTreePathsBackTracking(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<Integer> values = new ArrayList<>();
        backtracking(root, values, paths);
        return paths;
    }

    private void backtracking(TreeNode node, List<Integer> values, List<String> paths) {
        if (node == null) {
            return;
        }
        values.add(node.val);
        if (isLeaf(node)) {
            paths.add(buildPath(values));
        } else {
            backtracking(node.left, values, paths);
            backtracking(node.right, values, paths);
        }
        values.remove(values.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            if (i != values.size() - 1) {
                str.append("->");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        LC257BinaryTreePath obj = new LC257BinaryTreePath();
        TreeNode root = TreeUtil.constructBinaryTreeForPath();
        obj.binaryTreePaths(root);
    }

}
