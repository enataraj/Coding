package array;

import java.util.Arrays;

public class LC26RemoveDuplicateSortedArray {
    
public int removeDuplicates(int[] nums) {
    
    if(nums==null) {
        return 0;
    }
    
    if(nums.length<2) {
        return nums.length;
    }
    
    int i=0,j=1;
    
    while(j<nums.length) {
        if(nums[i]!=nums[j]) {
            nums[i+1] = nums[j];
            j++;
            i++;
        }else {
            j++;
        }
    }
    
    System.out.println(Arrays.toString(nums));
    return Math.min(i+1, nums.length);
        
    }
    
    public static void main(String[] args) {
        LC26RemoveDuplicateSortedArray obj = new LC26RemoveDuplicateSortedArray();
        int[] nums = {0,0,1,2,3,3};
        System.out.println(obj.removeDuplicates(nums));
    }

}
