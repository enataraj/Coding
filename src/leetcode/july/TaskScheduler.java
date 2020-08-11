package leetcode.july;

import java.util.Arrays;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        int[] freqMap = new int[26];
        for (char task : tasks) {
            freqMap[task - 'A']++;
        }

        Arrays.sort(freqMap);

        int max_Value = freqMap[25] - 1;
        int ideal_Slots = max_Value * n;
        System.out.println(ideal_Slots);

        for (int i = 24; i >= 0; i--) {
            ideal_Slots = ideal_Slots - Math.min(max_Value, freqMap[i]);
        }

        if (ideal_Slots < 0) {
            return tasks.length;
        }
        return ideal_Slots + tasks.length;
    }

    public static void main(String[] args) {
        TaskScheduler obj = new TaskScheduler();
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;

        System.out.println(obj.leastInterval(tasks, n));
    }

}
