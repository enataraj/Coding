package leetcode.topint;

import java.util.Arrays;

public class LC88MergedSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[idx--] = nums1[m--];

            } else {
                nums1[idx--] = nums2[n--];
            }
        }
        while (m >= 0) {
            nums1[idx--] = nums1[m--];
        }

        while (n >= 0) {
            nums1[idx--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        LC88MergedSortedArray obj = new LC88MergedSortedArray();
        int nums1[] = { 1, 2, 3, 0, 0, 0 };
        int nums2[] = { 2, 5, 6 };

        obj.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

}
