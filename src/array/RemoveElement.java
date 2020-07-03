package array;

import java.util.Arrays;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int res[] = new int[nums.length];
		int i = 0, j = 0;
		while (i < nums.length) {
			if (nums[i] != val) {
				res[j] = nums[i];
				i++;
				j++;
			} else {
				i++;
			}

		}

		for (i = 0; i < nums.length; i++) {
			nums[i] = res[i];
		}
		System.out.println(Arrays.toString(nums));
		return j;
	}
	
	 public int removeElementOptimized(int[] nums, int val) {
	        int index = 0;
	        for(int i=0; i<nums.length; i++) {
	            if(nums[i] != val) nums[index++] = nums[i];
	        }
	            return index;
	        
	 }
	       

	public static void main(String[] args) {
		int nums[] = { 3, 2, 2, 3 };
		RemoveElement obj = new RemoveElement();
		int res = obj.removeElement(nums, 3);
		System.out.println(res);

	}

}
