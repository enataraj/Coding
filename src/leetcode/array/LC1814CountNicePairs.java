package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

public class LC1814CountNicePairs {
    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(i, reverse(nums[i]));
        long result = 0;
        HashMap<Integer, Integer> mapi = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i] - map.get(i);
            if (mapi.containsKey(val))
                result += mapi.get(val);
            mapi.put(val, mapi.getOrDefault(val, 0) + 1);
        }
        return (int) (result % 1000000007);
    }

    public int reverse(int num) {
        int n = 0;
        while (num != 0) {
            n = n * 10;
            n += num % 10;
            num = num / 10;
        }
        return n;
    }

    int mod = 1000000007;

    private long getCount(long n) {
        return n * (n - 1) / 2;
    }

    public int countNicePairsSol1(int[] nums) {
        int[] selfDiffs = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            selfDiffs[i] = nums[i] - reverse(nums[i]);
        }

        Arrays.sort(selfDiffs);

        long nicePairs = 0;

        int currentCount = 1;
        for (int i = 1; i < selfDiffs.length; i++) {
            if (selfDiffs[i] == selfDiffs[i - 1]) {
                currentCount++;
            } else {
                nicePairs += getCount((long) currentCount);
                nicePairs %= mod;
                currentCount = 1;
            }
        }
        nicePairs += getCount(currentCount);
        nicePairs %= mod;
        return (int) nicePairs;
    }
}
