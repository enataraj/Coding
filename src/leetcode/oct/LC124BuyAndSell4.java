package leetcode.oct;

import java.util.Arrays;

public class LC124BuyAndSell4 {
    
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }
        
        if (k > n/2) {
            int ans = 0;
            
            for (int i = 1; i < n; i++) {
                ans += Math.max(0, prices[i] - prices[i-1]);
            }
            
            return ans;
        }
        
        int[] buys = new int[k],
            sells = new int[k];
        
        Arrays.fill(buys, Integer.MIN_VALUE);
        buys[0] = -prices[0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                buys[j] = Math.max(buys[j], (j == 0) ? -prices[i] : sells[j-1] - prices[i]);
                sells[j] = Math.max(sells[j], buys[j] + prices[i]);
            }
        }
        
        return sells[k-1];
    }
    
    
    public int maxProfitSol(int k, int[] prices) {
        if (k <= 0 || prices.length == 0) {
            return 0;
        }
        
        // we have unlimited transactions within prices
        if (2 * k > prices.length) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }
        
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 0; i < k + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < prices.length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < prices.length; j++) {
                max = Math.max(max, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], max + prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }

}
