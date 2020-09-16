package array;

import java.util.Arrays;

public class UnSortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
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

    public int findUnsortedSubarrayAlt(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
// Approach with stack:        
//         Stack<Integer> stack = new Stack();
//         int start = nums.length, end = 0;
//         for(int i = 0; i < nums.length; i++) {
//             while(!stack.isEmpty() && nums[stack.peek()] > nums[i])
//                 start = Math.min(start, stack.pop());
//             stack.push(i);
//         }

//         stack.clear();
//         for(int i = nums.length-1; i >= 0; i--) {
//             while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
//                 end = Math.max(end, stack.pop());
//             stack.push(i);
//         }

//         return (end-start > 0) ? end-start+1 : 0;

// Approach without stack (smarter):
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean enteredSubarray = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                enteredSubarray = true;
            if (enteredSubarray)
                min = Math.min(min, nums[i]);
        }

        enteredSubarray = false;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                enteredSubarray = true;
            if (enteredSubarray)
                max = Math.max(max, nums[i]);
        }

        int start, end;

        for (start = 0; start < nums.length; start++) {
            if (min < nums[start])
                break;
        }

        for (end = nums.length - 1; end >= 0; end--) {
            if (max > nums[end])
                break;
        }

        return (end - start > 0) ? end - start + 1 : 0;
    }

    public static void main(String[] args) {
        UnSortedSubarray obj = new UnSortedSubarray();
        int[] nums = { 2, 6, 4, 8, 10, 9, 15 };

        System.out.println(obj.findUnsortedSubarray(nums));

    }

}
