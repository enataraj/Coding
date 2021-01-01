package leetcode.dec;

public class LC334IncreasingSubsequencetriplet {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 3) {
            return false;
        }

        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= num1)
                num1 = nums[i];
            else if (nums[i] <= num2)
                num2 = nums[i];
            else
                return true;
        }
        return false;
    }
    
    
    public boolean increasingTripletalt(int[] nums) {
        int n = nums.length;
        
        int[] min = new int[n];
        int[] max = new int[n];
        
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(nums[i], min[i - 1]);
        }
        
        max[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max[i] = Math.max(nums[i], max[i + 1]);
        }
        
        for (int i = 1; i < n - 1; i++) {
            if (min[i - 1] < nums[i] && nums[i] < max[i + 1]) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        LC334IncreasingSubsequencetriplet obj = new LC334IncreasingSubsequencetriplet();

        int[] nums = { 2, 1, 5, 0, 4, 6 };
        System.out.println(obj.increasingTriplet(nums));

    }

}
