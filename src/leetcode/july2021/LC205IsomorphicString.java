package leetcode.july2021;

import java.util.HashMap;
import java.util.Map;

public class LC205IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> scharMap = new HashMap<>();
        Map<Character, Character> tcharMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char s_ch = s.charAt(i);
            char t_ch = t.charAt(i);
            if (scharMap.containsKey(s_ch) && t_ch != scharMap.get(s_ch)) {

                return false;

            }
            if (tcharMap.containsKey(t_ch) && s_ch != scharMap.get(t_ch)) {
                return false;
            }
            scharMap.put(s_ch, t_ch);
            tcharMap.put(t_ch, s_ch);
        }
        return true;
    }

    /*
     *  "badc"
        "baba"
     */
}
