package leetcode.april;

import java.util.Arrays;

public class LC34FirstAndLastPositionOfTarget {

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = findLeftIdx(nums, target);
        result[1] = findRightIdx(nums, target);
        return result;
    }

    private int findLeftIdx(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {

                right = mid;
            }
            if (nums[mid] < target) {
                left = mid;

            } else {
                right = mid;
            }

        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;

    }

    private int findRightIdx(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {

                left = mid;
            }
            if (nums[mid] > target) {
                right = mid;

            } else {
                left = mid;

            }

        }
        if (nums[right] == target) {
            return right;
        }
        if (nums[left] == target) {
            return left;
        }

        return -1;
    }

    public int[] searchRangeBruteForce(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right && (result[0] == -1 || result[1] == -1)) {
            if (result[0] == -1 && nums[left] == target) {
                result[0] = left;
            }
            if (result[1] == -1 && nums[right] == target) {
                result[1] = right;
            }
            if (result[0] == -1) {
                left++;
            }

            if (result[1] == -1) {
                right--;
            }
        }

        if (result[0] == -1 && result[1] != -1) {
            result[0] = result[1];
            result[1] = -1;
        }

        return result;
    }

    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int[] searchRangeAlternate(int[] nums, int target) {
        int[] targetRange = { -1, -1 };

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    public int[] searchRangeSrikanthSol(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid, st = Integer.MAX_VALUE;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target && ((mid == 0) || nums[mid - 1] != target)) {
                st = mid;
                break;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        if (st == Integer.MAX_VALUE) {
            return new int[] { -1, -1 };
        }

        left = 0;
        right = nums.length - 1;
        int end = st;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)) {
                end = mid;
                break;
            }
            if (nums[mid] <= target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return new int[] { st, end };

    }

    public static void main(String[] args) {
        LC34FirstAndLastPositionOfTarget obj = new LC34FirstAndLastPositionOfTarget();
        int[] nums = { 1 };
        int target = 1;
        System.out.println(Arrays.toString(obj.searchRange(nums, target)));
    }

}
