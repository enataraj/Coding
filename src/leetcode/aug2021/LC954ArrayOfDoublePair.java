package leetcode.aug2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC954ArrayOfDoublePair {

    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            int val = num * 2;

            if (map.containsKey(val)) {
                int cnt = map.get(val);
                if (cnt == 1) {
                    map.remove(val);
                } else {
                    map.put(val, cnt - 1);
                }
            } else if (num % 2 == 0) {
                val = num / 2;
                if (map.containsKey(val)) {
                    int cnt = map.get(val);
                    if (cnt == 1) {
                        map.remove(val);
                    } else {
                        map.put(val, cnt - 1);
                    }
                } else {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }

            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);

            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        LC954ArrayOfDoublePair obj = new LC954ArrayOfDoublePair();
        int[] arr = { 4, -2, 2, -4 };
        System.out.println(obj.canReorderDoubled(arr));

    }
}
