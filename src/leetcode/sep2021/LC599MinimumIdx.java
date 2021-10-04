package leetcode.sep2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC599MinimumIdx {

    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Set<String>> tmpMap = new HashMap<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list1.length; i++) {
            if (map.get(list2[i]) != null) {
                int key = map.get(list2[i]) + i;
                min = Math.min(min, key);
                Set<String> set = tmpMap.getOrDefault(key, new HashSet<>());
                set.add(list2[i]);
                tmpMap.put(key, set);
            }
        }
        String[] result = new String[tmpMap.get(min).size()];
        int idx = 0;
        for (String str : tmpMap.get(min)) {
            result[idx++] = str;
        }
        return result;
    }
}
