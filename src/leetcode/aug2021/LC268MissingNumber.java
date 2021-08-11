package leetcode.aug2021;

public class LC268MissingNumber {
    public int missingNumber(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++)
            x ^= nums[i] ^ i + 1;
        return x;
    }

}
