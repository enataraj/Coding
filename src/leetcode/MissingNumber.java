package leetcode;

public class MissingNumber {
    
    public int missingNumber(int[] nums) {
        if(nums==null || nums.length ==0){
            return 0;
        }
        int n=nums.length;
        long totalSum = n*(n+1)/2;
        long sum =0;
        
        for(int num:nums){
            sum+=num;
        }
        
        return (int) (totalSum-sum);
        
    }  

}
