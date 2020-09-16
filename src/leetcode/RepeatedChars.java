package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedChars {

    public List<Character> findDuplicate(String[] input) {
        if (input == null || input.length == 0) {
            return Collections.EMPTY_LIST;

        }

        Map<Character, Integer> resultMap = new HashMap<>();

        int idx = 0;

        for (String str : input) {
            for (char c : str.toCharArray()) {
                if (resultMap.containsKey(c)) {

                    resultMap.put(c, resultMap.get(c) + 1);
                } else {

                    resultMap.put(c, 1);
                }
            }
            idx++;
        }

        List<Character> result = new ArrayList<>();

        for (char c : resultMap.keySet()) {
            int val = resultMap.get(c);
            if (val % input.length == 0) {
                int repeat = val / input.length;
                for (int i = 0; i < repeat; i++) {
                    result.add(c);
                }
            }

        }

        return result;

    }

    public static void main(String[] args) {
        RepeatedChars obj = new RepeatedChars();
        String[] input = { "bella", "label", "roller" };
        System.out.println(obj.findDuplicate(input));

    }

}
