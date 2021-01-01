package leetcode.array;

import java.util.Arrays;

public class LC724PivotIndex {

    public int pivotIndex(int[] nums) {
        
        if(nums==null || nums.length ==0){
            return -1;
        }
        
        if(nums.length==1){
            return 0;
        }

        int len = nums.length - 1;
        int fwdSum[] = new int[nums.length];
        int backSum[] = new int[nums.length];
        fwdSum[0] = nums[0];
        backSum[len] = nums[len];
        int j = len;
        for (int i = 1; i < nums.length ; i++) {
            fwdSum[i] = fwdSum[i - 1]+ nums[i];
            backSum[j - 1] = backSum[j]+nums[j-1];
            j--;
        }

        System.out.println(Arrays.toString(fwdSum));
        System.out.println(Arrays.toString(backSum));
        for (int i = 0; i < nums.length; i++) {
            if (fwdSum[i] == backSum[i]) {
                return i;
            }
        }

        return -1;

    }
    
    
    public int pivotIndexSol(int[] nums) {
        int sum1=0;
        int sum2=0;
        for (int i=0;i<nums.length;++i)
        {
            sum1+=nums[i];
        }
          for (int j=0;j<nums.length;++j)
        {
           sum1-=nums[j];
              if(sum1==sum2)
              {
                  return j;
              }
             sum2+=nums[j];
           
          }
        return -1;
        
    }

    public static void main(String[] args) {
        LC724PivotIndex obj = new LC724PivotIndex();
        //int[] nums = { 1, 7, 3, 6, 5, 6 };
        int[] nums = { -1,-1,-1,-1,0,0};
        System.out.println(obj.pivotIndex(nums));

    }

}
