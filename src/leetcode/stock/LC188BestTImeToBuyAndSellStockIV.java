package leetcode.stock;

import java.util.Arrays;

public class LC188BestTImeToBuyAndSellStockIV {
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

}
