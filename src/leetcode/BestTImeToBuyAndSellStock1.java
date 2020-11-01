package leetcode;

public class BestTImeToBuyAndSellStock1 {
    
 public int maxProfit(int[] prices) {
        
        
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int minPriceSofar = prices[0];

        for (int i = 1; i < prices.length; i++) {

            minPriceSofar = Math.min(minPriceSofar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPriceSofar);

        }

        return maxProfit;

    
        
    }
 
 

}
