package leetcode.tree;

import java.util.List;

public class LC559MaximumDepthNaryTree {

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

    int result = 1;

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        dfsHelpher(root, 1);
        return result;

    }

    private void dfsHelpher(Node node, int level) {
        if (node == null) {         
            return;
        }

        result = Math.max(level, result);
        for (Node child : node.children) {
            dfsHelpher(child, level + 1);
        }

    }

    public static void main(String[] args) {
        LC559MaximumDepthNaryTree obj = new LC559MaximumDepthNaryTree();
    }

}
