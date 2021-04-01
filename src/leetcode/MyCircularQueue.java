package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyCircularQueue {
    Queue<Integer> queue;
    int capacity;
    int lastElement;

    public MyCircularQueue(int k) {
        queue = new LinkedList<>();
        this.capacity = k;

    }

    public boolean enQueue(int value) {
        if (queue.size() < capacity) {
            queue.add(value);
            lastElement = value;
            return true;
        }

        return false;
    }

    public boolean deQueue() {
        if (!queue.isEmpty()) {
            queue.poll();
            return true;
        }
        return false;

    }

    public int Front() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peek();

    }

    public int Rear() {
        if (queue.isEmpty()) {
            return -1;
        }

        return lastElement;

    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return queue.size() == capacity;

    }

}
