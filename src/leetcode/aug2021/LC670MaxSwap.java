package leetcode.aug2021;

import java.util.HashMap;
import java.util.Map;

public class LC670MaxSwap {
    public int maximumSwap(int num) {
        char[] numstr = String.valueOf(num).toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < numstr.length; i++) {
            map.put(numstr[i], i);
        }

        for (int i = 0; i < numstr.length; i++) {
            char curChar = numstr[i];
            for (char c = '9'; c > curChar; c--) {
                if (map.containsKey(c) && map.get(c) > i) {
                    numstr[i] = numstr[map.get(i)];
                    numstr[map.get(i)] = curChar;
                    return Integer.parseInt(new String(numstr));
                }
            }
        }
        return Integer.parseInt(new String(numstr));
    }

}
