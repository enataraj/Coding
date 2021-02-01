package leetcode.jan;

public class LC1646GetMaxGenArray {
    public int getMaximumGenerated(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int idx = 0;
        int max = 0;
        while (true) {
            if (2 * idx <= n) {
                nums[2 * idx] = nums[idx];
                max = Math.max(max, nums[2 * idx]);
            } else {
                break;
            }
            if (2 * idx + 1 <= n) {
                nums[2 * idx + 1] = nums[idx] + nums[idx + 1];
                max = Math.max(max, nums[2 * idx + 1]);
            } else {
                break;
            }
            idx++;
        }
        return max;

    }

    public static void main(String[] args) {
        LC1646GetMaxGenArray obj = new LC1646GetMaxGenArray();
        for (int i = 0; i < 15; i++) {
            System.out.println(i + "  " + obj.getMaximumGenerated(i));
        }

    }

}
