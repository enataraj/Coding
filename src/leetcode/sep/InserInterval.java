package leetcode.sep;

import java.util.ArrayList;
import java.util.List;

public class InserInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null && newInterval == null) {
            return null;
        }

        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }

        if (intervals == null || intervals.length == 0) {
            int[][] res = new int[1][2];
            res[0] = newInterval;
            return res;
        }
        List<int[]> result = new ArrayList<>();

        int newIntstart = newInterval[0];
        int newIntEnd = newInterval[1];

        int intStart = 0;
        int intEnd = 0;
        int[] tmpArray;

        for (int i = 0; i < intervals.length; i++) {
            intStart = intervals[i][0];
            intEnd = intervals[i][1];
            if (newIntstart > intEnd) {
                tmpArray = new int[2];
                tmpArray[0] = intStart;
                tmpArray[1] = intEnd;
                result.add(tmpArray);

            } else if (newIntEnd < intStart) {
                tmpArray = new int[2];
                tmpArray[0] = newIntstart;
                tmpArray[1] = newIntEnd;
                result.add(tmpArray);

                newIntstart = intStart;
                newIntEnd = intEnd;

            } else {
                newIntstart = Math.min(newIntstart, intStart);
                newIntEnd = Math.max(newIntEnd, intEnd);
            }

        }

        tmpArray = new int[2];
        tmpArray[0] = newIntstart;
        tmpArray[1] = newIntEnd;
        result.add(tmpArray);
        return result.toArray(new int[0][0]);
    }

    public int[][] insertOpt(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0 && newInterval == null)
            return new int[][] {};
        int i = 0;
        List<int[]> output = new ArrayList<int[]>();

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            output.add(intervals[i]);
            i++;
        }

        int start = (i < intervals.length) ? Math.min(newInterval[0], intervals[i][0]) : newInterval[0];
        int end = newInterval[1];

        while (i < intervals.length && intervals[i][0] <= end) {
            end = Math.max(end, intervals[i][1]);
            i++;
        }

        int[] interval = new int[2];
        interval[0] = start;
        interval[1] = end;
        output.add(interval);

        while (i < intervals.length) {
            output.add(intervals[i]);
            i++;
        }

        return output.toArray(new int[output.size()][2]);
    }

    private void printArray(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println("(" + (result[i][0] + "," + result[i][1] + ")"));
        }
    }

    public static void main(String[] args) {
        InserInterval obj = new InserInterval();

        int[][] intervals = { { 2, 4 }, { 6, 9 } };
        int[] newInterval = { 7, 16 };

        int[][] result = obj.insert(intervals, newInterval);
        obj.printArray(result);
    }
}
