package leetcode.dec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LC312BurstBallons {
    public int maxCoins1(int[] nums) {
        int res = 0;

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            res += (nums[0] * nums[nums.length - 1]);
            res += Math.max(nums[0], nums[nums.length - 1]);
            return res;

        }
        int idx = 0;
        int[] nums1 = new int[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            nums1[idx] = nums[i];
            idx++;
        }
        Arrays.sort(nums1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 1; j < list.size() - 1; j++) {
                if (nums1[i] == list.get(j)) {
                    System.out.println(list.get(j));
                    res += list.get(j - 1) * list.get(j) * list.get(j + 1);
                    list.remove(j);
                }

            }
        }
        System.out.println(list);
        res += (nums[0] * nums[nums.length - 1]);
        res += Math.max(nums[0], nums[nums.length - 1]);
        return res;
    }

    public int maxCoins(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int N = nums.length;

        // numsdd Bordering Balloons
        int[] B = new int[N + 2];
        B[0] = B[N + 1] = 1;

        for (int i = 1; i <= N; i++)
            B[i] = nums[i - 1];

        // Declaring DP array
        int[][] dp = new int[N + 2][N + 2];

        for (int length = 1; length < N + 1; length++) {
            for (int left = 1; left < N - length + 2; left++) {
                int right = left + length - 1;

                // For a sub-array from indices
                // left, right. This innermost
                // loop finds the last balloon burst
                for (int last = left; last < right + 1; last++) {
                    dp[left][right] = Math.max(dp[left][right],
                            dp[left][last - 1] + B[left - 1] * B[last] * B[right + 1] + dp[last + 1][right]);
                }
            }
        }
        return dp[1][N];

    }
    
    
    public int maxCoinsOpt(int[] nums) {
        int n = nums.length;
        int[] input = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            input[i] = nums[i - 1];
        }
        input[0] = input[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int j = 1; j <= n; j++) {
            for (int i = j; i >= 1; i--) {
                int x = Integer.MIN_VALUE;;
                for (int k = i; k <= j; k++) {
                    x = Math.max(x, dp[i][k - 1] + dp[k + 1][j] + input[i - 1] * input[k] * input[j + 1]);
                }
                dp[i][j] = x;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        LC312BurstBallons obj = new LC312BurstBallons();
        // int[] nums = { 3, 1, 5, 8 };
        // int[] nums = { 9, 76, 64, 21 };

        // 116718
        int[] nums = { 9, 76, 64, 21, 97, 60 };
        // 1086136
        System.out.println(obj.maxCoins(nums));
    }

}
