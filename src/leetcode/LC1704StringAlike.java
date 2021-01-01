package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1704StringAlike {

    public boolean halvesAreAlike(String s) {

        int len = s.length();

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
        int count = 0;

        for (int i = 0; i < len / 2; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(len / 2 + i);
            if (vowels.contains(ch1)) {
                count++;
            }
            if (vowels.contains(ch2)) {
                count--;
            }
        }

        if (count == 0)
            return true;
        return false;

    }

    public boolean halvesAreAlikeSol(String s) {
        String vowels = "aeiou";
        boolean[] map = new boolean[128];
        for (int i = 0; i < vowels.length(); i++) {
            map[vowels.charAt(i)] = true;
            map[Character.toUpperCase(vowels.charAt(i))] = true;
        }
        return get(s, 0, s.length() / 2 - 1, map) == get(s, s.length() / 2, s.length() - 1, map);

    }

    private int get(String s, int lo, int hi, boolean[] map) {
        int r = 0;
        for (int i = lo; i <= hi; i++) {
            if (map[s.charAt(i)])
                r++;
        }
        return r;
    }

    public boolean halvesAreAlikeNotReq(String s) {
        int len = s.length();
        s = s.toLowerCase();
        Set<Character> vowels = new HashSet<>();
        Map<Character, Integer> freqMap1 = new HashMap<>();
        Map<Character, Integer> freqMap2 = new HashMap<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for (int i = 0; i < len / 2; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(len / 2 + i);

            if (freqMap1.containsKey(ch1)) {
                freqMap1.put(ch1, freqMap1.get(ch1) + 1);
            } else {
                freqMap1.put(ch1, 1);
            }

            if (freqMap2.containsKey(ch2)) {
                freqMap2.put(ch2, freqMap1.get(ch2) + 1);
            } else {
                freqMap2.put(ch2, 1);
            }

        }
        System.out.println(freqMap1);
        System.out.println(freqMap2);

        for (char ch : vowels) {
            if (freqMap1.containsKey(ch)) {
                if (freqMap2.containsKey(ch)) {
                    if (freqMap1.get(ch) != freqMap2.get(ch)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            else if (freqMap2.containsKey(ch)) {
                if (freqMap1.containsKey(ch)) {
                    if (freqMap1.get(ch) != freqMap2.get(ch)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        LC1704StringAlike obj = new LC1704StringAlike();
        String s = "AbCdEfGh";
        System.out.println(obj.halvesAreAlike(s));

    }

}
