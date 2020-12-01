package leetcode.nov;

import java.util.HashSet;
import java.util.Set;

public class UniqueMoreCodeWord {

    public int uniqueMorseRepresentations(String[] words) {

        if (words == null || words.length == 0) {
            return 0;
        }
        String[] code = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

        Set<String> resultSet = new HashSet<>();
        for (String word : words) {
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                int ch = word.charAt(i) - 'a';
                str.append(code[ch]);
            }
            resultSet.add(str.toString());

        }

        return resultSet.size();
    }

    public int uniqueMorseRepresentationsBuilder(String[] words) {
        HashSet<String> set = new HashSet<>();

        String[] MORSE = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--.." };

        for (String word : words) {
            StringBuilder output = new StringBuilder();
            for (char c : word.toCharArray()) {
                output.append(MORSE[c - 'a']);
            }
            set.add(output.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        UniqueMoreCodeWord obj = new UniqueMoreCodeWord();
        String[] words = { "gin", "zen", "gig", "msg" };
        System.out.println(obj.uniqueMorseRepresentations(words));

    }

}
