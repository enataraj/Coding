package leetcode.aug2021;

public class LC153FindMinimumInRotated {
    public int findMin(int[] nums) {     
        int left = 0;
        int right = nums.length;
        int rightVal = nums[nums.length - 1];

        while (left != right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > rightVal)
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
    
  
    public static void main(String[] args) {
        LC153FindMinimumInRotated obj = new LC153FindMinimumInRotated();
        int[] nums = { 5, 1, 2, 3, 4 };
        System.out.println(obj.findMin(nums));
    }

}
