package leetcode.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC473MatchSticks {

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        int perimeter = 0;
        for (int num : matchsticks) {
            perimeter += num;
        }
        if (perimeter % 4 != 0) {
            return false;
        }

        int[] sides = new int[4];
        int side = perimeter / 4;
        for (int i = 0; i < 4; i++) {
            sides[i] = side;
        }

        Arrays.sort(matchsticks);
        return dfsHelper(matchsticks, sides, 0);

    }

    private boolean dfsHelper(int[] matchsticks, int[] sides, int idx) {
        if (idx == matchsticks.length) {
            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (matchsticks[idx] > sides[i])
                continue;
            sides[i] -= matchsticks[idx];
            if (dfsHelper(matchsticks, sides, idx + 1))
                return true;
            sides[i] += matchsticks[idx];

        }
        return false;
    }

    public boolean helper(int i, int[] nums, boolean[] vis, int sum) {
        if (sum <= 0)
            return sum == 0;
        for (; i >= 0; i--) {
            if (!vis[i]) {
                vis[i] = true;
                if (helper(i, nums, vis, sum - nums[i]))
                    return true;
                vis[i] = false;
            }
        }
        return false;
    }

    public boolean makesquareOpt(int[] nums) {

        if (nums.length == 0 || nums == null)
            return false;
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 4 != 0)
            return false;
        int side = sum / 4;
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!vis[i]) {
                vis[i] = true;
                if (!helper(i, nums, vis, side - nums[i]))
                    return false;
            }
        }
        return true;
    }

    public boolean makesquareNotWorking(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : matchsticks) {
            queue.add(num);
        }

        while (queue.size() > 4) {
            queue.add(queue.poll() + queue.poll());
        }

        int side = queue.poll();
        while (!queue.isEmpty()) {
            if (side != queue.poll()) {
                return false;
            }
        }
        return true;
    }

    class Solution {
        public boolean makesquare(int[] matchsticks) {
            int matchsticksSum = 0;
            for (int matchstick : matchsticks)
                matchsticksSum += matchstick;
            if ((matchsticksSum % 4) != 0)
                return false;
            List<Integer> fourSums = new ArrayList<Integer>();
            for (int index = 0; index < 4; index++)
                fourSums.add(0);

            Arrays.sort(matchsticks);
            int left = 0;
            int right = matchsticks.length - 1;
            while (left < right) {
                int tmp = matchsticks[left];
                matchsticks[left] = matchsticks[right];
                matchsticks[right] = tmp;
                left++;
                right--;
            }
            return backtrack(matchsticks, fourSums, matchsticksSum / 4, 0);
        }

        private boolean backtrack(int[] matchsticks, List<Integer> fourSums, int target, int index) {
            if (index == matchsticks.length)
                return (fourSums.get(0) == fourSums.get(1) && fourSums.get(1) == fourSums.get(2)
                        && fourSums.get(2) == fourSums.get(3) && fourSums.get(3) == fourSums.get(0));
            for (int si = 0; si < 4; si++) {
                if (fourSums.get(si) + matchsticks[index] <= target) {
                    fourSums.set(si, fourSums.get(si) + matchsticks[index]);
                    if (backtrack(matchsticks, fourSums, target, index + 1))
                        return true;
                    fourSums.set(si, fourSums.get(si) - matchsticks[index]);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        LC473MatchSticks obj = new LC473MatchSticks();
    }

}
