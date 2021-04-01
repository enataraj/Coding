package leetcode.array;

public class LC907SubArrayMinimum {

    long result = 0;
    public int sumSubarrayMins(int[] arr) {
        dfsHelpher(arr, 0, 0);
        return (int) (result % 1000000007);

    }

    private void dfsHelpher(int[] nums, int start, int end) {
        if (end == nums.length)
            return;

        else if (start > end) {
            dfsHelpher(nums, 0, end + 1);
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = start; i <= end; i++) {
                min = Math.min(min, nums[i]);

            }

            result += min;

            dfsHelpher(nums, start + 1, end);
        }

    }

    public static void main(String[] args) {
        LC907SubArrayMinimum obj = new LC907SubArrayMinimum();
        int[] nums = { 11,81,94,43,3 };
        System.out.println(obj.sumSubarrayMins(nums));
    }

}
