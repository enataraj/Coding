package leetcode.july;

public class StockMaxProfit {
    
    public int maxProfit(int[] prices) {
        long noStock = 0, hasStock = Integer.MIN_VALUE, prevNoStock = 0;
        for (int price : prices) {
            long tmp = noStock;
            noStock = Math.max(noStock, hasStock + price);
            hasStock = Math.max(hasStock, prevNoStock - price);
            prevNoStock = tmp;
        }
        return (int)noStock;
    }
    
    
    public int maxProfitParin(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        
        if (n == 2) {
            return Math.max(prices[1] - prices[0], 0);
        }
        
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-2][0] - prices[i], dp[i-1][1]);
        }
        
        return dp[n-1][0];
    }
    
    

}
