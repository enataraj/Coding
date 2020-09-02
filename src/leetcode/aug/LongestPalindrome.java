package leetcode.aug;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;

        if (s.length() == 1) {
            return 1;
        }

        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        boolean flag = false;
        for (char key : freqMap.keySet()) {

            int val = freqMap.get(key);

            if (val % 2 == 0) {
                count = count + val;
            } else {
                count = count + val - 1;
                flag = true;
            }
        }

        if (flag) {
            count = count + 1;
        }

        return count;

    }

    public int longestPalindromeOpt(String s) {
        int[] chars = new int[128];
        char[] t = s.toCharArray();
        for (char c : t) {
            chars[c]++;
        }
        int single = 0;
        for (int n : chars) {
            if (n % 2 != 0) {
                single++;
            }
        }
        return single > 1 ? t.length - single + 1 : t.length;
    }

    public static void main(String[] args) {
        LongestPalindrome obj = new LongestPalindrome();
        String s = "ccc";
        System.out.println(obj.longestPalindrome(s));
    }

}
