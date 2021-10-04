package leetcode.weekly.week255;

import java.util.HashSet;
import java.util.Set;

public class MinimizeDifferenceTarget {

    public int minimizeTheDifferenceSol(int[][] mat, int target) {
        Set<Integer> curr_Set = new HashSet<>();
        Set<Integer> new_Set = new HashSet<>();
        curr_Set.add(0);
        for (int i = 0; i < mat.length; i++) {
            new_Set = new HashSet<>();
            for (Integer v : curr_Set) {
                for (int j = 0; j < mat[i].length; j++) {
                    new_Set.add(v + mat[i][j]);
                }
            }

            // Remove all elements greater than the smallest element greater than target
            int min_over = Integer.MAX_VALUE;
            for (Integer v : new_Set) {
                if (v >= target)
                    min_over = Math.min(min_over, v);
            }
            curr_Set = new HashSet();
            for (Integer v : new_Set) {
                if (v <= min_over)
                    curr_Set.add(v);
            }
        }

        // Finding Result
        int min_diff = Integer.MAX_VALUE;
        for (Integer v : curr_Set) {
            int curr_diff = Math.abs(v - target);
            min_diff = Math.min(curr_diff, min_diff);
        }
        return min_diff;
    }

    // Recursion Solution

    int result = Integer.MAX_VALUE;

    public int minimizeTheDifference(int[][] mat, int target) {
        boolean[][] memo = new boolean[mat.length + 1][4901];
        dfsHelper(mat, 0, 0, target, memo);
        return result;
    }

    private void dfsHelper(int[][] mat, int row, int sum, int target, boolean[][] memo) {
        if (memo[row][sum]) {
            return;
        }
        if (row == mat.length) {
            result = Math.min(result, Math.abs(target - sum));
            memo[row][sum] = true;
            return;
        }
        for (int j = 0; j < mat[row].length; j++) {
            dfsHelper(mat, row + 1, mat[row][j] + sum, target, memo);
        }
        memo[row][sum] = true;
    }

    public static void main(String[] args) {
        //int[][] mat = {{1,2,3},{4,5,6},{7,8,9}}; // 13 // 0
        // int[][] mat = { { 1 }, { 2 }, { 3 } };  // 100  //94
        // int[][] mat = {{1,2,9,8,7}};  // 6 //1
        int[][] mat = { { 3, 5 }, { 5, 10 } };
        MinimizeDifferenceTarget obj = new MinimizeDifferenceTarget();
        System.out.println(obj.minimizeTheDifference(mat, 47));

    }

}
