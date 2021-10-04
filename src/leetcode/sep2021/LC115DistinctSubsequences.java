package leetcode.sep2021;

import java.util.Arrays;

public class LC115DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        dfsHelper(s, t, 0, 0, memo);
        return memo[0][0];

    }

    private int dfsHelper(String s, String t, int i, int j, int[][] memo) {
        if (i >= s.length() || j >= t.length()) {
            if (j == t.length()) {
                return 1;
            }
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int result = 0;
        if (s.charAt(i) == t.charAt(j)) {
            result += dfsHelper(s, t, i + 1, j + 1, memo);
        }
        result += dfsHelper(s, t, i + 1, j, memo);
        memo[i][j] = result;
        return memo[i][j];

    }

    public int numDistinctDp(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        //  String s = "babgbag";
        // String t = "bag";
        LC115DistinctSubsequences obj = new LC115DistinctSubsequences();
        System.out.println(obj.numDistinctDp(s, t));
    }

    
    public int numDistinct1(String s, String t) {
        int M = s.length();
        int N = t.length();
        int[][] dp = new int[M][N];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return recurse(s, t, 0, 0, M, N, dp);
    }

    private int recurse(String s, String t, int si, int ti, int M, int N, int[][] dp) {
        if (si == M || ti == N || (M - si < N - ti))
            return (ti == N) ? 1 : 0;
        if (dp[si][ti] != -1)
            return dp[si][ti];
        int ans = recurse(s, t, si + 1, ti, M, N, dp);
        if (s.charAt(si) == t.charAt(ti))
            ans += recurse(s, t, si + 1, ti + 1, M, N, dp);
        return dp[si][ti] = ans;
    }



}
