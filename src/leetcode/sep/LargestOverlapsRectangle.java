package leetcode.sep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestOverlapsRectangle {

    public int largestOverlapBrutForce(int[][] A, int[][] B) {

        if (A == null || B == null) {
            return 0;
        }

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                count1 = Math.max(count1, findLargestOverlaps(A, B, i, j));
            }
        }

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                count2 = Math.max(count2, findLargestOverlaps(B, A, i, j));
            }
        }
        return Math.max(count1, count2);

    }

    private int findLargestOverlaps(int[][] A, int[][] B, int r, int c) {
        int tmpCount = 0;

        for (int i = r; i < B.length; i++) {
            for (int j = c; j < B[0].length; j++) {
                // if (A[r][c] == 1) {
                // if (B[i - r][j - c] == 1) {
                if ((A[i - r][j - c] == B[i][j]) && (B[i][j] == 1)) {
                    tmpCount++;
                }
                // }
            }
        }

        return tmpCount;
    }

    public int largestOverlapOpt(int[][] a, int[][] b) {
        return Math.max(find(a, b, 0, 0, new boolean[a.length][a[0].length]),
                find(b, a, 0, 0, new boolean[a.length][a[0].length]));
    }

    private int find(int[][] a, int[][] b, int posi, int posj, boolean[][] mem) {
        if (posi < 0 || posi >= a.length || posj < 0 || posj >= a[0].length) {
            return 0;
        }
        if (mem[posi][posj]) {
            return 0;
        }
        mem[posi][posj] = true;
        int max = count(a, b, posi, posj);
        max = Math.max(max, find(a, b, posi + 1, posj, mem));
        max = Math.max(max, find(a, b, posi, posj + 1, mem));
        return max;
    }

    private int count(int[][] a, int[][] b, int posi, int posj) {
        int cnt = 0;
        for (int i = posi; i < a.length; i++) {
            for (int j = posj; j < a[i].length; j++) {
                // if(a[i][j] + b[i - posi][j - posj] == 2) {
                cnt += (a[i][j] + b[i - posi][j - posj]) >> 1;
                // }
            }
        }
        return cnt;
    }

    /*
     * Find All ones in A Find All ones in B Iterate through each result with inner
     * loop and see how to move second set value to first set value to make the
     * result
     * 
     * 
     */

    public int largestOverlap(int[][] A, int[][] B) {

        if (A == null || B == null) {
            return 0;
        }

        Set<String> onesSetA = new HashSet<>();
        Set<String> onesSetB = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    onesSetA.add(i + "#" + j);

                }
                if (B[i][j] == 1) {
                    onesSetB.add(i + "#" + j);

                }

            }
        }

        Map<String, Integer> resultMap = new HashMap<>();

        for (String onesA : onesSetA) {
            for (String onesB : onesSetB) {
                String[] aRowColumn = onesA.split("#");
                String[] bRowColumn = onesB.split("#");
                String overlapKey = (Integer.parseInt(aRowColumn[0]) - Integer.parseInt(bRowColumn[0])) + "#"
                        + (Integer.parseInt(aRowColumn[1]) - Integer.parseInt(bRowColumn[1]));
                if (resultMap.containsKey(overlapKey)) {
                    resultMap.put(overlapKey, resultMap.get(overlapKey) + 1);
                } else {
                    resultMap.put(overlapKey, 1);
                }
            }

        }

        int result = 0;
        for (int val : resultMap.values()) {
            result = Math.max(result, val);
        }

        return result;

    }

    public static void main(String[] args) {

        LargestOverlapsRectangle obj = new LargestOverlapsRectangle();

        int[][] A = { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
        int[][] B = { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 1 } };

        // int[][] A = { { 1, 0 }, { 0, 0 } };

        // int[][] B = { { 0, 1 }, { 1, 0 } };

        System.out.println(obj.largestOverlap(A, B));

    }

}
