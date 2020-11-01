package leetcode.sep;

public class SubarrayProduct {

    public int numSubarrayProductLessThanKTLE(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] < k) {
            return 1;
        }

        int numcnt = 0;
        int fact = 1;
        for (int y = 0; y < nums.length; y++) {
            if (nums[y] == 1) {
                numcnt++;
            }
            fact *= y+1;
        }

        if (nums.length == numcnt) {
            return fact;
        }
        int i = 0, j = 0;
        int product = 1;
        int count = 0;
        while (i < nums.length) {
            String str = "" + nums[i];
            product = nums[i];
            if (product < k) {
                count++;
            } else {
                i++;
                continue;
            }
            j = i + 1;
            while (j < nums.length) {
                product = product * nums[j];
                if (product < k) {
                    count++;
                } else {
                    break;
                }

                str = str.concat("," + nums[j]);
                j++;

            }
            i++;

        }
        return count;

    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int count = 0, window = 1, left = 0;
        for (int i = 0; i < nums.length; i++) {
            window *= nums[i];
            while (window >= k) {
                window /= nums[left++];
            }
            count += i - left + 1;
        }
        return count;
    }

    public int numSubarrayProductLessThanKN(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] < k) {
            return 1;
        }
        int count = 0;
        int product = 1;
        int preIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                count++;
            } else {
                preIdx = i;
            }
            product = product * nums[i];
            if (product < k) {
                count++;
            } else {
                while (product >= k) {
                    product = product / nums[preIdx];
                    preIdx++;
                }
                if (preIdx < i) {
                    count++;
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        SubarrayProduct obj = new SubarrayProduct();
        int[] nums = { 10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3 };
        int k = 19;
        System.out.println(obj.numSubarrayProductLessThanK(nums, k));

    }

}
