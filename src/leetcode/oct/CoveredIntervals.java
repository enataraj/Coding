package leetcode.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CoveredIntervals {

    public int removeCoveredIntervals_mine(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        if (intervals.length == 1) {
            return 1;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return (Integer.valueOf(o2[1]).compareTo(o1[1]));
                }
                return (Integer.valueOf(o1[0]).compareTo(o2[0]));
            }
        });

        List<Integer[]> intervalList = new ArrayList<>();

        Integer[] tmp1 = { intervals[0][0], intervals[0][1] };
        intervalList.add(tmp1);

        for (int i = 1; i < intervals.length; i++) {
            int a = intervalList.get(intervalList.size() - 1)[0];
            int b = intervalList.get(intervalList.size() - 1)[1];
            int c = intervals[i][0];
            int d = intervals[i][1];

            if (b < d) {
                Integer[] tmp = { c, d };
                intervalList.add(tmp);

            }
        }

        return intervalList.size();

    }

    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        if (intervals.length == 1) {
            return 1;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return (Integer.valueOf(o2[1]).compareTo(o1[1]));
                }
                return (Integer.valueOf(o1[0]).compareTo(o2[0]));
            }
        });

        int maxEnd = intervals[0][1];
        int res = intervals.length;

        for (int i = 1; i < intervals.length; i++) {

            int currentEnd = intervals[i][1];

            if (maxEnd < currentEnd) {
                res -= 1;

            } else {
                maxEnd = currentEnd;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        CoveredIntervals obj = new CoveredIntervals();
        // int[][] intervals = { { 1, 4 }, { 3, 6 }, { 2, 8 } }; //2
        int[][] intervals = { { 1, 2 }, { 2, 3 } }; // 2
        // int[][] intervals ={{1,4},{2,3}}; //1

        // int[][] intervals ={{0,10},{5,12}}; //2

        // int[][] intervals = { { 3, 10 }, { 4, 10 }, { 5, 11 } }; //2
        // int[][] intervals = { { 1, 2 }, { 1, 4 }, { 3, 4 } }; // 1

        // int[][] intervals = { { 34335, 39239 }, { 15875, 91969 }, { 29673, 66453 }, {
        // 53548, 69161 }, { 40618, 93111 }, { 34335, 39240 } }; //2

        System.out.println(obj.removeCoveredIntervals(intervals));
    }

}
