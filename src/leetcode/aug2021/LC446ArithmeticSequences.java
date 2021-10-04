package leetcode.aug2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC446ArithmeticSequences {
    int result = 0;

   
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map[] = new Map[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[j] - nums[i];
                int n2 = map[i].getOrDefault(diff, 0);
                int n1 = map[j].getOrDefault(diff, 0);
                result += n1;
                int freq = n1 + n2 + 1;
                map[i].put(diff, freq);
            }
        }
        return result;
    }

    public int numberOfArithmeticSlicessss(int[] nums) {
        int ans = 0;
        int len = nums.length;
        Map<Integer, Integer>[] map = new Map[len];

        for (int i = 0; i < len; i++) {
            map[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diff = (long) (nums[j]) - nums[i];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE)
                    continue;

                int dif = (int) diff;
                int n2 = map[i].getOrDefault(dif, 0);
                int n1 = map[j].getOrDefault(dif, 0);
                ans += n1;
                int freq = n1 + n2 + 1;
                map[i].put(dif, freq);
            }
        }

        return ans;
    }

    public int numberOfArithmeticSlicesAlt(int[] nums) {
        int ans = 0;
        Set<Integer> differenceSet = new HashSet<>();
        // Map<Integer, Integer>[] map = new Map[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = nums[j] - nums[i];
                differenceSet.add(diff);
                map.put(diff, map.getOrDefault(diff, 1) + 1);
            }
        }

        System.out.println(map);

        for (int value : map.values()) {
            if (value > 2) {
                value = value - 3;
                ans += ((value * (value + 1)) / 2);
            }
        }

        return ans;

    }
    
    public int numberOfArithmeticSlicesTLE(int[] nums) {

        Set<Integer> differenceSet = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                differenceSet.add(nums[j] - nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int diff : differenceSet) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                dfsHelper(nums, i, list, diff);
            }
        }
        return result;

    }

    private void dfsHelper(int[] nums, int start, List<Integer> list, int diff) {
        if (list.size() > 2) {
            result++;
        }
        if (start >= nums.length) {
            return;
        }
        for (int j = start + 1; j < nums.length; j++) {
            if (nums[j] - list.get(list.size() - 1) == diff) {
                list.add(nums[j]);
                dfsHelper(nums, j, list, diff);
                list.remove(list.size() - 1);
            }
        }

    }


    public static void main(String[] args) {
        LC446ArithmeticSequences obj = new LC446ArithmeticSequences();
        //int[] nums = { 2, 4, 6, 8, 10 };
        int[] nums = { 2, 4, 6, 8, 10 };
        System.out.println(obj.numberOfArithmeticSlicesAlt(nums));
    }

}
