package leetcode.dec;

import java.util.Arrays;

public class LC910SmallestRange2 {

    public int smallestRangeII(int[] A, int K) {

        Arrays.sort(A);
        int len = A.length - 1;
        int start = A[0];
        int end = A[len];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int res = end - start;
        start = start + K;
        end = end - K;

        for (int i = 0; i < len; i++) {
            min = Math.min(start, A[i + 1] - K);
            max = Math.max(end, A[i] + K);
            res = Math.min(res, max - min);
        }
        return res;
    }

    public static void main(String[] args) {
        LC910SmallestRange2 obj = new LC910SmallestRange2();
        int[] A = { 1, 3, 6 };
        int K = 3;
        System.out.println(obj.smallestRangeII(A, K));
    }

}
