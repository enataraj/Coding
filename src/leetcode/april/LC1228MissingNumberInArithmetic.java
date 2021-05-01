package leetcode.april;

import java.util.Arrays;

public class LC1228MissingNumberInArithmetic {

    public int missingNumber(int[] arr) {
        int N = arr.length + 1;
        int actualSum = Arrays.stream(arr).sum();
        int firstTerm = Math.min(arr[0], arr[N - 2]);
        int lastTerm = Math.max(arr[0], arr[N - 2]);
        int requiredSum = (N * (firstTerm + lastTerm)) / 2;
        return requiredSum - actualSum;
    }

    public int missingNumberBinarySearchSol(int[] arr) {
        int N = arr.length;
        int firstTerm = arr[0];
        int lastTerm = arr[N - 1];
        int diff = (lastTerm - firstTerm) / N;
        int left = 0;
        int right = N - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == firstTerm + diff * mid)
                left = mid + 1;
            else
                right = mid;
        }
        return diff * left + firstTerm;
    }

    public int missingNumberAlt(int[] arr) {
        int d1 = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            int currD = arr[i] - arr[i - 1];
            if (currD != d1) {
                if (currD == 2 * d1) {
                    return arr[i - 1] + d1;
                }
                return arr[0] + currD;
            }
        }
        return arr[0];

    }

}
