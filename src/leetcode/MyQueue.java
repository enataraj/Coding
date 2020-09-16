package leetcode;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(st2.size()==0)
        {
            while(st1.size()!=0) st2.push(st1.pop());
        }
        return st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(st2.size()==0)
        {
            while(st1.size()!=0) st2.push(st1.pop());
        }
        return st2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (st1.size()==0)&&(st2.size()==0);
    }

}
