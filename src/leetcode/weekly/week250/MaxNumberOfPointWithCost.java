package leetcode.weekly.week250;

public class MaxNumberOfPointWithCost {

    public long maxPoints(int[][] points) {
        long ans = 0;
        int m = points.length, n = points[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] += points[i][j];
            }
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;

    }

    public long maxPointsNW(int[][] points) {
        long score = 0;

        int max = -1;
        int preCol = -1;
        for (int c = 0; c < points[0].length; c++) {
            if (max < points[0][c]) {
                max = points[0][c];
                preCol = c;
            }

        }
        score += max;
        for (int r = 1; r < points.length; r++) {

            findMaxScoreAndIdx(points, preCol, r);
            if (r + 1 < points.length) {
                findMaxScoreAndIdx(points, preCol, r + 1);
            }

            // score += curScore;
            // preCol = curIdx;

        }

        return score;
    }

    private int[] findMaxScoreAndIdx(int[][] points, int preCol, int row) {

        int tmpScore = -1;
        int curScore = -1;
        int curIdx = -1;

        int tmpIdx = preCol;

        while (tmpIdx < points[0].length) {
            tmpScore = points[row][tmpIdx] - Math.abs(tmpIdx - preCol);
            if (curScore < tmpScore) {
                curScore = tmpScore;
                curIdx = tmpIdx;
                if (row + 1 < points.length) {
                    int[] nextMaxScore = findNextMaxScoreAndIdx(points, curIdx, row + 1);
                }

            }
            tmpIdx++;

        }

        tmpIdx = preCol;
        while (tmpIdx >= 0) {
            tmpScore = points[row][tmpIdx] - Math.abs(tmpIdx - preCol);
            if (curScore < tmpScore) {
                curScore = tmpScore;
                curIdx = tmpIdx;
                if (row + 1 < points.length) {
                    int[] nextMaxScore = findNextMaxScoreAndIdx(points, curIdx, row + 1);
                }

            }

            tmpIdx--;

        }

        return new int[] { curScore, curIdx };

    }

    private int[] findNextMaxScoreAndIdx(int[][] points, int preCol, int row) {

        int tmpScore = -1;
        int curScore = -1;
        int curIdx = -1;

        int tmpIdx = preCol;

        while (tmpIdx < points[0].length) {
            tmpScore = points[row][tmpIdx] - Math.abs(tmpIdx - preCol);
            if (curScore < tmpScore) {
                curScore = tmpScore;
                curIdx = tmpIdx;

            }
            tmpIdx++;

        }

        tmpIdx = preCol;
        while (tmpIdx >= 0) {
            tmpScore = points[row][tmpIdx] - Math.abs(tmpIdx - preCol);
            if (curScore < tmpScore) {
                curScore = tmpScore;
                curIdx = tmpIdx;

            }

            tmpIdx--;

        }

        return new int[] { curScore, curIdx };

    }

    /*
     * [[0,3,0,4,2],
     * [5,4,2,4,1],
     * [5,0,0,5,1],
     * [2,0,1,0,3]]
     * 
     * 
     * [[1,5],
     * [3,2],
     * [4,2]]
     * 
     * 
     * 
     */

}
