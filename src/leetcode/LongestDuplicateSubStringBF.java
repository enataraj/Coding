package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestDuplicateSubStringBF {

    public static String longestDupSubstring(String S) {
        if (S == null || S.length() <= 1) {
            return "";
        }
        String matchedString = "";
        for (int i = S.length() - 1; i >= 0; i--) {
            if (matchedString == "") {
                matchedString = findMatchString(S, i);
            } else {
                return matchedString;
            }
        }

        return matchedString;

    }

    private static String findMatchString(String str, int len) {
        Set<String> strSet = new HashSet<>();
        String subStr = "";

        for (int i = 1; i < str.length() - len + 1; i++) {
            subStr = str.substring(i - 1, len + i);

            if (strSet.contains(subStr)) {
                return subStr;
            }
            strSet.add(subStr);
        }
        return "";

    }

    public static void main(String[] args) {
        String S = "banana";
        String maxDup = longestDupSubstring(S);
        System.out.println("Max Duplicate String : " + maxDup);

    }
}
