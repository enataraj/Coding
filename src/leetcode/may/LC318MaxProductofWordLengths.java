package leetcode.may;

import java.util.ArrayList;
import java.util.List;

public class LC318MaxProductofWordLengths {

    public int maxProduct(String[] words) {
        int maxLength = 0;
        List<boolean[]> wordList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {

            boolean[] charArray = new boolean[26];
            for (char ch : words[i].toCharArray()) {
                charArray[ch - 'a'] = true;
            }
            wordList.add(charArray);
        }

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i+1; j < wordList.size(); j++) {
                boolean flag = false;
                for (int k = 0; k < 26; k++) {
                    if (wordList.get(i)[k] && wordList.get(j)[k]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    maxLength = Math.max(words[i].length() * (words[j].length()), maxLength);
                }
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        LC318MaxProductofWordLengths obj = new LC318MaxProductofWordLengths();
        String[] words = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
        System.out.println(obj.maxProduct(words));

    }
}
