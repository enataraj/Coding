package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;


// LeetCode Number 295
class MedianFinder {

    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {
        new MedianFinder();
    }

    public MedianFinder() {
        int num[] = { 2, 3, 4, 5, 6, 7, 9, 1011, 12 };
        for (int i = 0; i < num.length; i++) {
            addNum(num[i]);
            double res = findMedian();
            System.out.println(" Currrent Median : " + res);
        }

    }

    public void rebalance() {
        if (Math.abs(maxHeap.size() - minHeap.size()) == 2) {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(minHeap.poll());
            }

        }

    }

    public void addNum(int num) {
        if (maxHeap.size() == 0 || num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        rebalance();

    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) * 0.5;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }

    }
}
