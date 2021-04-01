package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MyCircularQueueList {

    List<Integer> queue;
    int capacity;

    public MyCircularQueueList(int k) {
        queue = new ArrayList<>();
        capacity = k;

    }

    public boolean enQueue(int value) {
        if (queue.size() < capacity) {
            queue.add(value);
            System.out.println("EeQueu "+queue);
            return true;
        }

        return false;
    }

    public boolean deQueue() {

        if (!queue.isEmpty()) {
            queue.remove(0);
            System.out.println("DeQueu "+queue);
            return true;
        }
        return false;

    }

    public int Front() {

        if (queue.isEmpty()) {
            return -1;
        }
        return queue.get(0);

    }

    public int Rear() {

        if (queue.isEmpty()) {
            return -1;
        }

        return queue.get(queue.size() - 1);

    }

    public boolean isEmpty() {
        return queue.isEmpty();

    }

    public boolean isFull() {
        return queue.size() == capacity;

    }

    
    public static void main(String[] args) {
        MyCircularQueueList obj = new MyCircularQueueList(8);
        obj.enQueue(3);
        obj.enQueue(9);
        obj.enQueue(5);
        obj.enQueue(0);
        obj.deQueue();
        obj.deQueue();
        obj.Rear();
        obj.Rear();
        obj.deQueue();
        
        
    }
}

// [[8],[3],[9],[5],[0],[],[],[],[],[],[],[]]