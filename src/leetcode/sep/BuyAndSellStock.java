package leetcode.sep;

public class BuyAndSellStock {

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

    public static void main(String[] args) {
        BuyAndSellStock obj = new BuyAndSellStock();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(obj.maxProfit(prices));
    }

}
