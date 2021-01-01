package leetcode.array;

public class LC1464MaxProduct {
    public int maxProduct(int[] nums) {
        int idx = -1;
        int firstVal = -1;

        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if (firstVal < tmp) {
                idx = i;
            }
            firstVal = Math.max(firstVal, tmp);
            
        }

        int secondVal = -1;
        for (int i = 0; i < nums.length; i++) {
            if (idx != i) {
                secondVal = Math.max(secondVal, nums[i]);
            }

        }

        return (secondVal - 1) * (firstVal - 1);

    }
    
    
    public int maxProduct_Sol(int[] nums) {
        int m=Integer.MIN_VALUE; int n=m;
        for(int num:nums){
            if(num >= m){
                n=m;
                m=num;
            }else if(num > n){
                n=num;
            }
        }
        return (m - 1)*(n - 1);
    }

    public static void main(String[] args) {
        LC1464MaxProduct obj = new LC1464MaxProduct();
        int[] nums = { 3, 5, 5, 2 };
        System.out.println(obj.maxProduct(nums));
    }

}
