package leetcode.topint;

import java.util.HashMap;
import java.util.Map;

public class LC13RomanToInteger {
    public int romanToInt(String s) {

        int res = 0;
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == 'I' && i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                res = res + 4;
                i = i + 2;

            } else if (ch == 'I' && i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                res = res + 9;
                i = i + 2;

            } else if (ch == 'X' && i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                res = res + 40;
                i = i + 2;

            } else if (ch == 'X' && i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                res = res + 90;
                i = i + 2;

            } else if (ch == 'C' && i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                res = res + 400;
                i = i + 2;

            } else if (ch == 'C' && i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                res = res + 900;
                i = i + 2;

            } else {
                res = res + map.get(ch);
                i = i + 1;
            }
        }

        return res;

    }

}
