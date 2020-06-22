package leetcode;

import java.util.Arrays;

public class SuffleAnArray {
	 public int[] shuffle(int[] nums, int n) {
		 if(n==0) {
			 return nums;
		 }
		 
		 int res[] = new int[nums.length];
		 for(int i=0,j=0;i<nums.length;i=i+2,j++) {
			 res[i]=nums[j];
			 res[i+1] = nums[n+j];
		 }
		 return res;
	        
	    }
	 
	 public static void main(String[] args) {
		 int nums[] = {2,5,1,3,4,7};
		 int n=3;
		 int exp[]= {2,3,5,4,1,7};
		 System.out.println(" Inp "+Arrays.toString(nums));
		 nums = new SuffleAnArray().shuffle(nums, n);
		 System.out.println(" Exp "+Arrays.toString(exp));
		 System.out.println(" Res "+Arrays.toString(nums));
	}

}
