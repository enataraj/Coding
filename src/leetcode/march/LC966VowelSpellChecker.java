package leetcode.march;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LC966VowelSpellChecker {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> words = new HashSet<>();
        HashMap<String, String> caseInsensitive = new HashMap<>();
        HashMap<String, String> consonant = new HashMap<>();

        for (String word : wordlist) {
            words.add(word);
            caseInsensitive.putIfAbsent(word.toLowerCase(), word);
            consonant.putIfAbsent(devowel(word.toLowerCase()), word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (words.contains(query)) {
                result[i] = query;
            } else if (caseInsensitive.containsKey(query.toLowerCase())) {
                result[i] = caseInsensitive.get(query.toLowerCase());
            } else if (consonant.containsKey(devowel(query.toLowerCase()))) {
                result[i] = consonant.get(devowel(query.toLowerCase()));
            } else {
                result[i] = "";
            }
        }
        return result;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder("");
        for (char ch : word.toCharArray()) {
            sb.append(vowel(ch) ? "*" : ch);
        }
        return sb.toString();
    }

    private boolean vowel(char ch) {
        if (ch == 'a' || ch == 'A' || ch == 'i' || ch == 'I' || ch == 'e' || ch == 'E' || ch == 'o' || ch == 'O'
                || ch == 'u' || ch == 'U')
            return true;
        return false;
    }

    public String[] spellcheckerNW(String[] wordlist, String[] queries) {
        Map<String, Set<String>> wordListMap = new HashMap<>();

        for (String str : wordlist) {
            Set<String> set;
            String lowerCase = str.toLowerCase();
            if (wordListMap.containsKey(lowerCase)) {
                set = wordListMap.get(lowerCase);
                set.add(str);
                wordListMap.put(lowerCase, set);
            } else {
                set = new LinkedHashSet<>();
                set.add(str);
                wordListMap.put(lowerCase, set);
            }
        }

        String[] result = new String[queries.length];
        Arrays.fill(result, "");
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        int i = 0;
        for (String query : queries) {
            String queryLowerCase = query.toLowerCase();
            String res = isWordExist(wordListMap, query, queryLowerCase);
            if (!res.equals("")) {
                result[i] = res;
            } else {
                char[] queryCharArray = queryLowerCase.toCharArray();
                boolean flag = false;
                for (int j = 0; j < queryCharArray.length && !flag; j++) {
                    char orgchar = queryCharArray[j];
                    for (int k = 0; k < vowels.length; k++) {
                        queryCharArray[j] = vowels[k];
                        queryLowerCase = new String(queryCharArray);
                        res = isWordExist(wordListMap, query, queryLowerCase);
                        if (!res.equals("")) {
                            result[i] = res;
                            flag = true;
                            break;
                        }

                    }
                    queryCharArray[j] = orgchar;
                }
            }
            i++;
        }
        return result;
    }

    private String isWordExist(Map<String, Set<String>> wordListMap, String query, String queryLowerCase) {
        if (wordListMap.containsKey(queryLowerCase)) {
            Set<String> set = wordListMap.get(queryLowerCase);
            if (set.contains(query)) {
                return query;
            }

            for (String value : set) {
                return value;

            }
        }
        return "";
    }

    public static void main(String[] args) {
        LC966VowelSpellChecker obj = new LC966VowelSpellChecker();
        String wordlist[] = { "KiTe", "kite", "hare", "Hare" };
        String[] queries = { "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto" };
        System.out.println(Arrays.toString(obj.spellchecker(wordlist, queries)));

    }

}
