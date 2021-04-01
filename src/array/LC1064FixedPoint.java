package array;

public class LC1064FixedPoint {

    public int fixedPoint(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                res = Math.max(res, mid);
                right = mid - 1;
            } else if (nums[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        LC1064FixedPoint obj = new LC1064FixedPoint();
        int[] nums = { -10, -5, -2, 0, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(obj.fixedPoint(nums));
    }

}
