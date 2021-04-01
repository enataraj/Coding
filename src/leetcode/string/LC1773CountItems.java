package leetcode.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1773CountItems {

    public int countMatchesSol(List<List<String>> items, String ruleKey, String ruleValue) {
        int cnt = 0;
        int ind = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        for (List<String> list : items) {
            if (list.get(ind).equals(ruleValue))
                cnt++;
        }
        return cnt;
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        Map<String, Integer> typeMap = new HashMap<>();
        Map<String, Integer> colorMap = new HashMap<>();
        Map<String, Integer> nameMap = new HashMap<>();

        for (List<String> item : items) {
            String type = item.get(0);
            String color = item.get(1);
            String name = item.get(2);
            if (typeMap.containsKey(type)) {
                typeMap.put(type, typeMap.get(type) + 1);
            } else {
                typeMap.put(type, 1);
            }
            if (colorMap.containsKey(color)) {
                colorMap.put(color, colorMap.get(color) + 1);
            } else {
                colorMap.put(color, 1);
            }
            if (nameMap.containsKey(name)) {
                nameMap.put(name, nameMap.get(name) + 1);
            } else {
                nameMap.put(name, 1);
            }

        }
        if (ruleKey.equals("type")) {
            return typeMap.getOrDefault(ruleValue, 0);
        }
        if (ruleKey.equals("name")) {
            return nameMap.getOrDefault(ruleValue, 0);
        }
        return colorMap.getOrDefault(ruleValue, 0);

    }

    public static void main(String[] args) {
        LC1773CountItems obj = new LC1773CountItems();
    }

}
