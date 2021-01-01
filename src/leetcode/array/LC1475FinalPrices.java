package leetcode.array;

import java.util.Arrays;

public class LC1475FinalPrices {
    public int[] finalPrices(int[] prices) {
        if (prices == null || prices.length == 0) {
            return prices;
        }
        if (prices.length == 1) {
            return prices;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public static void main(String[] args) {
        LC1475FinalPrices obj = new LC1475FinalPrices();
        int[] prices = { 8, 4, 6, 2, 3 };
        int[] res = obj.finalPrices(prices);
        System.out.println(Arrays.toString(res));

    }

}
