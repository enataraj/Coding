package leetcode;

public class BestTImeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        if (prices.length == 2) {
            if (prices[0] < prices[1]) {
                return prices[1] - prices[0];
            }
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                profit = profit + prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }

    public static void main(String[] args) {
        BestTImeToBuyAndSellStock2 obj = new BestTImeToBuyAndSellStock2();
        int[] prices = {7,1,5,3,6,4};
        //int[] prices = {1,2,3,4,5};
        //int[] prices ={7,6,4,3,1};
        System.out.println(obj.maxProfit(prices));
       
     
    }

}
