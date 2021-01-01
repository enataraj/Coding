package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class LC1160WordsFormedFromChars {

    public int countCharacters(String[] words, String chars) {
        int count = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (char ch : chars.toCharArray()) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        for (String word : words) {
            Map<Character, Integer> wordCharMap = new HashMap<>();
            for (char ch : word.toCharArray()) {
                if (wordCharMap.containsKey(ch)) {
                    wordCharMap.put(ch, wordCharMap.get(ch) + 1);
                } else {
                    wordCharMap.put(ch, 1);
                }
            }
            boolean flag = true;

            for (char key : wordCharMap.keySet()) {
                if (!charMap.containsKey(key)) {
                    flag = false;
                    break;
                }
                if (wordCharMap.get(key) > charMap.get(key)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count += word.length();
            }

        }
        return count;
    }

    public static void main(String[] args) {
        LC1160WordsFormedFromChars obj = new LC1160WordsFormedFromChars();
        String[] words = { "cat", "bt", "hat", "tree" };
        String chars = "atach";
        System.out.println(obj.countCharacters(words, chars));

    }

}
