package leetcode.aug2021;

import java.util.Arrays;

public class LC91DecodeWays {

    public int numDecodingsIterative(String s) {
        int n = s.length();
        int dp1 = 1, dp2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            int dp = s.charAt(i) == '0' ? 0 : dp1;
            if (i < n - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                dp += dp2;
            }
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }

    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfsHelper(s, 0, memo);
    }

    private int dfsHelper(String s, int idx, int[] memo) {
        if (idx >= s.length()) {
            return 1;
        }
        if (s.charAt(idx) == '0') {
            return 0;
        }
        if (idx > s.length()) {
            return 1;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }
        int res = 0;
        res = dfsHelper(s, idx + 1, memo);

        if (Integer.parseInt(s.substring(idx, idx + 2)) <= 26) {
            res += dfsHelper(s, idx + 2, memo);
        }
        memo[idx] = res;
        return res;
    }
}
