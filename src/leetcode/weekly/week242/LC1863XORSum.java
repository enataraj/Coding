package leetcode.weekly.week242;

public class LC1863XORSum {
    
    public int subsetXORSum(int[] nums) {
        int res=0,sum=0;
        for(int i=0;i<nums.length;i++){
            sum|=nums[i];
        }
        res=sum*((int)Math.pow(2,nums.length-1));
        return res;
    }

}
