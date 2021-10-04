package leetcode.oct2021;

public class LC1143LongestCommonSubsequences {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] lcsdp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    lcsdp[i][j] = 1 + lcsdp[i - 1][j - 1];

                } else {
                    lcsdp[i][j] = Math.max(lcsdp[i][j - 1], lcsdp[i - 1][j]);
                }
            }
        }
        return lcsdp[text1.length()][text2.length()];
    }

    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[] dp = new int[text2.length() + 1];
            char[] string2 = text2.toCharArray();
            for (char c : text1.toCharArray()) {
                for (int i = 1, prev = 0; i <= string2.length; i++) {
                    int curr = dp[i];
                    dp[i] = c == string2[i - 1] ? prev + 1 : Math.max(dp[i - 1], dp[i]);
                    prev = curr;
                }
            }
            return dp[string2.length];

        }
    }
    
    
    
    public int longestCommonSubsequencedfs(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        return dfsHelper(text1,text2,1,1,dp);
    }
    
    private int dfsHelper(String text1, String text2,int i,int j,int[][] dp) {
        if(i>=text1.length()+1 || j>=text2.length()+1) {
            return 0;
        }
        
        if(text1.charAt(i-1) == text2.charAt(j-1)) {
            dp[i][i] = 1+dp[i-1][j-1];
            dfsHelper(text1, text2, i+1, j+1, dp);
        }else {
            int val1 =  dfsHelper(text1, text2, i, j+1, dp);;
            int val2 =  dfsHelper(text1, text2, i+1, j, dp);
            dp[i][i] = Math.max(val1, val2);
        }     
        return dp[i][j];      
    }
    
    
    
}
