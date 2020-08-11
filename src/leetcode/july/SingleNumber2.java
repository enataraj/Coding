package leetcode.july;

public class SingleNumber2 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (min > num) {
                min = num;
            }
        }

        return min;

    }
    
    public int findMinOpt(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]==nums[r])
                r--;
            else if(nums[mid]<nums[r])
                r=mid;
            else
                l=mid+1;
        }return nums[l];
    }
    
    
    public int findMinParin(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i-1] > nums[i]) {
                return nums[i];
            }
        }
        
        return nums[0];
    }

    public static void main(String[] args) {
        SingleNumber2 obj = new SingleNumber2();
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(obj.findMin(nums));

    }

}
