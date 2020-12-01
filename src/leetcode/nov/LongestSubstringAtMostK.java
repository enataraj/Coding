package leetcode.nov;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostK {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        if (s.length() <= k) {
            return s.length();
        }
        Map<Character, Integer> charMap = new HashMap<>();
        int res = 0;
        int count = 0;

        int removeIdx = 0;
        for (char ch : s.toCharArray()) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }

            if (charMap.size() <= k) {
                count++;
            } else {
                res = Math.max(count, res);

                count++;
                while (charMap.size() > k) {
                    char tmpCh = s.charAt(removeIdx);
                    if (charMap.get(tmpCh) == 1) {
                        charMap.remove(tmpCh);
                    } else {
                        charMap.put(tmpCh, charMap.get(tmpCh) - 1);
                    }
                    removeIdx++;
                    count--;
                }

            }

        }

       
        return res;

    }

    public static void main(String[] args) {
        LongestSubstringAtMostK obj = new LongestSubstringAtMostK();
        String s = "aaac";
        int k = 3;
        System.out.println(obj.longestSubstring(s, k));

    }

}
