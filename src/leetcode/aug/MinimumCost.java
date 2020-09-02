package leetcode.aug;

public class MinimumCost {
    
    public int mincostTickets(int[] days, int[] costs) {
        //MG
        //dp[i]: min cost until day i
        int[] dp = new int[days[days.length - 1] + 1];
        dp[0] = 0;
        int index = 0;
        for (int i = 1; i < dp.length; i++) {
            if (days[index] == i) {
                //buy month
                int month = dp[Math.max(0, i - 30)] + costs[2];
                //buy week
                int week = dp[Math.max(0, i - 7)] + costs[1];
                //buy day
                int day = dp[i - 1] + costs[0];
                
                dp[i] = Math.min(day, Math.min(week, month));
                index++;
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length - 1];
    }

}
