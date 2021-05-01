package leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class LC1763LongestNiceString {

    public String longestNiceSubstring(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            int unmatch = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);

                if (!set.contains(c) && !set.contains((char) (c ^ 32)))
                    unmatch++;
                else if (set.contains((char) (c ^ 32)) && !set.contains(c))
                    unmatch--;

                set.add(c);

                if (unmatch == 0 && j - i + 1 > res.length())
                    res = s.substring(i, j + 1);
            }
        }
        return res;
    }

}
