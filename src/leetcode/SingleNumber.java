package leetcode;

public class SingleNumber {
    
    public int singleNumber(int[] nums) {
        if(nums==null || nums.length ==0){
            return -1;
        }
        
        int res = nums[0];
        
        for(int i=1;i<nums.length;i++){
          res = res ^ nums[i];  
        }
        
        return res;
        
    }

}
