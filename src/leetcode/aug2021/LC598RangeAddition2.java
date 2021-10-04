package leetcode.aug2021;

public class LC598RangeAddition2 {

    public int maxCount(int m, int n, int[][] ops) {

        if (ops == null || ops.length == 0) {
            return m * n;
        }

        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }
        return minRow*minCol;

    }

}
