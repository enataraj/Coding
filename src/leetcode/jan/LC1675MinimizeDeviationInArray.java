package leetcode.jan;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class LC1675MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        // Convert All Odd Number into Even and add into TreeSet
        for (int num : nums) {
            if (num % 2 == 1) {
                treeSet.add(num * 2);

            } else {
                treeSet.add(num);
            }
        }
        int res = Integer.MAX_VALUE;
        // Find the deviation by calculating last - first value, If last value is Even
        // we can reduce and add back into TreeSet. Do it till we find the deviation min
        // as well as if you have even left in input.
        while (true) {
            int tmp = treeSet.last();
            if (tmp % 2 == 0) {
                res = Math.min(treeSet.last() - treeSet.first(), res);
                treeSet.pollLast();
                treeSet.add(tmp / 2);
                res = Math.min(treeSet.last() - treeSet.first(), res);
            } else {
                break;
            }
        }

        return res;

    }

    public int minimumDeviationPQ(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(nums.length, (a, b) -> a[0] - b[0]);// {min, ori}

        int max = 0;
        for (int e : nums) {
            int i = e;
            while ((i & 1) != 1)
                i = i >> 1;
            max = Math.max(max, i);
            pq.add(new int[] { i, e });
        }

        // System.out.println(pq);
        int ans = Integer.MAX_VALUE;
        int imax = max;

        while (!pq.isEmpty()) {
            int e[] = pq.remove();

            ans = Math.min(ans, Math.abs(max - e[0]));
            if (e[0] == imax)
                break;

            if (e[1] % 2 == 0 && e[0] == e[1])
                break;

            if (e[0] % 2 == 1 || (e[0] * 2 <= e[1])) {
                if (e[0] * 2 > e[0]) {
                    max = Math.max(max, e[0] * 2);
                    e[0] *= 2;
                    pq.add(e);
                }
            } else
                break;

        }
        return ans;
    }

    public int minimumDeviationDFS(int[] nums) {
        Integer minMax = null;
        for (int num : nums) {
            if ((num & 1) == 1) {
                minMax = minMax == null ? num : Math.max(minMax, num);
            } else {
                while ((num & 1) == 0)
                    num >>= 1;
                minMax = minMax == null ? num : Math.max(minMax, num);
            }
        }
        return dfs(nums, 0, minMax, minMax);
    }

    int dfs(int[] nums, int idx, int min, int max) {
        if (idx == nums.length)
            return max - min;
        int num = nums[idx];
        if (num >= min && num <= max)
            return dfs(nums, idx + 1, min, max);
        if ((num & 1) == 1) {
            if (num * 2 > max) {
                return Math.min(dfs(nums, idx + 1, num, max), dfs(nums, idx + 1, min, num * 2));
            }
            return dfs(nums, idx + 1, Math.min(num * 2, min), max);

        }
        while ((num & 1) == 0 && (num >> 1) >= min) {
            num >>= 1;
        }
        if (num > max) {
            return Math.min(dfs(nums, idx + 1, min, num),
                    dfs(nums, idx + 1, Math.min(num / 2, min), Math.max(num / 2, max)));
        }
        return dfs(nums, idx + 1, Math.min(num, min), max);

    }

    public static void main(String[] args) {
        LC1675MinimizeDeviationInArray obj = new LC1675MinimizeDeviationInArray();
        // int[] nums = { 1, 2, 3, 4 };
        // int[] nums = {4,1,5,20,3};
        int[] nums = { 3, 5 };
        // int[] nums = { 4, 9, 4, 5 };

        System.out.println(obj.minimumDeviation(nums));
    }
}
