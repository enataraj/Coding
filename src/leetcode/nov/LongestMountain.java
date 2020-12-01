package leetcode.nov;

import java.util.Arrays;

public class LongestMountain {

    public int longestMountain(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int res = 0;

        System.out.println(" Array : "+Arrays.toString(A));
        int[] leftIncrArray = new int[A.length];
        int[] rightIncrArray = new int[A.length];

        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                count++;
                leftIncrArray[i-1] = count;
            } else {
                count = 1;
            }
        }
        count = 0;
        for (int i = A.length - 1; i > 0; i--) {
            if (A[i - 1] > A[i]) {
                count++;
                rightIncrArray[i] = count;
            } else {
                count = 0;
            }
        }
        
        System.out.println("Left Increment Array : "+Arrays.toString(leftIncrArray));
        System.out.println("Right Increment Array : "+Arrays.toString(rightIncrArray));

        return res;

    }

    public int longestMountain_Incomplete(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int res = 0;
        int increseCount = 0;
        int decreseCount = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                if (decreseCount != 0) {
                    res = Math.max(res, increseCount + decreseCount);

                } else {
                    increseCount++;
                    decreseCount = 0;
                }
            } else if (A[i - 1] > A[i]) {
                if (increseCount != 0) {
                    decreseCount++;
                } else {
                    increseCount = 0;
                }
            }

        }

        return res;

    }

    public int longestMountainParin(int[] A) { // [2,3,3,2,0,2]
        int n = A.length, // 6
                increasing = 0, // 2
                decreasing = 0, // 0
                longest = 0; // 0

        for (int i = 1; i < n; i++) { // i = 2
            if (A[i - 1] == A[i]) {
                // reset the mountain
                increasing = 0;
                decreasing = 0;

            } else if (A[i - 1] < A[i]) {
                if (decreasing > 0) {
                    // reset the mountain
                    decreasing = 0;
                    increasing = 0;
                }

                if (increasing == 0) {
                    increasing = 2;

                } else {
                    ++increasing;

                }

            } else if (A[i - 1] > A[i]) {
                ++decreasing;
                if (increasing > 0) {
                    // if increasing subarray if found prior, then only mountain is considered
                    longest = Math.max(longest, increasing + decreasing);
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        LongestMountain obj = new LongestMountain();
        int[] A = { 2, 1, 4, 7, 3, 2, 5 };
        System.out.println(obj.longestMountain(A));

    }

}
