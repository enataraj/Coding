package leetcode.jan;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class LC1673MostCompetitiveSequence {
    
    public int[] mostCompetitive(int[] nums, int k) {
        int res[] = new int[k];
        int top = 0;
        for(int i=0;i<nums.length;i++) {
            while(top>0 && nums[i]<res[top-1]&& top+nums.length-i>k) {
                top--;
            }
            if(top<k) {
                res[top++] = nums[i];
            }
        }
        
        return res;
    }

    public int[] mostCompetitiveStack(int[] nums, int k) {
        int res[] = new int[k];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()] && stack.size() + nums.length - i > k) {
                stack.pop();
            }

            if (stack.size() < k) {
                stack.push(i);
            }
        }

        int i = k;
        while (!stack.isEmpty()) {
            res[--i] = nums[stack.pop()];
        }
        return res;
    }

    public int[] mostCompetitiveTLE(int[] nums, int k) {
        int res[] = new int[k];
        int startIdx = 0;
        int currentStartIdx = -1;
        int len = nums.length;

        int endIdx = len - k;
        if (k > len - 1)
            return nums;
        int insertIdx = 0;

        while (endIdx < len) {
            int min = Integer.MAX_VALUE;
            startIdx = currentStartIdx + 1;
            endIdx = len - k;

            // System.out.println(startIdx+","+endIdx);

            while (endIdx < len && startIdx <= endIdx) {
                if (min > nums[startIdx]) {
                    currentStartIdx = startIdx;
                    min = nums[startIdx];
                }
                startIdx++;
            }

            if (insertIdx < res.length) {
                res[insertIdx] = nums[currentStartIdx];
            }
            insertIdx++;
            k--;
            System.out.println(Arrays.toString(res));

        }

        return res;

    }

    public int[] mostCompetitiveArray(int[] nums, int k) {

        int[] arr = new int[k];
        int[] minIndices = new int[nums.length];
        minIndices[nums.length - 1] = nums.length - 1;
        int minIndex = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[minIndex])
                minIndex = i;
            minIndices[i] = minIndex;
        }

        System.out.println(Arrays.toString(minIndices));
        int j = 0;

        for (int i = 0; i < k; i++) {
            if ((nums.length - minIndices[j]) >= k - i) {
                arr[i] = nums[minIndices[j]];
                j = minIndices[j] + 1;
            } else {
                minIndex = j;
                j++;
                for (; j <= nums.length - k + i; j++) {
                    if (nums[j] < nums[minIndex])
                        minIndex = j;
                }
                arr[i] = nums[minIndex];
                j = minIndex + 1;
            }
        }
        return arr;
    }

    public int[] mostCompetitiveDeque(int[] nums, int k) { // [2,4,3,3,5,4,9,6], 4
        Deque<Integer> dq = new ArrayDeque<>(); // 2
        int n = nums.length, // 8
                idx = 0; // 1

        while (idx < n) {
            while (!dq.isEmpty() && dq.size() + (n - idx) > k && dq.peekLast() > nums[idx]) {

                dq.pollLast();
            }

            dq.addLast(nums[idx]);
            ++idx;
        }

        // System.out.println(dq);
        int[] ans = new int[k];
        int writeIdx = 0;
        while (writeIdx < k) {
            ans[writeIdx++] = dq.pollFirst();
        }

        return ans;

    }

    public static void main(String[] args) {
        LC1673MostCompetitiveSequence obj = new LC1673MostCompetitiveSequence();
        // int nums[] = {2,4,3,3,5,4,9};
        // int k = 4;
        // int k=2;
        // int nums[] = {3,5,2,6};

        int nums[] = { 50, 100, 38, 1 };
        int k = 3;
        System.out.println(Arrays.toString(obj.mostCompetitive(nums, k)));
        System.out.println(Arrays.toString(obj.mostCompetitiveStack(nums, k)));

    }

}
