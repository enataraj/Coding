package leetcode.topint;

class MinStack {

    Node top;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        if (top == null) {
            top = new Node();
            top.val = val;
            top.min = val;
        } else {
            Node node = new Node();
            node.val = val;
            node.min = Math.min(top.min, val);
            node.next = top;
            top = node;
        }
    }

    public void pop() {
        if (top == null) {
            return;
        }
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }

    class Node {

        Node next;
        int val;
        int min;

    }
}
