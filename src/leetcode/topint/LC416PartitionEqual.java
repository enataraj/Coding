package leetcode.topint;

import java.util.Arrays;

public class LC416PartitionEqual {
    public boolean canPartition(int[] nums) {
       
        Arrays.sort(nums);

        int[] leftPrefixSum = new int[nums.length];
        int[] rightPrefixSum = new int[nums.length];
        leftPrefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftPrefixSum[i] = leftPrefixSum[i - 1] + nums[i];
        }

        rightPrefixSum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightPrefixSum[i] = rightPrefixSum[i + 1] + nums[i];
        }
        System.out.println(Arrays.toString(leftPrefixSum));
        System.out.println(Arrays.toString(rightPrefixSum));

        for (int i = 0; i < nums.length; i++) {
            if (rightPrefixSum[i] == leftPrefixSum[i]) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        LC416PartitionEqual obj = new LC416PartitionEqual();       
        System.out.println(obj.canPartition(nums));
        
    }

}
