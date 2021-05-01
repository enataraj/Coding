package leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class LC589NAryTreePreOrder {

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

    List<Integer> result = new ArrayList<>();

    class Pair {
        Node node;
        int idx;

        public Pair(Node node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public List<Integer> preorder(Node root) {

        if (root == null)
            return Collections.EMPTY_LIST;
        dfsHelpher(root);
        return result;

    }

    private void dfsHelpher(Node node) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        for (Node child : node.children) {
            dfsHelpher(child);
        }

    }

    public List<Integer> preorderItr(Node root) {
        if (root == null)
            return Collections.EMPTY_LIST;
        List<Integer> result = new ArrayList<>();
        Stack<List<Node>> stack = new Stack<>();
        result.add(root.val);
        stack.push(root.children);
        while (!stack.empty()) {
            if (stack.peek().size() != 0) {
                Node node = stack.peek().remove(0);
                result.add(node.val);
                stack.push(node.children);
            } else {
                stack.pop();
            }
        }

        return result;

    }

    public List<Integer> preorderIter(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Deque<Node> stack = new ArrayDeque<>();

        stack.addFirst(root);
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            result.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.addFirst(child);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC589NAryTreePreOrder obj = new LC589NAryTreePreOrder();
    }
}
