package leetcode.aug;

import java.util.Arrays;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }

        int i = 0, j = A.length - 1;
        boolean odd = false, even = false;

        while (i <= j) {
            if (A[i] % 2 == 0) {
                i++;

            } else {
                odd = true;
            }
            if (A[j] % 2 == 1) {
                j--;
            } else {
                even = true;
            }
            if (odd && even) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                odd = false;
                even = false;
                i++;
                j--;
            }

        }

        return A;

    }

    public int[] sortArrayByParityOpt(int[] A) {
        int indx = 0, val;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) != 1) {
                val = A[indx];
                A[indx] = A[i];
                A[i] = val;
                indx++;
            }
        }
        return A;
    }

    public static void main(String[] args) {

        SortArrayByParity obj = new SortArrayByParity();
        int[] A = { 1, 2, 4, 6 };
        System.out.println(Arrays.toString(A));
        A = obj.sortArrayByParity(A);
        System.out.println(Arrays.toString(A));

    }

}
