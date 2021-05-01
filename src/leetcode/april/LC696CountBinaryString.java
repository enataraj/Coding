package leetcode.april;

import java.util.ArrayList;
import java.util.List;

public class LC696CountBinaryString {

    public int countBinarySubstrings(String s) {
        int res = 0;
        int cnt = 1;
        int preCnt = 0;
        char ch = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                cnt++;
            } else {
                ch = s.charAt(i);
                if (preCnt != 0) {
                    res += Math.min(preCnt, cnt);
                }
                preCnt = cnt;
                cnt = 1;
            }
        }
        res += Math.min(preCnt, cnt);
        return res;
    }

    public int countBinarySubstringsNotOptimized(String s) {
        List<Integer> countList = new ArrayList<>();
        int cnt = 1;
        char ch = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                cnt++;
            } else {
                ch = s.charAt(i);
                countList.add(cnt);
                cnt = 1;
            }
        }
        countList.add(cnt);
        int res = 0;
        for (int i = 1; i < countList.size(); i++) {
            res = res + Math.min(countList.get(i - 1), countList.get(i));
        }
        return res;

    }

    public int countBinarySubstringsSol(String s) {
        int current = 1;
        int previous = 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                current++;
            } else {
                previous = current;
                current = 1;
            }

            if (current <= previous) {
                res++;
            }
        }

        return res;
    }

    public int countBinarySubstringsSol2(String s) {
        int l = s.length();
        if (l < 2) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int prev = 0;
        int curr = 1;
        int res = 0;

        for (int i = 1; i < l; ++i) {
            if (cs[i - 1] == cs[i]) {
                ++curr;
            } else {
                prev = curr;
                curr = 1;
            }
            if (prev >= curr) {
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC696CountBinaryString obj = new LC696CountBinaryString();
        System.out.println(obj.countBinarySubstrings("00110011"));
    }

}
