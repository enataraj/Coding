package leetcode.july2021;

import java.util.Arrays;

public class LC16ThreeSumCloset {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;

            while (leftIdx < rightIdx) {
                int curDiff = Math.abs(target - (nums[i] + nums[leftIdx] + nums[rightIdx]));
                if (curDiff == 0) {
                    return target;
                }

                if (curDiff < diff) {
                    diff = curDiff;
                    result = nums[i] + nums[leftIdx] + nums[rightIdx];
                }

                if (nums[i] + nums[leftIdx] + nums[rightIdx] > target) {
                    rightIdx--;
                } else {
                    leftIdx++;
                }

            }
        }
        return result;
    }

    private int[] findMinDiffAndResult(int[] nums, int leftIdx, int rightIdx, int target, int diff) {
        System.out.println("Left Idx :" + leftIdx + " Right Idx :" + rightIdx + " Diff " + diff);

        int result = 0;
        if (rightIdx - leftIdx > 1) {
            for (int i = leftIdx + 1; i < rightIdx; i++) {

                int curDiff = Math.abs(target - (nums[i] + nums[leftIdx] + nums[rightIdx]));
                if (curDiff < diff) {
                    diff = curDiff;
                    result = nums[i] + nums[leftIdx] + nums[rightIdx];
                    System.out.println("Res : " + result);
                }

                if (diff == 0) {
                    return new int[] { 0, target };
                }
            }
            return new int[] { diff, result };
        }
        return new int[] { Integer.MAX_VALUE, target };
    }

    public int threeSumClosestBF(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int curDiff = Math.abs(target - (nums[i] + nums[j] + nums[k]));
                    if (curDiff < diff) {
                        diff = curDiff;
                        result = nums[i] + nums[j] + nums[k];

                    }

                    if (diff == 0) {
                        return target;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        LC16ThreeSumCloset obj = new LC16ThreeSumCloset();
        // int[] nums = { -1, 2, 1, -4 };
        //  int target = 1;

        int target = 13;
        int[] nums = { -111, -111, 3, 6, 7, 16, 17, 18, 19 };

        System.out.println(obj.threeSumClosest(nums, target));
    }

}
