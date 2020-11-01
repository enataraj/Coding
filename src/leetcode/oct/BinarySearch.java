package leetcode.oct;

public class BinarySearch {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return -1;
        }

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + end - start / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;

            } else {
                return mid;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
       // int nums[] = { -1, 0, 3, 5, 9, 12 };
        int nums[] = { 2,5 };
        int target = 2;
        System.out.println(obj.search(nums, target));

    }

}
