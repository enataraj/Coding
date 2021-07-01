package leetcode.june;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestLength = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                Integer curNum = num;
                int curLen = 1;
                while (numSet.contains(curNum + 1)) {
                    curNum = curNum + 1;
                    curLen++;

                }
                longestLength = Math.max(curLen, longestLength);
            }
        }
        return longestLength;
    }
    
    public int longestConsecutiveHashMap(int[] nums) {
        int longest = 0;
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (count.containsKey(num))
                continue;
            int left = count.getOrDefault(num - 1, 0);
            int right = count.getOrDefault(num + 1, 0);
            int current = left + right + 1;
            count.put(num, current);
            longest = Math.max(longest, current);
            count.put(num - left, current);
            count.put(num + right, current);
        }
        return longest;
    }

    class Solution {
        private static final int MAX_ARRAY_LEN = 10000;

        public int longestConsecutive(int[] nums) {
            return longestConsecutiveArray(nums);
            // return longestConsecutiveHashSet(nums);
            // return longestConsecutiveSorted(nums);
        }

        // O(n)
        // Only optimized for closely packed nums
        // Otherwise delegates to longestConsecutiveHashSet
        private int longestConsecutiveArray(int[] nums) {
            if (nums.length == 0)
                return 0;

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            int length = max - min + 1;
            if (length > MAX_ARRAY_LEN) {
                return longestConsecutiveHashSet(nums);
            }

            boolean[] exists = new boolean[length];
            for (int num : nums) {
                exists[num - min] = true;
            }

            int maxLen = 0;
            int currLen = 0;
            for (boolean exist : exists) {
                if (exist) {
                    currLen++;
                } else {
                    maxLen = Math.max(maxLen, currLen);
                    currLen = 0;
                }
            }
            return Math.max(maxLen, currLen);
        }

        // O(n)
        private int longestConsecutiveHashSet(int[] nums) {
            if (nums.length == 0)
                return 0;

            Set<Integer> values = new HashSet<>();
            for (int i : nums) {
                values.add(i);
            }

            int maxLen = 1;
            for (int num : values) {
                // Look for the beginning of the sequence
                if (values.contains(num - 1))
                    continue;

                int currNum = num + 1;
                while (values.contains(currNum)) {
                    currNum++;
                }
                maxLen = Math.max(maxLen, currNum - num);
            }
            return maxLen;
        }

        // O(nlogn)
        private int longestConsecutiveSorted(int[] nums) {
            if (nums.length == 0)
                return 0;

            Arrays.sort(nums);
            int maxLen = 1;
            int currLen = 1;
            int length = nums.length;
            for (int i = 1; i < length; i++) {
                // Seeing the same element does not increase the sequence
                if (nums[i] == nums[i - 1])
                    continue;

                if (nums[i] == nums[i - 1] + 1) {
                    currLen++;
                } else {
                    maxLen = Math.max(maxLen, currLen);
                    currLen = 1;
                }
            }
            return Math.max(maxLen, currLen);
        }
    }

    public static void main(String[] args) {
        LC128LongestConsecutiveSequence obj = new LC128LongestConsecutiveSequence();
    }

}
