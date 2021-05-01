package leetcode.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC474OnesAndZeros {
    int max = 0;

    public int findMaxForm(String[] strs, int m, int n) {

        Map<Integer, Map<Integer, Integer>> counts = new HashMap<>();
        for (int k = 0; k < strs.length; k++) {
            String str = strs[k];
            int zeros = 0;
            int ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0')
                    zeros++;
                else
                    ones++;
            }
            if (!counts.containsKey(zeros)) {
                counts.put(zeros, new HashMap<>());
            }
            int count = counts.get(zeros).getOrDefault(ones, 0);
            count++;
            counts.get(zeros).put(ones, count);
        }
        List<int[]> tuples = new ArrayList<>();
        for (int zeros : counts.keySet()) {
            for (int ones : counts.get(zeros).keySet()) {
                int count = counts.get(zeros).get(ones);
                int[] tuple = new int[4];
                tuple[0] = zeros;
                tuple[1] = ones;
                tuple[2] = count;
                tuples.add(tuple);
            }
        }
        int cumulative = 0;
        for (int k = tuples.size() - 1; k >= 0; k--) {
            cumulative += tuples.get(k)[2];
            tuples.get(k)[3] = cumulative;
        }
        helper(tuples, 0, 0, 0, 0, m, n);
        return max;
    }

    private void helper(List<int[]> tuples, int index, int taken, int zeros, int ones, int m, int n) {
        if (index == tuples.size())
            return;
        int[] tuple = tuples.get(index);
        if (tuple[3] < max + 1 - taken)
            return;
        for (int k = tuple[2]; k >= 0; k--) {
            if (tuple[0] * k + zeros > m)
                continue;
            if (tuple[1] * k + ones > n)
                continue;
            int newTaken = taken + k;
            if (newTaken > max) {
                max = newTaken;
            }
            int newZeros = zeros + tuple[0] * k;
            int newOnes = ones + tuple[1] * k;
            helper(tuples, index + 1, newTaken, newZeros, newOnes, m, n);
        }
    }

    public int findMaxFormAlternate(String[] strs, int m, int n) {
        Map<Integer, int[]> indexToCount = new HashMap<Integer, int[]>();
        Map<String, Integer> memo = new HashMap<String, Integer>();
        int N = strs.length;
        for (int index = 0; index < N; index++) {
            int zerosCount = 0;
            int onesCount = 0;
            for (char ch : strs[index].toCharArray()) {
                if (ch == '0')
                    zerosCount += 1;
                else
                    onesCount += 1;
            }
            indexToCount.put(index, new int[] { zerosCount, onesCount });
        }
        return dfs(N, indexToCount, 0, m, n, memo);
    }

    private int dfs(int N, Map<Integer, int[]> indexToCount, int currentIndex, int m, int n,
            Map<String, Integer> memo) {
        if (currentIndex >= N)
            return 0;
        String key = currentIndex + "_" + m + "_" + n;
        if (memo.containsKey(key))
            return memo.get(key);
        int zerosCount = indexToCount.get(currentIndex)[0];
        int onesCount = indexToCount.get(currentIndex)[1];
        int count1 = 0;
        if (zerosCount <= m && onesCount <= n)
            count1 = 1 + dfs(N, indexToCount, currentIndex + 1, m - zerosCount, n - onesCount, memo);
        int count2 = dfs(N, indexToCount, currentIndex + 1, m, n, memo);
        memo.put(key, Math.max(count1, count2));
        return memo.get(key);
    }

    private int countZeros(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                count++;
        }
        return count;
    }

    public int findMaxFormSol2(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < len; i++) {
            int zeros = countZeros(strs[i]);
            int ones = strs[i].length() - zeros;
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    // if(j < zeros || k < ones)
                    //     continue;
                    // else
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LC474OnesAndZeros obj = new LC474OnesAndZeros();
    }

}
