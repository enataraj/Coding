package leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class LC345ReverseVowels {
    public String reverseVowels(String s) {

        if (s == null || s.length() == 0)
            return s;
        Set<Character> vowelsSet = new HashSet<>();
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('u');

        char[] charArray = s.toCharArray();

        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !vowelsSet.contains(Character.toLowerCase(charArray[i]))) {
                i++;

            }
            System.out.println("i = " + i + "  j = " + j);

            while (i < j && !vowelsSet.contains(Character.toLowerCase(charArray[j]))) {
                j--;

            }

            if (i < j) {
                char tmp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = tmp;

            }
            i++;
            j--;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        LC345ReverseVowels obj = new LC345ReverseVowels();
        System.out.println(obj.reverseVowels("hello"));
    }

}
