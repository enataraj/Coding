package leetcode.june;

public class StoneGameVII {

    public int stoneGameVII(int[] stones) {
        int totalSum = 0;
        int N = stones.length;
        for (int stone : stones) {
            totalSum += stone;
        }

        Integer[][] memo = new Integer[N][N];
        return dfsHelper(stones, 0, N - 1, totalSum, memo);

    }

    private int dfsHelper(int[] stones, int start, int end, int sum, Integer[][] memo) {
        if (start == end)
            return 0;
        if (memo[start][end] != null)
            return memo[start][end];

        int removeFirst = (sum - stones[start]) - dfsHelper(stones, start + 1, end, sum - stones[start], memo);
        int removeLast = (sum - stones[end]) - dfsHelper(stones, start, end - 1, sum - stones[end], memo);

        return memo[start][end] = Math.max(removeFirst, removeLast);
    }

    public int stoneGameVIISol(int[] stones) {
        int n = stones.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1, sum = stones[i]; j < n; j++) {
                sum += stones[j];
                dp[j] = Math.max(sum - stones[i] - dp[j], sum - stones[j] - dp[j - 1]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        StoneGameVII obj = new StoneGameVII();
        int[] stones = { 5, 3, 1, 4, 2 };
        System.out.println(obj.stoneGameVII(stones));
    }

}
