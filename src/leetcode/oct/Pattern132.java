package leetcode.oct;

import java.util.Stack;

public class Pattern132 {

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

       
            Stack <Integer> stack = new Stack ();
            int second = Integer.MIN_VALUE;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums [i] < second)
                    return true;
                while (!stack.isEmpty() && nums [i] > stack.peek ())
                    second = stack.pop ();
                stack.push (nums [i]);
            }
       
        return false;

    }
    
    public boolean find132patternOpt(int[] nums) {
        int n = nums.length;
        int third = Integer.MIN_VALUE;
        int top = n;
        
        for (int i = n - 1; i >= 0; i--) {
            // Assumes that third is already smaller than some element nums[j] where j is between i and third's index
            // We find a "132" pattern if nums[i] < third
            if (nums[i] < third) return true;
            
            // Now we have nums[i] >= third
            
            // We now view nums[i] as the second element, and increase third as much as possible, but keep third < nums[i].
            // We do this because we want to maximize the chance of finding a "132" pattern in a future iteration.
            // Note that {nums[top], ..., nums[n-1]} is a stack has the following property:
            // nums[top] <= nums[top+1] <= ... <= nums[n-1]
            while (top < n && nums[i] > nums[top]) third = nums[top++];
            
            // Now we have nums[i] <= nums[top] (which indicates that the stack is monotonical)
            // We push nums[i] to the "stack"            
            top--;
            nums[top] = nums[i];
        }
        
        return false;
    }

    

    public static void main(String[] args) {
        Pattern132 obj = new Pattern132();
        // int[] nums = { 3, 1, 4, 2 };
         //int[] nums = { 1,2,3,4 };
        int[] nums = { 3, 5, 0, 3, 4 };
        System.out.println(obj.find132pattern(nums));
    }

}
