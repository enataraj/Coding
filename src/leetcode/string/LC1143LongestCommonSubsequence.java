package leetcode.string;

public class LC1143LongestCommonSubsequence {

    // Recursion with Memo Solution
    
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return longestCommonSubsequence(text1, text2, 0, 0, dp);

    }

    private static int longestCommonSubsequence(String text1, String text2, int i, int j, int[][] dp) {
        if (text1.length() == i || text2.length() == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j))
            return dp[i][j] = 1 + longestCommonSubsequence(text1, text2, i + 1, j + 1, dp);

        return dp[i][j] = Math.max(longestCommonSubsequence(text1, text2, i + 1, j, dp),
                longestCommonSubsequence(text1, text2, i, j + 1, dp));
    }

    // DP Solution
    public int longestCommonSubsequenceDP(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[text1.length()][text2.length()];
    }

}
