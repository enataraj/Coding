package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class LC1684NumberOfConsistString {

    public int countConsistentStrings(String allowed, String[] words) {
        int cnt = 0;
        Set<Character> allowedSet = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            allowedSet.add(allowed.charAt(i));
        }

        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!allowedSet.contains(word.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }

        return cnt;

    }

    public int countConsistentStringsArray(String allowed, String[] words) {
        int cnt = 0;
        boolean[] allowedCharArray = new boolean[26];
        for (char ch : allowed.toCharArray()) {
            allowedCharArray[ch - 'a'] = true;
        }

        for (String word : words) {
            boolean flag = true;
            for (char ch : word.toCharArray()) {
                if (!allowedCharArray[ch - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }

        return cnt;

    }

    public int countConsistentStringsStringReplacement(String allowed, String[] words) {
        int cnt = 0;

        for (String word : words) {

            for (char ch : allowed.toCharArray()) {
                word = word.replaceAll("" + ch, "");
                if (word.length() == 0) {
                    cnt++;
                    break;
                }

            }

        }
        return cnt;

    }

    public int countConsistentStringsSol(String allowed, String[] words) {
        boolean[] allowedArr = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            int index = allowed.charAt(i) - 'a';
            if (!allowedArr[index]) {
                allowedArr[index] = true;
            }
        }
        int count = 0;
        for (String find : words) {
            if (search(find, allowedArr)) {
                count++;
            }
        }
        return count;
    }

    private boolean search(String word, boolean[] allowedArr) {
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (!allowedArr[index]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC1684NumberOfConsistString obj = new LC1684NumberOfConsistString();

        String[] words = { "ad", "bd", "aaab", "baa", "badab" };
        String allowed = "ab";
        System.out.println(obj.countConsistentStrings(allowed, words));
    }

}
