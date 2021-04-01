package leetcode.stock;

public class LC123BestTImeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n <= 1) {
            return 0;
        }

        int[] forward = new int[n]; // [0,0,2,2,2,3,3,4]
        int minPriceSoFar = prices[0]; // 0

        for (int i = 1; i < n; i++) { // i = 6
            forward[i] = Math.max(forward[i - 1], prices[i] - minPriceSoFar);
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
        }

        int[] backward = new int[n]; // [0,0,0,0,0,0,3,0]
        int maxPriceSoFar = prices[n - 1]; // 4
        for (int i = n - 2; i >= 0; i--) { // i = 6
            backward[i] = Math.max(backward[i + 1], maxPriceSoFar - prices[i]);
            maxPriceSoFar = Math.max(prices[i], maxPriceSoFar);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, forward[i] + backward[i]);
        }

        return ans;
    }
}
