package leetcode.nov;

public class MaxAvgSubArray {

    public double findMaxAverage(int[] nums, int k) {
        double low = getMin(nums), high = getMax(nums);

        while (high - low > 0.00001) {
            double mid = low + (high - low) / 2;
            if (canFindLargerAverage(nums, k, mid)) {
                low = mid;

            } else {
                high = mid;

            }
        }

        return low;
    }

    private boolean canFindLargerAverage(int[] nums, int k, double mid) {
        int n = nums.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i] - mid;
        }

        double cur = 0.0, prev = 0.0;

        for (int i = 0; i < k; i++) {
            cur += a[i];
        }

        if (cur >= 0) {
            return true;
        }

        for (int i = k; i < n; i++) {
            cur += a[i];
            prev += a[i - k];

            if (prev < 0) {
                cur -= prev;
                prev = 0.0;
            }

            if (cur >= 0.0) {
                return true;
            }
        }

        return false;
    }

    private int getMin(int[] nums) {
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        return min;
    }

    private int getMax(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxAvgSubArray obj = new MaxAvgSubArray();
        int nums[] = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        obj.findMaxAverage(nums, k);

    }

}
