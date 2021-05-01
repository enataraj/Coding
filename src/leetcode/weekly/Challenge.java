package leetcode.weekly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Challenge {

    public String truncateSentence(String s, int k) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                k--;
            }

            if (k > 0) {
                buffer.append(ch);
            } else {
                break;
            }
        }

        return buffer.toString();

    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] pair : logs) {
            int usr = pair[0];
            int active = pair[1];
            if (map.containsKey(usr)) {
                Set<Integer> set = map.get(usr);
                set.add(active);
                map.put(usr, set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(active);
                map.put(usr, set);

            }
        }

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int key : map.keySet()) {
            map1.put(key, map.get(key).size());
        }

            for (int uam : map1.values()) {
                result[uam - 1]++;
            }

        return result;

    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        long result = 0;

        for (int i = 0; i < nums1.length; i++) {
            result += Math.abs(nums1[i] - nums2[i]);
        }
        if (result == 0) {
            return 0;
        }

        int delta = Integer.MAX_VALUE;
        int diffDelta = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int diff = Math.abs(nums1[j] - nums2[j]);
                int diff1 = Math.abs(nums1[i] - nums2[j]);
                if (diff1 < diff) {
                    delta = Math.min(delta, diff1);
                    diffDelta = diff;
                    //break;
                }

            }
        }
        result = result - (diffDelta - delta);

        return (int) result % 1000000007;
    }

    public static void main(String[] args) {
        String s = "chopper is not a tanuki";
        int k = 5;
        Challenge obj = new Challenge();
        System.out.println(obj.truncateSentence(s, k));

        int[][] logs = { { 0, 5 }, { 1, 2 }, { 0, 2 }, { 0, 5 }, { 1, 3 } };
        // int[][] logs = { { 1, 1 }, { 2, 2 }, { 2, 3 } };
        int k1 = 5;
        System.out.println(Arrays.toString(obj.findingUsersActiveMinutes(logs, k1)));
        
        int[] nums1= {1,10,4,4,2,7};
        int[] nums2 = {9,3,5,1,7,4};
        
        System.out.println(obj.minAbsoluteSumDiff(nums1, nums2));

    }

}
