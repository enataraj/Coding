package leetcode.jan;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class LC215KthLargestElement {public int findKthLargest(int[] nums, int k) {
    if(nums.length == 0 || k > nums.length) return -1;
    int len = nums.length;
    Queue<Integer> pq = new PriorityQueue<>();
    int i=0;
    for(;i<k;i++) {
        pq.add(nums[i]);
    }
    while(i < len) {
        if(nums[i] > pq.peek()) {
            pq.poll();
            pq.add(nums[i]);
        }
        i++;
    }
    return pq.peek();
}
    
    
    

    public int findKthLargestAlt(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = queue.poll();
        }
        return res;
    }

    public int findKthLargestInital(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            queue.add(num);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = queue.poll();
        }
        return res;
    }

    public int findKthLargestQuickSort(int[] nums, int k) {
        int n = nums.length, left = 0, right = n - 1;

        Random r = new Random();

        while (left <= right) {
            int pivotIdx = left + r.nextInt(right - left + 1);
            int newPivotIdx = partition(nums, left, right, pivotIdx);

            if (newPivotIdx == k - 1) {
                return nums[k - 1];

            } else if (newPivotIdx > k - 1) {
                right = newPivotIdx - 1;

            } else {
                left = newPivotIdx + 1;
                k -= (newPivotIdx - left + 1);

            }
        }

        return -1; // should not reach here
    }

    private int partition(int[] nums, int left, int right, int pivotIdx) {
        swap(nums, left, pivotIdx);
        int pivotVal = nums[left], i = left + 1, j = right;

        for (; i <= j;) {
            if (nums[i] < pivotVal) {
                swap(nums, i, j);
                --j;

            } else {
                ++i;

            }
        }

        --i;
        swap(nums, left, i);
        return i;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC215KthLargestElement obj = new LC215KthLargestElement();
        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;

        // int[] nums = {3,2,1,5,6,4};
        // int k=2;
        System.out.println(obj.findKthLargest(nums, k));
    }

}
