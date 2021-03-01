package leetcode.feb;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LC581ShortestUnSortedSubarray {
    
    // All number from me to left should be small
    // All number from me to right should be big
    
    

    public int findUnsortedSubarray(int[] nums) {
        int start = nums.length - 1;
        int minSoFar = Integer.MAX_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= minSoFar) {
                minSoFar = nums[i];
            } else
                start = i;
        }
        if (start == nums.length - 1)
            return 0;
        int end = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= maxSoFar) {
                maxSoFar = nums[i];
            } else
                end = i;
        }
        return end - start + 1;
    }
    
    // Using stack
    
    public int findUnsortedSubarrayStack(int[] nums) {
        int N = nums.length;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int start = N;
        int end = -1;

        for (int index = 0; index < N; index++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[index])
                start = Math.min(start, stack.poll());
            stack.push(index);
        }
        for (int index = N - 1; index >= 0; index--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index])
                end = Math.max(end, stack.poll());
            stack.push(index);
        }

        if (start >= end)
            return 0;
        return end - start + 1;
    }

    // stack space O(n)
    // stack used to track numbers bigger than all previous numbers
    // at each index i
    // compare with numbers in stack, if bigger than the top one, add it to the
    // stack as it's bigger than all previous numbers
    // if smaller than the top one, keep popping the top one and store the topest
    // one
    // in the end, add the topest one back to the stack(stack still holds its
    // assumption)
    // during this process, the smaller index is the end of the continuous subarray
    // the starting index is the smallist poped out index
    // public int findUnsortedSubarray(int[] nums) {
    // Stack<Integer> stack = new Stack<>();
    // int start = nums.length;
    // int end = 0;
    // for (int i = 0; i < nums.length; i++) {
    // if (stack.isEmpty() || nums[i] >= nums[stack.peek()]) {
    // stack.add(i);
    // } else {
    // end = i;
    // int top = stack.peek();
    // while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
    // start = Math.min(stack.pop(), start);
    // }
    // stack.add(top);
    // }
    // }
    // if (start == nums.length) {
    // return 0;
    // }
    // return end - start + 1;
    // }

    // by observing the above solution, actually we can get rid of the stack by
    // doing the two direction scan
    public int findUnsortedSubarraySol2(int[] nums) {
        int end = 0;
        int num = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= num) {
                num = nums[i];
            } else {
                end = i;
            }
        }
        int start = nums.length;
        num = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] <= num) {
                num = nums[j];
            } else {
                start = j;
            }
        }
        if (start == nums.length) {
            return 0;
        }
        return end - start + 1;
    }

    public int findUnsortedSubarraySol(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        int i = 0;
        int j = n - 1;

        while (i < n - 1 && nums[i] <= nums[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return 0;
        }

        while (j > i && nums[j - 1] <= nums[j]) {
            j--;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            min = Math.min(min, nums[k]);
            max = Math.max(max, nums[k]);
        }

        while (i > 0 && nums[i - 1] > min) {
            i--;
        }
        while (j < n - 1 && nums[j + 1] < max) {
            j++;
        }

        return j - i + 1;
    }

    
    // Sort and Compare with original array
    public int findUnsortedSubarraySort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        }
        int[] org = nums.clone();
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int start = 0;
        int end = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        int diff = 0;

        while (i < j) {
            if (nums[i] != org[i] && !flag1) {
                start = i;
                flag1 = true;
            } else if (!flag1) {
                i++;
            }
            if (nums[j] != org[j] && !flag2) {
                end = j;
                flag2 = true;
            } else if (!flag2) {
                j--;
            }

            if (flag1 && flag2) {
                diff = end - start + 1;
                break;
            }

        }
        return diff;
    }

    public static void main(String[] args) {
        LC581ShortestUnSortedSubarray obj = new LC581ShortestUnSortedSubarray();
        int[] nums = { 1, 2, 3, 5, 4 };
        // int[] nums = { 1, 3, 2, 4, 5 };
        System.out.println(obj.findUnsortedSubarray(nums));

    }

}
