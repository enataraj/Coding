package leetcode.aug2021;

import java.util.Arrays;

public class LC877StoneGame {



    public boolean stoneGame(int[] piles) {
        int[][][] memo = new int[piles.length + 1][piles.length + 1][2];

        // Initialize the memo with -1;
        for (int[][] subMemo : memo) {
            for (int[] subSubMemo : subMemo) {
                Arrays.fill(subSubMemo, -1);
            }
        }

        return dfsHelper(piles, memo, 0, piles.length - 1, 1) >= 0;
    }

    private int dfsHelper(int[] piles, int[][][] memo, int left, int right, int id) {
        if (left < right) {
            return 0;
        }
        if (memo[left][right][id] != -1) {
            return memo[left][right][id];
        }

        int nextId = Math.abs(id - 1);
        if (id == 1) {
            memo[left][right][id] = Math.max(piles[left] + dfsHelper(piles, memo, left + 1, right, nextId),
                    piles[right] + dfsHelper(piles, memo, left, right - 1, nextId));
        } else {
            memo[left][right][id] = Math.min(-piles[left] + dfsHelper(piles, memo, left + 1, right, nextId),
                    -piles[right] + dfsHelper(piles, memo, left, right - 1, nextId));

        }

        return memo[left][right][id];
    }

    class Solution {
        public boolean stoneGame(int[] nums) {
            if (nums == null || nums.length == 0) {
                return true;
            }

            int[][] dp = new int[nums.length][nums.length];

            // dp initialization
            for (int i = 0; i < dp.length; i++) {
                dp[i][i] = nums[i];
            }

            // filling dp table
            for (int len = 2; len <= nums.length; len++) {
                for (int i = 0; i < nums.length; i++) {
                    int j = i + len - 1;
                    if (j >= nums.length) {
                        continue;
                    }
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
            return dp[0][nums.length - 1] > 0;
        }
    }


}
