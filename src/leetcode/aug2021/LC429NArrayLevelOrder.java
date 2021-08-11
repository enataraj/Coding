package leetcode.aug2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC429NArrayLevelOrder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                levelValues.add(node.val);
                for (Node child : node.children) {

                    queue.add(child);
                }
            }
            result.add(levelValues);
        }
        return result;
    }

    class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(Node root) {
            if (root != null)
                traverseNode(root, 0);
            return result;
        }

        private void traverseNode(Node node, int level) {
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(node.val);
            for (Node child : node.children) {
                traverseNode(child, level + 1);
            }
        }
    }

}
