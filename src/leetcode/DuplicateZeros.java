package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateZeros {

	public void duplicateZeros(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				for (int j = arr.length - 1; j > i; j--) {
					arr[j] = arr[j - 1];

				}
				// System.out.println(Arrays.toString(arr));
				if ((i + 1) < arr.length) {
					arr[i + 1] = 0;
					i = i + 1;
				}
			}

		}
		System.out.println(Arrays.toString(arr));

	}

	public void duplicateZerosUsingList(int[] arr) {

		if (arr == null || arr.length == 0) {
			return;
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				list.add(0);
			}
			list.add(arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i);
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {

		int nums[] = { 1,0,2,3,0,4,5,0};
		System.out.println(Arrays.toString(nums));

		DuplicateZeros obj = new DuplicateZeros();
		//obj.duplicateZeros(nums);
		obj.duplicateZerosUsingList(nums);

	}

}
