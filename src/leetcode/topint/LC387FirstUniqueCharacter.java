package leetcode.topint;

import java.util.HashMap;
import java.util.Map;

public class LC387FirstUniqueCharacter {

    public int firstUniqChar(String s) {

        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.containsKey(s.charAt(i))) {
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) + 1);

            } else {
                freqMap.put(s.charAt(i), 1);
            }

        }

        for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;

    }

    public int firstUniqCharSol1(String s) {

        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;

    }

    public int firstUniqCharSol(String s) {
        int res = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int i = s.indexOf(c);
            if (i != -1 && i == s.lastIndexOf(c)) {
                res = Math.min(res, i);
            }
        }
        return res == s.length() ? -1 : res;
    }

}
