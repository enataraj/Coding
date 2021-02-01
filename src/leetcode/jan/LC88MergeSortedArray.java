package leetcode.jan;

import java.util.Arrays;

public class LC88MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        m = m - 1;
        n = n - 1;

        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[idx] = nums1[m];
                m--;
            } else {
                nums1[idx] = nums2[n];
                n--;
            }
            idx--;
        }

        while (n >= 0) {
            nums1[idx] = nums2[n];
            idx--;
            n--;
        }

        System.out.println(Arrays.toString(nums1));

    }

    public static void main(String[] args) {
        LC88MergeSortedArray obj = new LC88MergeSortedArray();
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        int m = 3;
        int n = 3;
        obj.merge(nums1, m, nums2, n);

    }

}
