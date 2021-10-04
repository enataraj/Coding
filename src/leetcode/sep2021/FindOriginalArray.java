package leetcode.sep2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOriginalArray {

    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[] {};
        }
        Map<Integer, Integer> map = new HashMap<>();
        int length = changed.length;
        for (int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        if (map.containsKey(0) && map.get(0)%2==1) {
            return new int[] {};
        }
        int mid = (length / 2);
        Arrays.sort(changed);
        int[] result = new int[mid];
        int cnt = 0;
        int idx = 0;
        for (int num : changed) {

            if (map.containsKey(num) && map.containsKey(num * 2)) {
                int val = map.get(num * 2);
                if (val == 1) {
                    map.remove(num * 2);
                } else {
                    map.put(num * 2, val - 1);
                }

                val = map.get(num);
                if (val == 1) {
                    map.remove(num);
                } else {
                    map.put(num, val - 1);
                }
                result[idx++] = num;
                cnt++;
            }
        }
        if (cnt == mid) {
            return result;
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        FindOriginalArray obj = new FindOriginalArray();
        int[] changed = { 1, 2, 0,0 };
        System.out.println(Arrays.toString(obj.findOriginalArray(changed)));
    }
}
