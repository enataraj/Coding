package leetcode.july2021;

public class LC915PartitionDisJoint {

    public int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMin = new int[len];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            leftMax[i] = max;
        }

        int min = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            rightMin[i] = min;
        }
        for (int i = 1; i < nums.length; i++) {
            if (leftMax[i - 1] <= rightMin[i])
                return i;
        }
        return nums.length;
    }

    public int partitionDisjointSol(int[] a) {
        int localMax = a[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
            if (localMax > a[i]) {
                localMax = max;
                partitionIdx = i;
            }
        }
        return partitionIdx + 1;
    }

    public static void main(String[] args) {
        LC915PartitionDisJoint obj = new LC915PartitionDisJoint();
        int[] nums = { 5, 0, 3, 8, 6 };
        /* int[] nums = { 12, 75, 26, 38, 56, 59, 83, 55, 49, 52, 27, 48, 77, 21, 27, 79, 54, 15, 59, 22, 34, 35, 81, 67,
                2, 41, 40, 0, 73, 61, 75, 8, 86, 42, 49, 83, 43, 16, 2, 54, 26, 35, 15, 63, 31, 24, 51, 86, 6, 35, 42,
                37, 83, 51, 34, 21, 71, 57, 61, 76, 50, 1, 43, 32, 19, 13, 67, 87, 3, 33, 38, 34, 34, 84, 38, 76, 52, 7,
                27, 49, 2, 78, 56, 28, 70, 6, 64, 87, 100, 97, 99, 97, 97, 100, 100, 100, 97, 89, 98, 100 }; 
                */
        System.out.println(obj.partitionDisjoint(nums));
    }

}
