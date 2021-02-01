package leetcode.jan;

import java.util.Arrays;

public class LC1657DetermineTwoStrinsAreClose {
    public boolean closeStringsNotOptimized(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        if (word1.equals(word2))
            return true;

        int[] word1Array = new int[26];
        int[] word2Array = new int[26];

        // Build Frequency of char
        for (int i = 0; i < word1.length(); i++) {
            word1Array[word1.charAt(i) - 'a']++;
            word2Array[word2.charAt(i) - 'a']++;
        }

        // Check for non existing char in any one of the array
        for (int i = 0; i < 26; i++) {
            if (word1Array[i] == 0 && word2Array[i] != 0) {
                return false;
            }
        }
        
        // Check for all freq are equal
        Arrays.sort(word1Array);
        Arrays.sort(word2Array);

        for (int i = 0; i < 26; i++) {
            if (word1Array[i] != word2Array[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        if (word1.equals(word2))
            return true;

        int[] word1Array = new int[26];
        int[] word2Array = new int[26];

        // Build Frequency of char
        for (int i = 0; i < word1.length(); i++) {
            int idx = word1.charAt(i) - 'a';
            word1Array[idx]++;
        }
        for (int i = 0; i < word2.length(); i++) {
            int idx = word2.charAt(i) - 'a';
            if (word1Array[idx] != 0) {
                word2Array[idx]++;
            } else { // Char is not exist in first word
                return false;
            }
        }

        // All char frequency is same, we can swap and arrive word2.
        boolean operation1 = true;
        for (int i = 0; i < 26; i++) {
            if (word1Array[i] != word2Array[i]) {
                operation1 = false;
            } else {
                word1Array[i] = 0;
                word2Array[i] = 0;
            }
        }

        if (operation1) {
            return true;
        }

        for (int i = 0; i < 26; i++) {
            boolean operation2 = true;
            for (int j = 0; j < 26; j++) {
                if (word1Array[i] != 0 && word1Array[i] == word2Array[j]) {
                    word1Array[i] = 0;
                    word2Array[j] = 0;
                    operation2 = false;
                }
            }
            if (word1Array[i] != 0 && operation2) {
                return false;
            }
        }

        // System.out.println(Arrays.toString(word1Array));
        // System.out.println(Arrays.toString(word2Array));

        return true;
    }

    public static void main(String[] args) {
        LC1657DetermineTwoStrinsAreClose obj = new LC1657DetermineTwoStrinsAreClose();
        String word1 = "cabbba";
        String word2 = "abbccc";

        // String word1 = "cabbba";
        // String word2 = "aabbss";

        // String word1 = "abca";
        // String word2 = "baca";
        System.out.println(obj.closeStrings(word1, word2));

    }
}
