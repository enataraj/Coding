package leetcode.sep2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC748ShortestCompleting {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        Map<Character, Integer> lp_freMap = new HashMap<>();
        for (char ch : licensePlate.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                char low = Character.toLowerCase(ch);
                lp_freMap.put(low, lp_freMap.getOrDefault(low, 0) + 1);
            }
        }

        for (String word : words) {
            Map<Character, Integer> word_freMap = new HashMap<>();
            for (char ch : word.toCharArray()) {
                if (Character.isAlphabetic(ch)) {
                    char low = Character.toLowerCase(ch);
                    word_freMap.put(low, word_freMap.getOrDefault(low, 0) + 1);
                }
            }
            if (isExist(lp_freMap, word_freMap)) {
                return word;
            }

        }
        return "";
    }

    private boolean isExist(Map<Character, Integer> lp_freMap, Map<Character, Integer> word_freMap) {

        for (char key : lp_freMap.keySet()) {
            if (!word_freMap.containsKey(key)) {
                return false;
            }
            if (lp_freMap.get(key) > word_freMap.get(key)) {
                return false;
            }
        }
        return true;

    }

}
