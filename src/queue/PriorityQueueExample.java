package queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        Queue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> maxHeap = new PriorityQueue<>();
        
        // Adding Element 
        
        
        minHeap.add(3);
        minHeap.add(10);
        minHeap.add(2);
        minHeap.add(3324);
        minHeap.add(33231);
        
        maxHeap.add(334);
        maxHeap.add(1230);
        maxHeap.add(22);
        maxHeap.add(3324);
        maxHeap.add(33231);
        
        System.out.println("MinHeap "+minHeap);
        System.out.println("Poll from Min Heap "+minHeap.poll());     
        System.out.println("MinHeap "+minHeap);
        System.out.println("Poll from Min Heap "+minHeap.poll());
        System.out.println("MinHeap "+minHeap);
        System.out.println("Peekl from Min Heap "+minHeap.peek());
        System.out.println("MinHeap "+minHeap);
      
      
        System.out.println("----------------------------------");
        
        System.out.println("MaxHeap "+maxHeap);
        System.out.println("Poll from Max Heap "+maxHeap.poll());
        System.out.println("MaxHeap "+maxHeap);
        System.out.println("Poll from Max Heap "+maxHeap.poll());
        System.out.println("MaxHeap "+maxHeap);
        System.out.println("Peek from Max Heap "+maxHeap.peek());
        System.out.println("MaxHeap "+maxHeap);
        
     

    }

}
