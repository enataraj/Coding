package leetcode.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> resultIntervalList = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        int length = intervals.length - 1;

        for (int i = 1; i <= length; i++) {

            if (end > intervals[i][0] && end > intervals[i][1]) {
                continue;
            } else if (end >= intervals[i][0] && end < intervals[i][1]) {
                end = intervals[i][1];

            } else if (end < intervals[i][0]) {
                int[] tmpRes = new int[2];
                tmpRes[0] = start;
                tmpRes[1] = end;
                resultIntervalList.add(tmpRes);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        int[] tmpRes = new int[2];
        tmpRes[0] = start;
        tmpRes[1] = Math.max(end, intervals[length][1]);
        resultIntervalList.add(tmpRes);

        int[][] resultIntervals = new int[resultIntervalList.size()][2];

        for (int i = 0; i < resultIntervalList.size(); i++) {

            resultIntervals[i] = resultIntervalList.get(i);
        }
        return resultIntervals;

    }

    public int[][] merge_Sol(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> ans = new ArrayList();
        ans.add(intervals[0]);

        for (int i = 1; i < intervals.length; ++i) {
            int[] interval = ans.get(ans.size() - 1);
            //System.out.println("prev: " + Arrays.toString(interval) + " curr: " + Arrays.toString(intervals[i]));

            if (intervals[i][0] <= interval[1]) {
                interval[1] = Math.max(interval[1], intervals[i][1]);
            } else {
                ans.add(intervals[i]);
            }
        }

        int[][] ansArr = new int[ans.size()][2];

        for (int i = 0; i < ans.size(); ++i) {
            ansArr[i] = ans.get(i);
        }

        return ansArr;
    }

    public int[][] mergeSol(int[][] intervals) {

        int count = intervals.length;

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] <= intervals[i][1] && intervals[i][0] <= intervals[j][1]) {
                    // have overlap
                    intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i][0] = -1;
                    count--;
                    break;
                }

            }
        }

        int[][] ans = new int[count][];
        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= 0) {
                ans[idx] = intervals[i];
                idx++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        //  int[][] intervals = { { 1, 17}, { 2, 9 }, { 8, 10 }, { 15, 18 } };
        //  int[][] intervals = { { 1, 4}, { 0, 4 } };
        int[][] intervals = { { 4, 5 }, { 1, 4 }, { 0, 1 } };
        obj.merge(intervals);
    }

}
