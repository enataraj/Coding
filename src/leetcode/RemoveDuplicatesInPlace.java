package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesInPlace {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length < 2) {
            return nums.length;
        }

        int i = 0, j = 1;

        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else if (i + 1 != j) {
                nums[i + 1] = nums[j];
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));

        return i + 1;

    }
    
    public int removeDuplicates_Optimized(int[] nums) {
        int i=1,j=1,n=nums.length;
        if(n<=1) return n;
        int prev=nums[0];
        while(i<n && j<n){
        while(i<n && nums[i]==prev) i++;
            if(i>=n) break;
            prev=nums[i];
            nums[j++]=nums[i++];
        }
        return j;   
    }

    public static void main(String[] args) {
        int[] nums = { 1,1, 2, 3,3,3,3,8 };

        RemoveDuplicatesInPlace obj = new RemoveDuplicatesInPlace();
        int len = obj.removeDuplicates(nums);
        System.out.println("Length : " + len);
    }

}
