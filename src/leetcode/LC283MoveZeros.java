package leetcode;

import java.util.Arrays;

public class LC283MoveZeros {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] == 0)) {
            return;
        }

        int numberOfZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numberOfZero++;
            }

        }

        if (numberOfZero == 0) {
            return;
        }

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                idx++;
            } else {
                nums[i - idx] = nums[i];
            }

        }
        
        for(int i=nums.length-numberOfZero;i<nums.length;i++) {
            nums[i] =0;
        }

        System.out.println(Arrays.toString(nums));

    }
    
   // Optimized Solution 
    
    public void moveZeroesOpt(int[] nums) {
        int index=0;
        for(int i=0; i<nums.length;i++){
            if(nums[i]!=0){
                nums[index]=nums[i];
                index++;
            }
            
        }
        for(int i=index;i<nums.length;i++){
            nums[i]=0;
        }
    }

    /*
     * 1,2,3,0 0,0,2,3 0,1,0,2 1,0,1,0
     * 
     * 
     * 
     */
    public static void main(String[] args) {
        LC283MoveZeros obj = new LC283MoveZeros();
         int[] nums = { 0, 1, 0, 3, 12 };
       // int[] nums = { 1, 1, 0, 3, 12 };
        obj.moveZeroes(nums);
    }

}
