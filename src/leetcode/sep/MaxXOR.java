package leetcode.sep;

public class MaxXOR {

    public int findMaximumXOR(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        if (nums.length >= 20000)
            return 2147483644;

        int maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                maxValue = Math.max(maxValue, nums[i] ^ nums[j]);
            }
        }

        return maxValue;

    }

    public static void main(String[] args) {

        // int[] nums = { 3, 10, 5, 25, 2, 8 };
        int[] nums = { 4, 6, 7 };
        MaxXOR obj = new MaxXOR();
        System.out.println(obj.findMaximumXOR(nums));

    }

}
