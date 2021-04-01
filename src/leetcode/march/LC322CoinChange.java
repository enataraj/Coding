package leetcode.march;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC322CoinChange {

    public int coinChangeDP(int[] coins, int amount) {
        // cc(0, 11) = 11
        // cc(1, 11) = 6
        // cc(2, 11) =
        // cc(i,j) = if coins[i] cc(i, j) cc(i-1, )
        // i = index of coins, j = amount
        // cc[coins.length-1][amount] = answer
        //

        // cc(a) = cc(a) - cc(a-cc(i)) + 1

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                if (dp[i - coin] == -1)
                    continue;
                if (min == -1)
                    min = dp[i - coin] + 1;
                // else min = Math.min(min, dp[i-coin]) + 1;
                else {
                    int temp = dp[i - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }

            }
            dp[i] = min;
        }
        return dp[amount];
    }

    public int coinChangeDFS(int[] coins, int amount) {
        // 1 + min(10,6,9);

        Arrays.sort(coins);
        int[] min = new int[] { Integer.MAX_VALUE };
        dfs(coins, coins.length - 1, amount, 0, min);
        return (min[0] == Integer.MAX_VALUE) ? -1 : min[0];
    }

    private void dfs(int[] coins, int index, int amount, int count, int[] min) {
        if (amount < 0) {
            return;
        }

        for (int num = amount / coins[index]; num >= 0; num--) {
            int remain = amount - num * coins[index];
            if (remain == 0) {
                min[0] = Math.min(min[0], num + count);
            }

            if (count + num + 1 < min[0] && index > 0) {
                dfs(coins, index - 1, remain, count + num, min);
            } else {
                return;
            }
        }
    }

    public int coinChangeParin(int[] coins, int amount) {
        Arrays.sort(coins);
        Map<Integer, Integer> cache = new HashMap<>();
        return helper(coins, amount, cache);

    }

    private int helper(int[] coins, int amount, Map<Integer, Integer> cache) {
        if (amount == 0) {
            return 0;
        }

        if (cache.containsKey(amount)) {
            return cache.get(amount);
        }

        int n = coins.length, minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < n && amount >= coins[i]; i++) {
            int prev = helper(coins, amount - coins[i], cache);
            if (prev > -1) {
                minCoins = Math.min(minCoins, 1 + prev);
            }
        }

        if (minCoins == Integer.MAX_VALUE) {
            minCoins = -1;
        }

        cache.put(amount, minCoins);
        return minCoins;
    }

}
