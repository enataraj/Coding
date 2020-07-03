package array;

import java.util.Arrays;

public class ArrayMerge {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int len = nums1.length;

		while (m > 0 && n > 0) {
			if (nums1[m - 1] < nums2[n - 1]) {
				nums1[len - 1] = nums2[n - 1];
				n--;
				len--;
			} else {
				nums1[len - 1] = nums1[m - 1];
				m--;
				len--;
			}
			System.out.println(Arrays.toString(nums1));
		}

		while (n > 0) {
			nums1[n-1] = nums2[n-1];
			n--;
		}

		System.out.println(Arrays.toString(nums1));

	}

	public static void main(String[] args) {
		ArrayMerge obj = new ArrayMerge();
	//	int[] nums1 = {14, 15, 16, 17, 18, 19,0, 0, 0,0,0};
       // int[] nums2 = {  3, 4, 6, 7, 8  };
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 4, 5, 6 };
		obj.merge(nums1, 3, nums2, 3);
	}

}
