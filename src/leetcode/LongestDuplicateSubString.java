package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestDuplicateSubString {

    public static String longestDupSubstring(String S) {
        if (S == null || S.length() <= 1) {
            return "";
        }
        String matchedString = "";
        int low = 0;
        int high = S.length();
        int mid;
        while (low <= high) {
            System.out.println("------------------------");

            mid = low + (high - low) / 2;
            String temp = findMatchString(S, mid);
            System.out.println(temp);
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
        long MOD = 10000000007L;
        int BASE = 257;
        long hash = 0;
        long multi = 1;

        Set<Long> hashSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            hash = (((hash * BASE) % MOD) + str.charAt(i)) % MOD;
            multi = (multi * BASE) % MOD;
        }
        System.out.println("Lenght " + len);
        System.out.println(" String  " + " hash ");
        System.out.println(" " + str.substring(0, len) + "  " + hash);
        hashSet.add(hash);

        for (int i = 1; i <= str.length() - len; i++) {
            System.out.println(hashSet);
            int first_Index = i;
            int last_Index = len + i;
            char first_char = str.charAt(first_Index - 1);
            char last_char = str.charAt(last_Index - 1);

            String subStr = str.substring(first_Index, last_Index);
            hash = ((hash + MOD - (((first_char * multi) % MOD) * BASE)%MOD) + (last_char)) % MOD;

            System.out.println("First and Last Char " + (first_char + " " + last_char) + "  " + subStr);
            System.out.println(subStr + "  " + hash);

            if (hashSet.contains(hash)) {
                return subStr;
            }
            hashSet.add(hash);
            multi = (multi * BASE) % MOD;

        }
        return "";

    }

    public static void main(String[] args) {
        String S = "baanaanaa";
        // String S = "banrtse";
        String result = new LongestDuplicateSubString().longestDupSubstring(S);
        // String result =findMatchString(S,9);
        System.out.println(result);
    }
}
