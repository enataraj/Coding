package leetcode.sep2021;

import java.util.HashSet;
import java.util.Set;

public class LC565ArrayNesting {

    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], count = 0;
                while (nums[start] != Integer.MAX_VALUE) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public int arrayNestingDFS(int[] nums) {
        int answer = Integer.MIN_VALUE;
        Set<Integer> visited = new HashSet<Integer>();
        for (int index = 0; index < nums.length; index++) {
            if (visited.contains(index))
                continue;
            answer = Math.max(answer, dfs(nums, index, visited));
        }
        return answer;
    }

    private int dfs(int[] nums, int index, Set<Integer> visited) {
        if (visited.contains(index))
            return 0;
        visited.add(index);
        return 1 + dfs(nums, nums[index], visited);
    }

}
