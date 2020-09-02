package leetcode.aug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PanCakeSorting {

    public List<Integer> pancakeSort(int[] A) {

        if (A == null) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> result = new ArrayList<>();

        if (A.length == 1) {
            result.add(1);
            return result;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            int maxIdx = findMaxValueIndex(A, i);

            if (maxIdx != i) {

                if (maxIdx > 0) {
                    reverseArray(A, maxIdx);
                    result.add(maxIdx + 1);
                }
                reverseArray(A, i);
                result.add(i + 1);

            }

        }

        return result;

    }

    private int findMaxValueIndex(int[] A, int length) {

        int idx = 0;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i <= length; i++) {
            if (A[i] > maxValue) {
                maxValue = A[i];
                idx = i;
            }

        }

        return idx;

    }

    private void reverseArray(int[] A, int length) {
        int l = 0;
        int r = length;

        while (l <= r) {
            int tmp = A[l];
            A[l] = A[r];
            A[r] = tmp;
            l++;
            r--;

        }

    }

    public static void main(String[] args) {
        PanCakeSorting obj = new PanCakeSorting();
        int[] A = { 3, 2, 4, 1 };
        System.out.println(obj.pancakeSort(A));

       
    }

}
