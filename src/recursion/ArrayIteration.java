package recursion;

import java.util.Arrays;

public class ArrayIteration {

    public void iterateArray(int[] nums) {
        System.out.println("Iteration ");
        System.out.println(Arrays.toString(nums));
        helpher(nums, 0);
        
        System.out.println("\nReverse: ");
        helpherReverse(nums, 0);

    }

    private void helpher(int[] nums, int idx) {
        if (idx == nums.length) {
            return;
        }
        System.out.print("  "+nums[idx]);
        helpher(nums, idx + 1);

    }

    private void helpherReverse(int[] nums, int idx) {
        if (idx == nums.length) {
            return;
        }
        helpherReverse(nums, idx + 1);
        System.out.print("  "+nums[idx]);

    }

    public static void main(String[] args) {
        ArrayIteration obj = new ArrayIteration();
        int[] nums = { 1,2,3,4,5 };
        obj.iterateArray(nums);
    }

}
