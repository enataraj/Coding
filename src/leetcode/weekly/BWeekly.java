package leetcode.weekly;

import java.util.Arrays;

public class BWeekly {

    public int minOperations(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                result += Math.abs(nums[i - 1] - nums[i]) + 1;
                nums[i] = nums[i - 1] + 1;
            }

        }
        System.out.println(Arrays.toString(nums));
        return result;
    }

    public int[] countPoints(int[][] P, int[][] Q) {
        int[] res = new int[Q.length];
        if (P.length == 0 || Q.length == 0)
            return res;
        int i = 0;
        for (int[] q : Q) {
            for (int[] p : P) {
                if (Math.pow(p[0] - q[0], 2) + Math.pow(p[1] - q[1], 2) <= Math.pow(q[2], 2))
                    res[i]++;
            }
            i++;
        }
        return res;
    }

    public int[] countPointsSol(int[][] points, int[][] queries) {

        int count, x1, y1, x2, y2;
        double distance;
        int ans[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            count = 0;
            x1 = queries[i][0];
            y1 = queries[i][1];
            for (int j = 0; j < points.length; j++) {
                x2 = points[j][0];
                y2 = points[j][1];
                distance = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
                if (distance <= queries[i][2] * queries[i][2]) {
                    count++;
                }
            }

            ans[i] = count;
        }
        return ans;
    }

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0, n = nums.length;
        int max = (1 << maximumBit) - 1;
        int res[] = new int[n];

        for (int e : nums)
            xor ^= e;//xor all elements

        for (int i = 0; i < n; i++) {
            res[i] = xor ^ max;// k = xor ^ max
            xor ^= nums[n - i - 1];//remove last element from xor
        }
        return res;
    }

    public static void main(String[] args) {
        BWeekly obj = new BWeekly();
        int[] nums = { 1, 1, 1, };

        System.out.println(obj.minOperations(nums));
    }
}
