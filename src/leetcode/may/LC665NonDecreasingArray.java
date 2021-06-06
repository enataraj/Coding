package leetcode.may;

public class LC665NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int cnt=0;
        for(int i=1;i<nums.length;i++){
            if (nums[i - 1] >nums[i]) {
                if (i == 1 || i == nums.length - 1 || nums[i + 1] >= nums[i - 1] || nums[i] >= nums[i - 2]) {
                cnt++;
                
                
            }else{
                    return false;
                }
        }
        }
        return cnt>1?false:true;     
    }

}
