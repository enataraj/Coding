package leetcode.array;

/*
 * Dutch National flag Question
 * https://leetcode.com/problems/sort-colors/
 * 
 */
public class LC75SortColor {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, hi = nums.length - 1;
        while (mid <= hi) {
            if (nums[mid] == 0) {
                int tmp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = tmp;
                low++;
                mid++;

            } else if (nums[mid] == 1) {
                mid++;

            } else if (nums[mid] == 2) {
                int tmp = nums[mid];
                nums[mid] = nums[hi];
                nums[hi] = tmp;
                hi--;
            }
        }

    }

}
