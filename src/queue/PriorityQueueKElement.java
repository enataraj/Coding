package queue;

import java.util.PriorityQueue;
import java.util.Queue;
// Find the Kth Largest Element
public class PriorityQueueKElement {

    public static void main(String[] args) {
        int a[] = { 2, 1, 5, 3, 6, 7, 3, 6 };
        int res = findKthLargeElement(a, 3);
        System.out.println("Kth Largest Element " + res);

    }

    private static int findKthLargeElement(int a[], int k) {
        Queue<Integer> minHeap = new PriorityQueue<Integer>();

        if (k > a.length) {
            System.out.println("Element is not exist");
        }
        for (int i = 0; i < a.length; i++) {
            minHeap.add(a[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }

        }
        System.out.println("Queue size :" + minHeap.size());
        System.out.println(minHeap);
        return minHeap.peek();

    }
}
