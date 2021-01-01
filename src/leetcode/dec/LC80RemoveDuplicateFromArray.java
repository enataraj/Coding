package leetcode.dec;

public class LC80RemoveDuplicateFromArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = 0;
        int runIdx = 0;
        while (runIdx < nums.length) {
            int val = nums[runIdx];
            int cnt = getDuplicateCount(nums, runIdx);
            if (cnt >= 2) {
                nums[len] = val;
                nums[len + 1] = val;
                len += 2;
            } else {
                nums[len] = val;
                len += 1;
            }
            runIdx = runIdx + cnt;
        }
        // System.out.println(Arrays.toString(nums));
        return len;

    }

    private int getDuplicateCount(int[] nums, int i) {
        int cnt = 1;
        int val = nums[i];
        while ((i + 1) < nums.length && val == nums[i + 1]) {
            cnt++;
            i = i + 1;

        }
        // System.out.println("Value :" + val + " Cont " + cnt);
        return cnt;
    }

    public int removeDuplicatesParin(int[] nums) {
        int n = nums.length, readIdx = 0, writeIdx = 0;

        while (readIdx < n) {
            int num = nums[readIdx++], numCount = 1;
            nums[writeIdx++] = num;
            while (readIdx < n && nums[readIdx] == num) {
                ++readIdx;
                ++numCount;
            }

            if (numCount > 1) {
                nums[writeIdx++] = num;
            }
        }

        return writeIdx;
    }

    public static void main(String[] args) {
        LC80RemoveDuplicateFromArray obj = new LC80RemoveDuplicateFromArray();
        int[] nums = { 1, 1, 2, 2, 3 };
        System.out.println(obj.removeDuplicates(nums));

    }

}
