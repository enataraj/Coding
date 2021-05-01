package leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1790StringSwapEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int cnt = 0;
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.length() == 2) {
            return s1.equals(s2);
        }
        Set<Character> set = new HashSet<>();
        for (char ch : s1.toCharArray()) {
            set.add(ch);
        }
        for (char ch : s2.toCharArray()) {
            set.remove(ch);
        }
        if (!set.isEmpty()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
            if (cnt > 2) {
                return false;
            }
        }

        return true;
    }

    public boolean areAlmostEqualSol1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2))
            return true;
        char c1 = ' ', c2 = ' ';
        int c = 0;
        boolean flag = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i))
                continue;
            else if (c == 0) {
                c1 = s1.charAt(i);
                c2 = s2.charAt(i);
                c++;
            } else if (c == 1) {
                if (s1.charAt(i) == c2 && s2.charAt(i) == c1)
                    flag = true;
                c++;
            } else {
                c++;
            }
        }
        if (flag && c == 2)
            return flag;
        return false;
    }

    public boolean areAlmostEqualSol2(String s1, String s2) {
        List<Integer> difference = new ArrayList<>();
        for (int i = 0, length = s1.length(); i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (difference.size() == 2) {
                    return false;
                }
                difference.add(i);
            }
        }
        if (difference.isEmpty()) {
            return true;
        } else if (difference.size() == 1) {
            return false;
        } else {
            int first = difference.get(0);
            int second = difference.get(1);
            return s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
        }
    }

}
