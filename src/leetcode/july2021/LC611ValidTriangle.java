package leetcode.july2021;

import java.util.Arrays;

public class LC611ValidTriangle {
    
    
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int left, right;
        if (nums.length < 3) {
            return 0;
        }

        for (int idx = 2; idx < nums.length; idx++) {
            left = 0;
            right = idx - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[idx]) {
                    result += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }

    public int triangleNumberBF(int[] nums) {
        Arrays.sort(nums);
        int result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

}
