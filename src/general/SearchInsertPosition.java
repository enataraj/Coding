package general;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        if (nums.length == 0) {
            return 0;
        }
        if (target <= nums[0]) {
            return 0;
        }
        if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int first = 0;
        int last = nums.length - 1;
        int mid;
        int res = 0;

        while (first < last) {

            mid = first + (last - first) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                res = mid + 1;
                first = mid + 1;
            } else {
                last = mid;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 3 };
        int target = 3;
//        for (int i = 0; i < nums.length; i++) {
        int res = new SearchInsertPosition().searchInsert(nums, target);
        System.out.println("Result : " + res);
//        }

    }
}
