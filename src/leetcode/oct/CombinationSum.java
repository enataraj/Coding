package leetcode.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * 
 * 
 * 
 * [2]      [2, 2]          [2, 2, 2]               [2, 2, 2, 2]                [2, 2, 2, 3]                [2, 2, 2, 6]                [2, 2, 2, 7]            [2, 2, 3]           [2, 2, 6]           [2, 2, 7]       [2, 3]          [2, 3, 3]           [2, 3, 6]           [2, 3, 7]       [2, 6]      [2, 7]  [3]         [3, 3]          [3, 3, 3]           [3, 3, 6]           [3, 3, 7]       [3, 6]      [3, 7]  [6]         [6, 6]      [6, 7]  [7] 
 * 
 */

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int remaining, int idx, List<List<Integer>> res, List<Integer> partial) {
        if (remaining == 0) {
            res.add(new ArrayList<>(partial));
            return;
        }

        for (int i = idx; i < candidates.length && candidates[i] <= remaining; i++) {
            partial.add(candidates[i]);
            helper(candidates, remaining - candidates[i], i, res, partial);
            partial.remove(partial.size() - 1);
        }

    }

    // Bottom-up DP
    public List<List<Integer>> combinationSumDp(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>>[] dp = new List[target + 1];
        // Initialization
        for (int i = 0; i <= target; i++)
            dp[i] = new ArrayList<>();

        // Base case
        dp[0].add(new ArrayList<>());

        for (int i = 0; i < n; i++) { // for each "coin" nominal
            int coin = candidates[i];
            for (int r = coin; r <= target; r++) {
                for (List<Integer> lst : dp[r - coin]) {
                    List<Integer> tmp = new ArrayList<>(lst);
                    tmp.add(coin);
                    dp[r].add(tmp);
                }
            }
        }
        return dp[target];
    }

}
