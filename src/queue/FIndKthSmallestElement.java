package queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FIndKthSmallestElement {

    public static void main(String[] args) {
        int a[] = { 3, 1, 6, 4, 6, 7, 33, 6, 9 };
        int k=2;

        int res = findKthSmallestElement(a, k);
        Arrays.sort(a);
        for (int i : a) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.println(k+" the Smallest Element " + res);

    }

    private static int findKthSmallestElement(int[] a, int k) {

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < a.length; i++) {
            maxHeap.add(a[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();

            }
        }
        return maxHeap.peek();

    }

}
