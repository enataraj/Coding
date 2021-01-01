package leetcode.dec;

import java.util.LinkedList;
import java.util.Queue;

public class LC117PopulateNextPointer2 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node pre = null;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i != 0) {
                    pre.next = node;
                }
                pre = node;
            }
        }

        return root;

    }

    public static void main(String[] args) {
        LC910SmallestRange2 obj = new LC910SmallestRange2();
    }

}
