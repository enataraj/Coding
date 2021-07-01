package leetcode.array;

public class LC41FirstMissingNumber {

    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) { // This is also important
                nums[i] = nums.length + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if (Math.abs(nums[i]) != nums.length + 1) {  // this line is important 
                int idx = Math.abs(nums[i]) - 1;
                if (nums[idx] > 0) {
                    nums[idx] *= -1;
                }

            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;

    }

    public static void main(String[] args) {
        LC41FirstMissingNumber obj = new LC41FirstMissingNumber();
        int[] nums = { 1 };
        System.out.println(obj.firstMissingPositive(nums));
    }
}
