package leetcode;

import java.util.Stack;

// Since Java API allows to do remove and get this will work, else we need to use two stack.

public class QueueUsingStack232 {
    Stack<Integer> queue;

    /** Initialize your data structure here. */
    public QueueUsingStack232() {
        queue = new Stack();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.remove(0);
    }

    /** Get the front element. */
    public int peek() {
        return queue.get(0);

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();

    }

    public static void main(String[] args) {
        QueueUsingStack232 obj = new QueueUsingStack232();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        System.out.println(obj.empty());
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.peek());
    }

}
