package leetcode.weekly;

import java.util.Arrays;

public class LC1818MinimumAbsoluteDifference {

    /*  
    Goal is to maximize the "saving" by setting a number in nums1 to another number in nums1 itself.
    For each nums1[i], try to find another number in nums1 that is "closest"(could be bigger or smaller) to nums2[i], which will minimize the difference, which in turn maximize the saving.
    How do we find the "closest" number? Binary search, duh!!!
    Pick the largest saving and substract it from the original diff sum.
    Simple!
    */

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] sorted1 = nums1.clone();
        Arrays.sort(sorted1);
        int result = 0;
        int save = 0;
        for (int i = 0; i < nums1.length; i++) {
            result += Math.abs(nums1[i] - nums2[i]);
            result %= 1000000007;
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[i])
                continue; // already equal, diff is already minimized
            int index = Arrays.binarySearch(sorted1, nums2[i]);
            int diff = Math.abs(nums1[i] - nums2[i]);
            // nums2[i] is actually in nums1[i], so we can minimize the diff to 0!
            if (index >= 0) {
                save = Math.max(save, diff);
            } else {
                // find the closest number in nums1 that is to nums2[i], need to look 2  numbers around the found index(supposed insertion index)
                int actualIndex = -1 * (index + 1);
                if (actualIndex > 0)
                    save = Math.max(save, diff - Math.abs(nums2[i] - sorted1[actualIndex - 1]));
                if (actualIndex < nums1.length)
                    save = Math.max(save, diff - Math.abs(nums2[i] - sorted1[actualIndex]));
            }
        }
        return (result - save) % 1000000007;
    }

}
