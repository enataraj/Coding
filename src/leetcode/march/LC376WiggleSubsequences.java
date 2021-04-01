package leetcode.march;

import java.util.Arrays;

public class LC376WiggleSubsequences {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return Math.max(down, up);
    }

    public int wiggleMaxLengthSrikanth(int[] nums) {

        if (nums.length < 2)
            return nums.length;
        int ret = 1;
        int trend = 0;// 1 is increasing, 2 is decreasing

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                continue;
            if (nums[i] > nums[i - 1]) {
                if (trend == 0 || trend == 2)
                    ret++;
                trend = 1;
            } else {
                if (trend == 0 || trend == 1)
                    ret++;
                trend = 2;
            }
        }
        return ret;

    }

    public int wiggleMaxLengthSol(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int prev = nums[1] - nums[0];
        int ans = prev == 0 ? 1 : 2;
        for (int i = 2; i < nums.length; i++) {
            int d = nums[i] - nums[i - 1];
            if ((d > 0 && prev <= 0) || (d < 0 && prev >= 0)) {
                ans++;
                prev = d;
            }
        }
        return ans;
    }

    public int wiggleMaxLengthParin(int[] nums) {
        int n = nums.length;

        if (n <= 1) {
            return n;
        }

        int[][] dp = new int[2][n];
        dp[0][0] = 1; // starts with mountain
        dp[1][0] = 1; // starts with valley

        for (int i = 1; i < n; i++) {
            int cur = nums[i], prev = nums[i - 1];

            if (cur > prev) {
                dp[0][i] = dp[1][i - 1] + 1;
                dp[1][i] = dp[1][i - 1];

            } else if (cur < prev) {
                dp[1][i] = dp[0][i - 1] + 1;
                dp[0][i] = dp[0][i - 1];

            } else {
                dp[0][i] = dp[0][i - 1];
                dp[1][i] = dp[1][i - 1];

            }
        }

        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }

    public int wiggle(int[] a) {
        if (a.length < 2)
            return a.length;

        int i = 1;
        while (i < a.length && a[i] == a[i - 1])
            i++;
        if (i == a.length)
            return 1;

        int c = 2;
        boolean inc = a[i] > a[i - 1];
        while (i < a.length) {
            if (inc) {
                while (i < a.length && a[i] >= a[i - 1])
                    i++;
                if (i < a.length)
                    c++;
                inc = false;
            } else {
                while (i < a.length && a[i] <= a[i - 1])
                    i++;
                if (i < a.length)
                    c++;
                inc = true;
            }

        }
        return c;
    }

    // DP like LIS
    public int wiggleDPSolution(int[] a) {
        if (a.length < 2)
            return a.length;
        int inc[] = new int[a.length], dec[] = new int[a.length];
        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);
        int ans = 1;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i])
                    inc[i] = Math.max(inc[i], 1 + dec[j]);
                if (a[j] > a[i])
                    dec[i] = Math.max(dec[i], 1 + inc[j]);
            }
            ans = Math.max(ans, Math.max(inc[i], dec[i]));
        }
        return ans;
    }

    public static void main(String[] args) {

        LC376WiggleSubsequences obj = new LC376WiggleSubsequences();
    }

}
