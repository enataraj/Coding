package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC1408StringMatchingInArray {

    public List<String> stringMatching(String[] words) {
        if (words == null || words.length == 1) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(words, (a, b) -> a.length()-b.length());
        System.out.println(Arrays.toString(words));
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC1408StringMatchingInArray obj = new LC1408StringMatchingInArray();
    }
}
