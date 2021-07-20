package leetcode.array;

public class LC183SumCloset {
    public int threeSumClosest(int[] nums, int target) {
        int diff= Integer.MAX_VALUE;
        int result=0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum =nums[i]+nums[j]+nums[k];
                   
                    if(diff > Math.abs(target-sum)){
                        diff = Math.abs(target-sum);
                        result = sum;
                       
                    }
                    
                    
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        LC183SumCloset obj = new LC183SumCloset();
        int[] nums = {-1,2,1,-4};
        int target=1;
        System.out.println(obj.threeSumClosest(nums, target));
    }

}
