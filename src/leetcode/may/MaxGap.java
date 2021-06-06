package leetcode.may;

public class MaxGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        boolean[] numsBucket = new boolean[110];

        for (int num : nums) {
            numsBucket[num] = true;
        }

        int gap = 0;
        int idx1 = -1;
        int idx2 = -1;
        for (int i = 0; i < numsBucket.length; i++) {
            if (idx1 == -1 && numsBucket[i]) {
                idx1 = i;
            } else if (numsBucket[i]) {
                idx2 = i;
                gap = Math.max(gap, idx2 - idx1);
                idx1 = i;
                idx2 = -1;
            }
        }
        return gap;
    }

}
