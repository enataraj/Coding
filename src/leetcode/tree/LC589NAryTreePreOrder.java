package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static void main(String[] args) {
        LC589NAryTreePreOrder obj = new LC589NAryTreePreOrder();
    }
}
