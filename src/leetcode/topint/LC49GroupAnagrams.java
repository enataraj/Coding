package leetcode.topint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] sortedArray = str.toCharArray();
            Arrays.sort(sortedArray);
            String sortedString = new String(sortedArray);
            if (map.containsKey(sortedString)) {
                List<String> list = map.get(sortedString);
                list.add(str);
                map.put(sortedString, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedString, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;

    }

    public List<List<String>> groupAnagramsSol2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] charCnt = new int[26];
            for (int i = 0; i < str.length(); i++) {
                charCnt[str.charAt(i) - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            key.append("#");
            for (int i = 0; i < 26; i++) {
                key.append(charCnt[i]);
                key.append("#");
            }
            String keystr = key.toString();
            if (map.containsKey(keystr)) {
                List<String> list = map.get(keystr);
                list.add(str);
                map.put(keystr, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(keystr, list);
            }

        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;

    }

    public List<List<String>> groupAnagramsSol3(String[] strs) {
        Map<Integer, List<String>> anagrams = new HashMap<>();

        for (String s : strs) {
            int[] temp = new int[26];
            for (char c : s.toCharArray()) {
                temp[c - 'a']++;
            }

            Integer key = Arrays.hashCode(temp);
            List<String> values = anagrams.get(key);
            if (values == null) {
                values = new ArrayList<>();
                anagrams.put(key, values);
            }
            values.add(s);
        }
        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        LC49GroupAnagrams obj = new LC49GroupAnagrams();
    }

}
