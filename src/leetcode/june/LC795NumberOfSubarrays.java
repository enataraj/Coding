package leetcode.june;

public class LC795NumberOfSubarrays {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int result = 0;
        int cnt = 0;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                cnt = i - j + 1;
                result += cnt;
            } else if (nums[i] < left) {
                result += cnt;
            } else {
                j = i + 1;
                cnt = 0;
            }

        }

        return result;
    }

    class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                int max = -1;
                for (int j = i; j < nums.length; j++) {
                    max = Math.max(max, nums[j]);
                    if (max > right) {
                        break;
                    }
                    if (max < left) {
                        continue;
                    }
                    result++;
                }
            }
            return result;
        }

    }

    private int numSubarrayBoundedMaxalt(int[] nums, int left, int right) {
        int i = 0, j = 0, n = nums.length, mx = Integer.MAX_VALUE, result = 0, last = 0;
        while (i < n && j < n) {
            mx = Math.max(mx, nums[j]);
            if (mx >= left && mx <= right) {
                if (nums[j] >= left && nums[j] <= right)
                    last = j;
                result += (last - i + 1);
            }
            j++;
            if (mx > right) {
                i = j;
                last = j;
                mx = Integer.MAX_VALUE;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC795NumberOfSubarrays obj = new LC795NumberOfSubarrays();
        int[] nums = { 2, 2, 2 };//{73,55,36,5,55,14,9,7,72,52};
        int left = 2;
        int right = 3;
        System.out.println(obj.numSubarrayBoundedMax(nums, left, right));
    }
    /*
     * [73,55,36,5,55,14,9,7,72,52]
    32
    69
     */
}
