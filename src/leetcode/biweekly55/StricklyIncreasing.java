package leetcode.biweekly55;

public class StricklyIncreasing {

    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int index = -1;

        for (int i = 1; i < n; i++)
            if (nums[i - 1] >= nums[i]) {
                cnt++;
                index = i;
            }

        if (cnt > 1)
            return false;

        if (cnt == 0 || index == n - 1 || index == 1)
            return true;

        if (nums[index - 1] < nums[index + 1] || nums[index - 2] < nums[index])
            return true;

        return false;
    }

}
