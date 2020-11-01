package leetcode.sep;

import java.util.Arrays;

public class TemooAttacking {

    public int findPoisonedDurationParin(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if (n == 0 || duration == 0) {
            return 0;
        }

        int[] prev = new int[] { timeSeries[0], timeSeries[0] + duration };
        int count = 0;

        for (int i = 1; i < n; i++) {
            int[] next = new int[] { timeSeries[i], timeSeries[i] + duration };
            int[] intersection = new int[] { Math.max(prev[0], next[0]), Math.min(prev[1], next[1]) };

            if (intersection[0] < intersection[1]) {
                // perform union
                prev = new int[] { Math.min(prev[0], next[0]), Math.max(prev[1], next[1]) };

            } else {
                count += (prev[1] - prev[0]);
                prev = next;
            }
        }

        count += prev[1] - prev[0];
        return count;
    }

    public int findPoisonedDurationIrina(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if (n < 1)
            return 0;
        int total = 0;
        int maxReach = timeSeries[0];
        for (int st : timeSeries) {
            if (st > maxReach)
                maxReach = st;
            if (st + duration > maxReach) {
                total += st + duration - maxReach;
                maxReach = st + duration;
            }
        }
        return total;
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        if (timeSeries.length == 1) {
            return duration;
        }

        int totalDuration = 0;
        int poitionTill = timeSeries[0];
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] > poitionTill) {
                poitionTill = timeSeries[i];
            }
            if (timeSeries[i] + duration > poitionTill) {
                totalDuration += timeSeries[i] + duration - poitionTill;
                poitionTill = timeSeries[i] + duration;

            }

        }

        return totalDuration;

    }

    public int findPoisonedDurationOpt(int[] timeSeries, int duration) {
        int stop = -1, poisoned = 0;

        for (int time : timeSeries) {
            if (time > stop) {
                stop = duration + time - 1;
                poisoned += duration;
            } else {
                int new_stop = duration + time - 1;
                poisoned += new_stop - stop;
                stop = new_stop;
            }
        }

        return poisoned;
    }

    // TLE

    public int findPoisonedDuration1(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        if (timeSeries.length == 1) {
            return duration;
        }

        boolean[] arrayValues = new boolean[timeSeries[timeSeries.length - 1] + duration];

        for (int time : timeSeries) {
            Arrays.fill(arrayValues, time, time + duration, true);
        }

        int totalTime = 0;
        for (int i = 0; i < arrayValues.length; i++) {
            if (arrayValues[i]) {
                totalTime++;
            }
        }

        return totalTime;
    }

    public int findPoisonedDuration2(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        if (timeSeries.length == 1) {
            return duration;
        }

        int timePos = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            timePos += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);

        }

        return timePos;

    }

    public static void main(String[] args) {

        TemooAttacking obj = new TemooAttacking();
        int[] timeSeries = { 1, 2, 3, 4, 5 };
        int duration = 5;

        // int[] timeSeries = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // int duration = 10;

        System.out.println(obj.findPoisonedDuration2(timeSeries, duration));

    }

}
