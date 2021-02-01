package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class LC1711CountGoodMeals {

    public int countPairsTLE(int[] deliciousness) {
        int cnt = 0;

        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                int sum = deliciousness[i] + deliciousness[j];
                if (sum != 0 && (sum & (sum - 1)) == 0) {
                    cnt = cnt + 1;
                }
            }
        }
        return cnt;
    }
    
    int mod = 1000000007;
    public int countPairs(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        long res = 0;
        for (int num : arr) {
            int power = 1;
            for (int i = 0; i < 22; i++) {
                if (map.containsKey(power - num)) {
                    res += map.get(power - num);
                    res %= mod;
                }
                power *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) res;
    }

    public static void main(String[] args) {
        LC1711CountGoodMeals obj = new LC1711CountGoodMeals();
        // int[] deliciousness = { 1, 1, 1, 3, 3, 3, 7 };

        int[] deliciousness = { 2160, 1936, 3, 29, 27, 5, 2503, 1593, 2, 0, 16, 0, 3860, 28908, 6, 2, 15, 49, 6246,
                1946, 23, 105, 7996, 196, 0, 2, 55, 457, 5, 3, 924, 7268, 16, 48, 4, 0, 12, 116, 2628, 1468 };
        System.out.println(obj.countPairs(deliciousness));
    }

}
