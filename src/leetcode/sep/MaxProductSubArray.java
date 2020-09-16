package leetcode.sep;

public class MaxProductSubArray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1) {
            return nums[0];
        }

        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmp = currentMax;
            currentMax = Math.max(currentMin * nums[i], Math.max(nums[i], nums[i] * currentMax));
            currentMin = Math.min(tmp * nums[i], Math.min(nums[i], nums[i] * currentMin));
            maxProduct = Math.max(currentMax, maxProduct);

        }

        return maxProduct;
    }

    public int maxProductOpt(int[] nums) {
        int product = 1;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if (product == 0) {
                product = 1;
            }
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if (product == 0) {
                product = 1;
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {

        MaxProductSubArray obj = new MaxProductSubArray();
        int nums[] = { -2, 0, -1 };
        System.out.println(obj.maxProduct(nums));

    }

}
