package leetcode.aug;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {

    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        String[] words = S.split(" ");

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        StringBuilder addA = new StringBuilder();
        StringBuilder resultBuffer = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            addA.append('a');
            StringBuilder sb = new StringBuilder(words[i]);
            char ch = sb.charAt(0);
            if (vowels.contains(ch)) {
                sb.append("ma");
            } else {
                if (sb.length() == 1) {
                    sb.append("ma");
                } else {
                    sb.append(ch).append("ma");
                    sb.deleteCharAt(0);

                }
            }

            sb.append(addA);

            resultBuffer.append(sb);
            if (i != words.length - 1) {
                resultBuffer.append(' ');
            }
        }

        return resultBuffer.toString();

    }

    public String toGoatLatinOpt(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        int aCount = 1;
        for (String w : split) {
            if (isVowel(w.charAt(0))) {
                sb.append(w);
            } else {
                sb.append(w.substring(1, w.length()));
                sb.append(w.charAt(0));
            }
            sb.append("ma");
            for (int i = 0; i < aCount; i++) {
                sb.append("a");
            }
            if (aCount != split.length) {
                sb.append(" ");
            }
            aCount++;
        }
        return sb.toString();
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U';
    }

    public static void main(String[] args) {

        GoatLatin obj = new GoatLatin();
        String S = "I speak Goat Latin";
        System.out.println(obj.toGoatLatin(S));

    }

}
