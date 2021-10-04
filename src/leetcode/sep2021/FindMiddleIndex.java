package leetcode.sep2021;

import java.util.Arrays;

public class FindMiddleIndex {
    
    public int findMiddleIndex(int[] nums) {
        int[] nums1 = new int[nums.length];
        int[] nums2 = new int[nums.length];
        nums1[0] = nums[0];
        nums2[nums.length-1] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            nums1[i] = nums1[i-1]+nums[i];
        }
        
        for(int i=nums.length-2;i>=0;i--){
            nums2[i]=nums2[i+1]+nums[i];
        }
        
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        for(int i=0;i<nums.length;i++){
            if(nums1[i]==nums2[i]){
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        FindMiddleIndex obj = new FindMiddleIndex();
        int[] nums = {2,3,-1,8,4};
        System.out.println(obj.findMiddleIndex(nums));
    }

}
