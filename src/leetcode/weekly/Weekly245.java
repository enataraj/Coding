package leetcode.weekly;

import java.util.HashMap;
import java.util.Map;

public class Weekly245 {

    public boolean makeEqual(String[] words) {
        Map<Character, Integer> fqMap = new HashMap<>();
        for (String str : words) {
            for (char ch : str.toCharArray()) {
                fqMap.put(ch, fqMap.getOrDefault(ch, 0) + 1);

            }
        }

        for (int val : fqMap.values()) {
            if (val % words.length != 0) {
                return false;
            }
        }
        return true;
    }

}
