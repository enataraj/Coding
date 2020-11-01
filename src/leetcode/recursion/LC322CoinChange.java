package leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC322CoinChange {

    int result = -1;

    public int coinChangeTLE(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            return -1;

        }

        if (amount <= 0) {
            return 0;
        }

        if (coins.length == 1) {
            if (amount % coins[0] != 0) {
                return -1;
            }
            return amount / coins[0];
        }

        Arrays.sort(coins);
        int i = 0, j = coins.length - 1;

        while (i < j) {
            int tmp = coins[i];
            coins[i] = coins[j];
            coins[j] = tmp;
            i++;
            j--;
        }

        System.out.println(Arrays.toString(coins));

        dfsHelper(coins, amount, 0, new ArrayList<Integer>());
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        return result;

    }

    private void dfsHelper(int[] coins, int amount, int index, List<Integer> combination) {

        

        if (amount == 0) {
            System.out.println(combination);
            result = combination.size();
            return;
        }
        if (result != -1) {
            return;
        }

        for (int i = index; i < coins.length && amount >= coins[i]; i++) {
            combination.add(coins[i]);
            dfsHelper(coins, amount - coins[i], i, combination);
            combination.remove(combination.size() - 1);

        }
    }
    
    

    public int coinChange(int[] coins, int amount) {
      if (amount < 1) return 0;
      return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
      if (rem < 0) return -1;
      if (rem == 0) return 0;
      if (count[rem - 1] != 0) return count[rem - 1];
      int min = Integer.MAX_VALUE;
      for (int coin : coins) {
        int res = coinChange(coins, rem - coin, count);
        if (res >= 0 && res < min)
          min = 1 + res;
      }
      count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
      return count[rem - 1];
    }
    
    public int coinChangeDP(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
          for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= i) {
              dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
          }
        }
        return dp[amount] > amount ? -1 : dp[amount];
      }

    public static void main(String[] args) {
        LC322CoinChange obj = new LC322CoinChange();
        // int[] coins = { 1, 2, 5 };
        // int amount = 11;

        int[] coins = { 227, 99, 328, 299, 42, 322 };
        int amount = 9847;

        System.out.println(obj.coinChange(coins, amount));
    }

}
