package leetcode.july2021;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> leftHeap_maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> rightHeap_minHeap = new PriorityQueue();

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (leftHeap_maxHeap.isEmpty() || num > leftHeap_maxHeap.peek()) {
            rightHeap_minHeap.add(num);
        } else {
            leftHeap_maxHeap.add(num);
        }
        rebalance();

    }

    private void rebalance() {
        if (Math.abs(leftHeap_maxHeap.size() - rightHeap_minHeap.size()) >= 2) {
            if (leftHeap_maxHeap.size() > rightHeap_minHeap.size()) {
                rightHeap_minHeap.add(leftHeap_maxHeap.poll());
            } else {
                leftHeap_maxHeap.add(rightHeap_minHeap.poll());
            }

        }
    }

    public double findMedian() {
        if (leftHeap_maxHeap.size() == rightHeap_minHeap.size()) {
            return (leftHeap_maxHeap.peek() + rightHeap_minHeap.peek()) * 0.5;
        }
        if (leftHeap_maxHeap.size() > rightHeap_minHeap.size()) {
            return leftHeap_maxHeap.peek();
        }
        return rightHeap_minHeap.peek();
    }
}
