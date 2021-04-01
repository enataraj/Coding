package leetcode.array;

import java.util.Arrays;

public class LC34FindFirstAndLastPos {
    
    
    
    
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
    
    

    public int[] searchRangeNw(int[] nums, int target) {
        
        
        

        int res[] = { -1, -1 };
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1 && nums[0] == target) {
            res[0] = 0;
            res[0] = 0;
            return res;
        }

        int left = 0;
        int right = nums.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                idx = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(idx);

        if (idx != -1) {

            for (int i = idx; i < nums.length - 1; i++) {
                if (nums[idx] != nums[i + 1]) {
                    break;
                }
                res[1] = i;
            }

            for (int i = idx; i > 0; i--) {
                if (nums[idx] != nums[i - 1]) {
                    break;
                }
                res[0] = i;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        LC34FindFirstAndLastPos obj = new LC34FindFirstAndLastPos();
        int[] nums = { 2, 2 };

        System.out.println(Arrays.toString(obj.searchRange(nums, 2)));
    }

}
