package leetcode.dec;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC1010SongPairby60 {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;

        if (time == null || time.length == 0) {
            return 0;
        }
        Set<Integer> pair = new HashSet<>();
        pair.add(0);
        for (int i = 0; i < time.length; i++) {
            time[i] = time[i] % 60;
            if (pair.contains((60 - time[i])%60)) {

                res += 1;
            } else {

                pair.add(time[i]);
            }

        }

        return res;

    }

    public int numPairsDivisibleBy60Parin(int[] time) {
        int n = time.length, count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            time[i] %= 60;
            if (map.containsKey((60 - time[i]) % 60)) {
                count += map.get((60 - time[i]) % 60);
            }
            map.put(time[i], map.getOrDefault(time[i], 0) + 1);
            System.out.println();
        }
        return count;
    }

    public int numPairsDivisibleBy60Sol(int[] time) {
        int[] array = new int[60];
        for (int t : time) {
            array[t % 60] += 1;
        }

        int res = (array[0] * (array[0] - 1) / 2) + (array[30] * (array[30] - 1) / 2);

        for (int i = 1; i < 30; ++i) {
            res += array[i] * array[60 - i];
        }

        return res;
    }

    public static void main(String[] args) {
        LC1010SongPairby60 obj = new LC1010SongPairby60();
        //int[] time = { 30, 20, 150, 100, 40 };
         int[] time = { 60, 60, 60 };
        // int[] time = { 418, 204, 77, 278, 239, 457, 284, 263, 372, 279, 476, 416,
        // 360, 18 };
        System.out.println(obj.numPairsDivisibleBy60(time));
        System.out.println(obj.numPairsDivisibleBy60Parin(time));

    }

}
