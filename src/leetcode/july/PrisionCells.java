package leetcode.july;

import java.util.Arrays;

public class PrisionCells {

    public int[] prisonAfterNDays(int[] cells, int N) {

        if (N == 0) {
            return cells;
        }
        
        N = N % 14;
        if (N == 0) N = 14;

        int result[] = new int[cells.length];
        // result = cells;

        for (int i = 0; i < N; i++) {

            result[0] = 0;
            result[7] = 0;
            for (int j = 1; j < 7; j++) {
                if (cells[j - 1] == cells[j + 1]) {
                    result[j] = 1;
                } else {
                    result[j] = 0;
                }
            }
           // System.out.println("Before :"+Arrays.toString(cells));
            cells = Arrays.copyOf(result,8);
           // System.out.println("After : "+Arrays.toString(cells));
           // System.out.println("Result :"+Arrays.toString(result));
           
        }

        return result;

    }

    public static void main(String[] args) {
        int[] cells = { 0, 1, 0, 1, 1, 0, 0, 1 };
        int N = 7;

        PrisionCells obj = new PrisionCells();

        cells = obj.prisonAfterNDays(cells, N);
        System.out.println(Arrays.toString(cells));

    }

}
