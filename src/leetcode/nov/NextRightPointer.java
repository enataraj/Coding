package leetcode.nov;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointer {

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

    public Node connectSol(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        Node left = root;
        while (start.left != null) {

            while (start != null) {
                start.left.next = start.right;
                if (start.next != null) {
                    start.right.next = start.next.left;
                }
                start = start.next;
            }
            start = left.left;
            left = start;
        }
        return root;
    }

    public Node connect_Parin(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        Node thisLevelIter = root;

        while (thisLevelIter != null) {
            Node nextLevelDummy = new Node(), nextLevelIter = nextLevelDummy;

            while (thisLevelIter != null) {
                if (thisLevelIter.left != null) {
                    nextLevelIter.next = thisLevelIter.left;
                    nextLevelIter = nextLevelIter.next;
                }

                if (thisLevelIter.right != null) {
                    nextLevelIter.next = thisLevelIter.right;
                    nextLevelIter = nextLevelIter.next;
                }

                thisLevelIter = thisLevelIter.next;
            }

            thisLevelIter = nextLevelDummy.next;
        }

        return root;
    }

    public static void main(String[] args) {
        NextRightPointer obj = new NextRightPointer();

    }

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
}
