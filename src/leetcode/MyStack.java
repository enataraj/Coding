package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int size = queue.size()-1;
        
        while(size-- > 0){
            queue.offer(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
