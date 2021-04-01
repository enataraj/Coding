package leetcode.stock;

public class LC122BestTimeToBuyAndSellStockII {

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

}
