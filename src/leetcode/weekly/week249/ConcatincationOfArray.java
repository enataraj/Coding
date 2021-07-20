package leetcode.weekly.week249;

public class ConcatincationOfArray {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int res[] = new int[len * 2];
        for (int i = 0; i < len; i++) {
            res[i] = nums[i];
            res[len + i] = nums[i];
        }
        return res;
    }

}
