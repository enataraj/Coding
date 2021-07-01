package leetcode.june;

public class LC746MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int[] memo = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            memo[i] = Math.min(cost[i - 1] + memo[i - 1], cost[i - 2] + memo[i - 2]);
        }
        return memo[cost.length];

    }

    public int minCostClimbingStairsSol(int[] cost) {
        int m[] = new int[cost.length];
        m[0] = cost[0];
        m[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            m[i] = cost[i] + Math.min(m[i - 1], m[i - 2]);
        }
        return Math.min(m[cost.length - 1], m[cost.length - 2]);
    }

    public int minCostClimbingStairsAlt(int[] cost) {
        int prevOne = cost[0];
        int prevTwo = cost[1];
        for (int index = 2; index < cost.length; index++) {
            int current = Math.min(prevOne, prevTwo) + cost[index];
            prevOne = prevTwo;
            prevTwo = current;
        }
        return Math.min(prevOne, prevTwo);
    }

    public static void main(String[] args) {
        LC746MinCostClimbingStairs obj = new LC746MinCostClimbingStairs();
        int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(obj.minCostClimbingStairs(cost));
    }

}
