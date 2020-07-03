package leetcode;

import java.util.Arrays;

public class SquareOfSortedArray {

	public int[] sortedSquares(int[] A) {
		int[] res = new int[A.length];
		int i = 0;
		int j = A.length - 1;
		int resIdx = A.length - 1;
		;
		while (i <= j) {
			int iSqr = A[i] * A[i];
			int jSqr = A[j] * A[j];
			if (iSqr >= jSqr) {
				res[resIdx] = iSqr;
				i++;

			} else {
				res[resIdx] = jSqr;
				j--;

			}
			resIdx--;
		}
		return res;

	}

	public static void main(String[] args) {

		int[] A = { -7, -3, 2, 3, 11 };
		SquareOfSortedArray obj = new SquareOfSortedArray();
		A = obj.sortedSquares(A);
		System.out.println(Arrays.toString(A));

	}
}
