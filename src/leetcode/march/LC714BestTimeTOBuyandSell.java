package leetcode.march;

public class LC714BestTimeTOBuyandSell {
    
    /*
     * case 1: I have stock on day i Represented by dp[i][1], select max of the below:
     *  - Case 1 : I bought it today
     *      dp[i][1] = dp[i-1][0] - prices[i]-fee;
     *  - Case 2 : I am carrying a pre-bought stock. Doing nothing toiday
     *      dp[i][1] = dp[i-1[1]
     *      
     * case 2 I dont have stock on day i. Represented by dp[i][0], select max of the below:
     *    - Case 1 : I sold the stock today
     *          dp[i][0] = dp[i-1][1]+price[i
     *    - Case 2 : I sold a stock at some previous day. Doing nothing today.
     *          dp[i][0] = dp[i-1][0]
     *    
     */

    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2)
            return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);

        }

        return dp[prices.length - 1][0];

    }

    public int maxProfitSol(int[] prices, int fee) {
        if (prices == null || prices.length == 0)
            return 0;
        int buy = -prices[0] - fee;
        int sell = 0;
        for (int i = 0; i < prices.length; i++) {
            int prebuy = buy;
            buy = Math.max(buy, sell - fee - prices[i]);
            sell = Math.max(sell, prebuy + prices[i]);
        }
        return sell;
    }
    
   
    
    
    
    public int maxProfitSol2(int[] prices, int fee) {
        if (prices == null || prices.length == 0 || fee < 0) {
           return 0;
       }
       int ans = 0;
       int maxAdd = -1*prices[0];
       for (int i = 1; i < prices.length; i++) {
           int tempAns = ans;
           ans = Math.max(ans, prices[i] + maxAdd - fee);
           maxAdd = Math.max(maxAdd, -1*prices[i] + tempAns);
       }
       return ans;
       
   }
    

}
