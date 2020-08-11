package leetcode;

public class ThirdMaxNumber {

    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return nums[0];
            }
            return nums[1];
        }

        long firstMax = Long.MIN_VALUE;
       

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                firstMax = nums[i];
            }
        }

        long secondMax = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > secondMax && nums[i] < firstMax) {
                secondMax = nums[i];
               
            }
        }

        long thirdMax = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
                
            }
        }
        
        if(secondMax == Long.MIN_VALUE || thirdMax==Long.MIN_VALUE) {
            return (int)firstMax;
        }
     
        return (int)thirdMax;
    }

    public static void main(String[] args) {
        
        ThirdMaxNumber obj = new ThirdMaxNumber();
        int [] nums= {1,2,-2147483648};
        System.out.println(obj.thirdMax(nums));
        
    }
}
