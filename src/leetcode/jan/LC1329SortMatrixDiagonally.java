package leetcode.jan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1329SortMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        // Row = 0
        for (int c = 0; c < col; c++) {
            sort(mat, 0, c);
        }

        // Col = 0

        for (int r = 0; r < row; r++) {
            sort(mat, r, 0);
        }

        return mat;
    }

    void sort(int[][] mat, int row, int col) {
        int r = row;
        int c = col;
        List<Integer> list = new ArrayList<>();
        while (r < mat.length && c < mat[0].length) {
            list.add(mat[r][c]);
            r++;
            c++;
        }
        Collections.sort(list);

        r = row;
        c = col;
        int idx = 0;

        while (r < mat.length && c < mat[0].length) {
            mat[r][c] = list.get(idx);
            r++;
            c++;
            idx++;
        }

    }

    public int[][] diagonalSortSol(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m - 1; i++) {
            sort(mat, i, 0, m, n);
        }
        for (int j = 1; j < n - 1; j++) {
            sort(mat, 0, j, m, n);
        }
        return mat;
    }

    public void sort(int[][] mat, int i, int j, int m, int n) {
        int k = i;
        int l = j;
        int arr[] = new int[101];
        while (k < m && l < n) {
            arr[mat[k][l]]++;
            k++;
            l++;
        }

        k = i;
        l = j;
        for (int p = 0; p < 101; p++) {
            if (arr[p] > 0) {
                int val = arr[p];
                while (val > 0) {
                    mat[k][l] = p;
                    k++;
                    l++;
                    val--;
                }
            }
        }
    }

    public int[][] diagonalSortALt(int[][] mat) {

        if (mat == null || mat.length == 0) {
            return new int[0][0];
        }
        int r = mat.length;
        int c = mat[0].length;

        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int key = j - i;
                if (diagonalMap.containsKey(key)) {
                    List<Integer> list = diagonalMap.get(key);
                    list.add(mat[i][j]);
                    diagonalMap.put(key, list);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(mat[i][j]);
                    diagonalMap.put(key, list);
                }
            }
        }
        int i, j, diagIdx;
        for (int key : diagonalMap.keySet()) {
            List<Integer> list = diagonalMap.get(key);
            Collections.sort(list);
            if (key < 0) {
                j = 0;
                i = j - key;

            } else {
                j = key;
                i = 0;
            }

            diagIdx = 0;

            while (i < r && j < c) {
                mat[i][j] = list.get(diagIdx++);
                ++i;
                ++j;
            }

        }

        System.out.println(diagonalMap);

        return mat;

    }

    public static void main(String[] args) {
        LC1329SortMatrixDiagonally obj = new LC1329SortMatrixDiagonally();
        int[][] mat = new int[4][7];
        int[][] mat1 = new int[7][4];
        int[][] mat2 = new int[6][6];

        // obj.diagonalSort(mat);
        System.out.println();
        obj.diagonalSort(mat1);
        System.out.println();
        // obj.diagonalSort(mat2);
    }

}
