package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonChars1002 {

    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) {
            return Collections.EMPTY_LIST;
        }

        List<String> result = new ArrayList<>();

        if (A.length == 1) {
            for (int i = 0; i < A[0].length(); i++) {
                if (A[0].charAt(i) != ' ') {
                    result.add(A[0].charAt(i) + "");
                }
            }
            return result;
        }
        String minStr = "";
        int length = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (length > A[i].length()) {
                length = A[i].length();
                minStr = A[i];
            }

        }

        Set<Character> possibleList = new HashSet<>();
        boolean flag = true;
        for (int j = 0; j < minStr.length(); j++) {
            flag = true;
            for (int i = 0; i < A.length; i++) {

                if (!A[i].contains(minStr.charAt(j) + "")) {

                    flag = false;
                    break;
                }
            }
            if (flag) {
                possibleList.add(minStr.charAt(j));
            }
        }

        for (char ch : possibleList) {
            int count = Integer.MAX_VALUE;

            for (int i = 0; i < A.length; i++) {
                int tmpCount = 0;

                for (int k = 0; k < A[i].length(); k++) {
                    if (ch == A[i].charAt(k)) {
                        tmpCount++;
                    }

                }
                count = Math.min(count, tmpCount);
            }

            for (int i = 0; i < count; i++) {
                result.add(ch + "");
            }

        }

        return result;

    }

    public List<String> commonCharsDiff(String[] A) {
        int[] last = count(A[0]);
        for (int i = 1; i < A.length; i++) {
            last = intersection(last, count(A[i]));
        }
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a';
                a += i;
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }

    int[] intersection(int[] a, int[] b) {
        int[] t = new int[26];
        for (int i = 0; i < 26; i++) {
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }

    int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray())
            t[c - 'a']++;
        return t;
    }

    public List<String> commonCharsDiff2(String[] A) {
        List<String> ans = new ArrayList<>();
        // Common characters dictionary
        int[] dict = new int[26];
        for (int j = 0; j < A[0].length(); j++) {
            dict[A[0].charAt(j) - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            // Dictionary of the current word
            int[] curr = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                curr[A[i].charAt(j) - 'a']++;
            }
            // Update the common dictionary
            for (int j = 0; j < 26; j++) {
                if (curr[j] < dict[j])
                    dict[j] = curr[j];
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < dict[i]; j++) {
                ans.add(Character.toString((char) ('a' + i)));
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        CommonChars1002 obj = new CommonChars1002();
        String[] A = { "belllnnnnnnnna", "llabenn", "rollernn" };
        System.out.println(obj.commonChars(A));

    }

}
