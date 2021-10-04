package leetcode.aug2021;

public class LC330PatchingArray {

    public int minPatches(int[] nums, int n) {
        long reach = 0;
        int i = 0;
        int result = 0;
        while (reach < n) {
            if (i < nums.length && nums[i] <= reach + 1) {
                reach += nums[i];
                i++;
            } else {
                reach += reach + 1;
                result++;
            }
        }
        return result;
    }

    public int minPatchesol(int[] nums, int n) {
        long miss = 1;
        int i = 0;
        int res = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                res++;
            }
        }

        return res;
    }
}
