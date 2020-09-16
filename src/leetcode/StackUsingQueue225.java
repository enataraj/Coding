package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingQueue225 {
    
    // THis can be implement just using queue

    Deque<Integer> stack;

    /** Initialize your data structure here. */
    public StackUsingQueue225() {
        stack = new ArrayDeque();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.add(x);
       

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.pollLast();

    }

    /** Get the top element. */
    public int top() {
        return stack.peekLast();

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        StackUsingQueue225 obj = new StackUsingQueue225();
    }

}
