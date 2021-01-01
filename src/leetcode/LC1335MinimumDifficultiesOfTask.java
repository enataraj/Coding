package leetcode;

public class LC1335MinimumDifficultiesOfTask {
    int maxConstant = 100000;
    int[][] cache;

    // Driver Program to call recursion
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) {
            return -1;
        }

        // Memorization
        cache = new int[jobDifficulty.length + 1][d + 1];
        return dfsHelpher(jobDifficulty, 0, d);

    }

    private int dfsHelpher(int[] jobDifficulty, int idx, int d) {
        if (idx > jobDifficulty.length) {
            return maxConstant;
        }
        if (d < 0) {
            return maxConstant;
        }

        if (idx == jobDifficulty.length) {
            if (d == 0) {
                return 0;
            }
            return maxConstant;
        }

        if (cache[idx][d] != 0) {
            return cache[idx][d];
        }

        int maxSoFar = Integer.MIN_VALUE;
        int minSoFar = maxConstant;

        // Trying out all combination
        /*
         * Slicing the array by d combinations each combination find the max find the
         * min of the max
         */
        for (int i = idx; i < jobDifficulty.length; i++) {
            maxSoFar = Math.max(maxSoFar, jobDifficulty[i]);
            minSoFar = Math.min(minSoFar, maxSoFar + dfsHelpher(jobDifficulty, i + 1, d - 1));

        }
        cache[idx][d] = minSoFar;
        return minSoFar;
    }

    public static void main(String[] args) {
        LC1335MinimumDifficultiesOfTask obj = new LC1335MinimumDifficultiesOfTask();
        int[] jobDifficulty = { 11, 111, 22, 222, 33, 333, 44, 444 };
        int d = 6;
        System.out.println(obj.minDifficulty(jobDifficulty, d));
    }

}
