package leetcode.may;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC1695ErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int maxSum = 0;

        for (int num : nums) {
            if (numSet.contains(num)) {
                while (!queue.isEmpty() && queue.peek() != num) {
                    numSet.remove(queue.peek());
                    sum = sum - queue.poll();

                }
                queue.poll();
                queue.add(num);

            } else {
                numSet.add(num);
                queue.add(num);
                sum += num;
                maxSum = Math.max(maxSum, sum);
            }

        }
        return maxSum;
    }

    public int maximumUniqueSubarray_WithoutQueue(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int N = nums.length;
        int begin = 0;
        int sum = 0;
        int answer = 0;
        for (int end = 0; end < N; end++) {
            while (set.contains(nums[end])) {
                sum -= nums[begin];
                set.remove(nums[begin]);
                begin += 1;
            }
            sum += nums[end];
            set.add(nums[end]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    public static void main(String[] args) {
        //int[] nums = {5,2,1,2,5,2,1,2,5};
        int[] nums = { 187, 470, 25, 436, 538, 809, 441, 167, 477, 110, 275, 133, 666, 345, 411, 459, 490, 266, 987,
                965, 429, 166, 809, 340, 467, 318, 125, 165, 809, 610, 31, 585, 970, 306, 42, 189, 169, 743, 78, 810,
                70, 382, 367, 490, 787, 670, 476, 278, 775, 673, 299, 19, 893, 817, 971, 458, 409, 886, 434 };
        LC1695ErasureValue obj = new LC1695ErasureValue();
        System.out.println(obj.maximumUniqueSubarray(nums));
    }
}
