package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestDupSubstringWithBinarySearch {

    public static String longestDupSubstring(String S) {
        if (S == null || S.length() <= 1) {
            return "";
        }
        String matchedString = "";
        int low = 0;
        int high = S.length();
        int mid;
        while (low <= high) {
            System.out.println("********** " + matchedString);
            mid = low + (high - low) / 2;
            String temp = findMatchString(S, mid);
            if (temp == "") {
                high = mid - 1;

            } else {
                matchedString = temp;
                low = mid + 1;
            }

        }

        return matchedString;

    }

    private static String findMatchString(String str, int len) {
        Set<String> strSet = new HashSet<>();
        String subStr = "";
        System.out.println("length : " + len);
        for (int i = 0; i <= str.length() - len; i++) {
            subStr = str.substring(i, len + i);
            System.out.println("Sub String " + subStr);
            if (strSet.contains(subStr)) {
                return subStr;
            }
            strSet.add(subStr);
        }
        return "";
    }

    public static void main(String[] args) {
        String S = "baanaanaa";
        // String S = "baa";
        String maxDup = longestDupSubstring(S);
//        String maxDup = findMatchString(S,5);
        System.out.println("Max Duplicate String : " + maxDup);
        

    }

}
