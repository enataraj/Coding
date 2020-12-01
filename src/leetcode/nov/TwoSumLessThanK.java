package leetcode.nov;

import java.util.Arrays;

public class TwoSumLessThanK {

    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length < 2) {
            return -1;
        }

        Arrays.sort(A);
        int low = 0, high = A.length - 1;

        int sum = -1;
        while (low < high) {
            if (A[low] + A[high] < K) {
                sum = Math.max(A[low] + A[high], sum);
                low++;
            } else {
                high--;
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        TwoSumLessThanK obj = new TwoSumLessThanK();
        int[] A = { 34, 23, 1, 24, 75, 33, 54, 8 };
        int K = 60;
        System.out.println(obj.twoSumLessThanK(A, K));

    }

}
