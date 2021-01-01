package leetcode.array;

public class LC665NonDecreasingArray {
        public boolean checkPossibility(int[] nums) {
            if (nums == null || nums.length == 0) {
                return true;
            }
            if (nums.length == 1) {
                return true;
            }
    
            int count = 0;
    
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] > nums[i]) {
                    if (i == 1 || i == nums.length - 1 || nums[i + 1] >= nums[i - 1] || nums[i] >= nums[i - 2]) {
    
                        count++;
                    } else {
                        return false;
                    }
    
                }
                if (count > 1) {
                    return false;
                }
            }
    
            return true;
        }

    public static void main(String[] args) {
        LC665NonDecreasingArray obj = new LC665NonDecreasingArray();
        int[] nums = { 3, 4, 2, 3 };
        System.out.println(obj.checkPossibility(nums));
    }

}
