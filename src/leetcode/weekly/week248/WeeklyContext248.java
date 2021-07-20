package leetcode.weekly.week248;

import java.util.Arrays;

public class WeeklyContext248 {
    public int[] buildArray(int[] nums) {
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

    public int eliminateMaximum(int[] dist, int[] speed) {

        double[] distance = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            distance[i] = dist[i] / (double) speed[i];
        }

        Arrays.sort(distance);

        int count = 0;
        for (int minute = 0; minute < distance.length && minute < distance[minute]; minute++) {
            count++;
        }

        return count;
    }

    /*
     * class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        minReach = []
        for d, s in zip(dist, speed):
            minute = math.ceil(d / s)
            minReach.append(minute)
        
        minReach.sort()
        res = 0
        for minute in range(len(minReach)):
            if minute >= minReach[minute]:
                return res
            res += 1
        return res
     */
    public static void main(String[] args) {
        WeeklyContext248 obj = new WeeklyContext248();

        int[] nums = { 0, 2, 1, 5, 3, 4 };
        // System.out.println(Arrays.toString(obj.buildArray(nums)));

        int[] dist = { 3, 2, 4 };
        int[] speed = { 5, 3, 2 };
        System.out.println(obj.eliminateMaximum(dist, speed));
    }

}
