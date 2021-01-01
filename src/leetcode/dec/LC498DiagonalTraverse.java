package leetcode.dec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC498DiagonalTraverse {

    /*
     * This is O(M*N) Time and O(M*N) Space
     * 
     * Intituion In diagonal Row and Column addition is always gives same value. So while go through martix populate a list which is having same row and value.
     * 
     * Then for Even Index in the diagonal list , Just reverse it.
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int r = matrix.length;
        int c = matrix[0].length;

        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int key = i + j;
                if (diagonalMap.containsKey(key)) {
                    List<Integer> list = diagonalMap.get(key);
                    list.add(matrix[i][j]);
                    diagonalMap.put(key, list);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(matrix[i][j]);
                    diagonalMap.put(key, list);
                }
            }
        }

        // System.out.println(diagonalMap);
        int res[] = new int[r * c];
        int idx = 0;

        for (int i = 0; i < r + c - 1; i++) {
            List<Integer> list = diagonalMap.get(i);
            if (i % 2 == 0) {
                Collections.reverse(list);
            }
            for (int j = 0; j < list.size(); j++) {
                res[idx] = list.get(j);
                idx++;
            }

        }

        // System.out.println(Arrays.toString(res));
        return res;

    }

    public int[] findDiagonalOrder_Alt3(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0, c = 0;
        int result[] = new int[m * n];
        // directions - diagonally upwards, diagonally downwards
        int[][] dirs = { { -1, 1 }, { 1, -1 } };
        int dir = 0;
        int idx = 0;
        while (r < m && c < n) {
            result[idx] = matrix[r][c];
            idx++;
            r += dirs[dir][0];
            c += dirs[dir][1];
            if (r < 0 || c < 0 || r >= m || c >= n) {
                // hit the border
                // revert back values of r and c
                r -= dirs[dir][0];
                c -= dirs[dir][1];
                // also increment r or c based on direction
                if (dir == 0) {
                    if (c + 1 < n)
                        c += 1;
                    else if (r + 1 < m)
                        r += 1;
                    else
                        break;
                } else if (dir == 1) {
                    if (r + 1 < m)
                        r += 1;
                    else if (c + 1 < n)
                        c += 1;
                    else
                        break;
                }
                // change directions
                dir = (dir + 1) % 2;
            }
        }
        // System.out.println(Arrays.toString(result));
        return result;

    }

    public int[] findDiagonalOrder_Alt(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int i = 0, j = 0, dir = 1, idx = 0;
        while (dir != 0) {
            if (dir == 1) {
                while (i >= 0 && i < m && j >= 0 && j < n) {
                    res[idx] = matrix[i][j];
                    i--;
                    j++;
                    idx++;
                }
                if (i + 1 < m && j < n) {
                    i++;
                    dir = -1;
                } else if (i + 2 < m && j - 1 < n) {
                    i += 2;
                    j--;
                    dir = -1;
                } else {
                    dir = 0;
                }
            } else { // dir == -1
                while (i >= 0 && i < m && j >= 0 && j < n) {
                    res[idx] = matrix[i][j];
                    i++;
                    j--;
                    idx++;
                }
                if (j + 1 < n && i < m) {
                    j++;
                    dir = 1;
                } else if (j + 2 < n && i - 1 < m) {
                    j += 2;
                    i--;
                    dir = 1;
                } else {
                    dir = 0;
                }
            }
        }
        // System.out.println(Arrays.toString(res));
        return res;
    }

    public int[] findDiagonalOrder_Alt2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int mCols = matrix[0].length;
        int nRows = matrix.length;
        int[] result = new int[nRows * mCols];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<>();

        for (int i = 0; i < (nRows + mCols - 1); ++i) {
            // Clear intermediate
            intermediate.clear();

            // Find out the head of the diagnol
            int r = (i < mCols) ? 0 : (i - mCols + 1);
            int c = (i < mCols) ? i : (mCols - 1);

            // Go down the diagnol until out of scope
            while (r < nRows && c > -1) {
                intermediate.add(matrix[r++][c--]);
            }

            // Swap direction if even.
            if (i % 2 == 0) {
                Collections.reverse(intermediate);
            }

            // place intermediate into result
            for (int j = 0; j < intermediate.size(); j++) {
                result[k++] = intermediate.get(j);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LC498DiagonalTraverse obj = new LC498DiagonalTraverse();
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

        obj.findDiagonalOrder(matrix);
    }

}
