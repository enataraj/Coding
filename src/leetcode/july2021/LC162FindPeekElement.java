package leetcode.july2021;

public class LC162FindPeekElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == nums.length - 1) {
            return left;
        }
        if (nums[left] > nums[left + 1]) {
            return left;
        }
        return right;
    }

    public int findPeakElementSol(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public int findPeakElementIterative(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            }
            return 1;
        }
        if (nums[1] < nums[0]) {
            return 0;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

}
