package leetcode.aug2021;

public class LC26RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int writeIdx = 0;
        int readIdx = 1;
        while (readIdx < nums.length) {
            if (nums[writeIdx] != nums[readIdx]) {
                nums[writeIdx + 1] = nums[readIdx];
                readIdx++;
                writeIdx++;
            } else {
                readIdx++;
            }
        }
        return Math.min(writeIdx + 1, readIdx);
    }

    public int removeDuplicatesSol(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
