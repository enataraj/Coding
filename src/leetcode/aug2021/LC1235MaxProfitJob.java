package leetcode.aug2021;

import java.util.Arrays;
import java.util.TreeMap;

public class LC1235MaxProfitJob {
    class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return startTime + " " + endTime + " " + profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Arrays.sort(jobs, (a, b) -> a.endTime - b.endTime);

        int totalProfit = 0;
        for (Job job : jobs) {
            Integer floorKey = treeMap.floorKey(job.startTime);
            if (floorKey != null) {
                int tmpProfit = job.profit + treeMap.get(floorKey);
                totalProfit = Math.max(tmpProfit, totalProfit);
            } else {
                totalProfit = Math.max(job.profit, totalProfit);
            }
            treeMap.put(job.endTime, totalProfit);
        }
        return totalProfit;
    }

    public int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(-1, 0);
        Arrays.sort(jobs, (a, b) -> a.endTime - b.endTime);

        int totalProfit = 0;
        for (Job job : jobs) {
            int tmpProfit = job.profit + treeMap.get(treeMap.floorKey(job.startTime));
            totalProfit = Math.max(tmpProfit, totalProfit);
            treeMap.put(job.endTime, totalProfit);
            System.out.println(treeMap);
        }
        return totalProfit;
    }

    public int jobScheduling4ms(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;

        // Sort the end time and change the start time and the profit accordingly
        // This is insertion sort
        for (int i = 1; i < len; i++) {
            int e = endTime[i], s = startTime[i], p = profit[i], j = i - 1;
            while (j >= 0 && endTime[j] > e) {
                endTime[j + 1] = endTime[j];
                startTime[j + 1] = startTime[j];
                profit[j + 1] = profit[j];
                j--;
            }
            endTime[j + 1] = e;
            startTime[j + 1] = s;
            profit[j + 1] = p;
        }

        int[] dp = new int[len];

        dp[0] = profit[0];

        for (int j = 1; j < len; j++) {
            int start = startTime[j];

            // In other words, earn is the profit associates with this start time
            int earn = profit[j];

            int prevEnd = endTime[j - 1];

            if (start < prevEnd) {
                int prev = j - 1;

                // move prev back until we find an end time is less than the current start time
                while (prev >= 0 && endTime[prev] > start)
                    prev--;

                // if there is no such end time
                if (prev < 0) {
                    // dp[j] = max(profit[j], dp[j-1])
                    dp[j] = Math.max(earn, dp[j - 1]);
                }
                // if there is such end time where the end time is less than the current start time
                else {
                    // dp[j] = max(dp[prev] + ear, dp[j-1])
                    // profit of that time + profit[j] or the previous profit stored at dp[j - 1]
                    dp[j] = Math.max(dp[prev] + earn, dp[j - 1]);
                }
            }

            // if start time > previous end time
            else {
                // dp[j] = dp[j - 1] + profit[j]
                dp[j] = dp[j - 1] + earn;
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] startTimes = { 1, 2, 3, 3 };
        int[] endTimes = { 3, 4, 5, 6 };
        int[] profit = { 50, 10, 40, 70 };
        LC1235MaxProfitJob obj = new LC1235MaxProfitJob();
        System.out.println(obj.jobScheduling(startTimes, endTimes, profit));

    }

}
