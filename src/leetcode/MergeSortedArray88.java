package leetcode;

public class MergeSortedArray88 {

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 3, 0, 0, 0 };
        int nums2[] = { 2, 5, 6 };
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);

    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n-1;
        m=m-1;
        n=n-1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[k] = nums1[m];
                m--;
                k--;
            } else {
                nums1[k] = nums2[n];
                n--;
                k--;
            }
        }

        while (n >= 0) {
            nums1[k] = nums2[n];
            n--;
            k--;
        }
        
        for(int i=0;i<nums1.length;i++) {
            System.out.print(" "+nums1[i] );
        }
    }

}
