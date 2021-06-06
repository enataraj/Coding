package general;

import java.util.HashSet;
import java.util.Set;

public class LC128LongestConseqtive {

    public int longestConsecutiveTLE(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            numSet.add(num);
        }
        int maxCnt = 0;
        int cnt = 0;
        for (int i = min; i <= max; i++) {
            if (numSet.contains(i)) {
                cnt++;
            } else {
                maxCnt = Math.max(maxCnt, cnt);
                cnt = 0;
            }
        }
        maxCnt = Math.max(maxCnt, cnt);
        return maxCnt;
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int res = 0;
        int localRes = 0;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                for (int i = num; i < Integer.MAX_VALUE; i++) {
                    if (numSet.contains(i)) {
                        localRes++;
                    } else {
                        break;
                    }
                }
                res = Math.max(localRes, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC128LongestConseqtive obj = new LC128LongestConseqtive();
        int[] nums = { 0, 1, 2, 5, 6, 7, 8 };
        System.out.println(obj.longestConsecutive(nums));
    }

}
