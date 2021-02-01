package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC1436DestinationPath {

    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < paths.size(); i++) {
            List<String> list = paths.get(i);
            map.put(list.get(0), list.get(1));
        }
        String tmp = paths.get(0).get(0);
        while (map.containsKey(tmp)) {
            tmp = map.get(tmp);
        }
        return tmp;
    }

    public String destCitySol(List<List<String>> paths) {

        Set<String> source = new HashSet<>();
        for (int i = 0; i < paths.size(); i++) {
            List<String> innerList = paths.get(i);
            source.add(innerList.get(0));
        }

        for (int i = 0; i < paths.size(); i++) {
            List<String> innerList = paths.get(i);
            if (source.add(innerList.get(1))) {
                return innerList.get(1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        LC1436DestinationPath obj = new LC1436DestinationPath();
        List<List<String>> paths = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("B");
        list.add("C");
        paths.add(list);
        list = new ArrayList<>();
        list.add("D");
        list.add("B");
        paths.add(list);
        list = new ArrayList<>();
        list.add("C");
        list.add("A");
        paths.add(list);

        System.out.println(obj.destCity(paths));
    }

}
