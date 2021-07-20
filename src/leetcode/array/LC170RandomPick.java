package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class LC170RandomPick {

    class Solution {
        Set<Integer> blacklistSet = new HashSet<>();
        List<Integer> allowedList = new ArrayList<>();
        int limit;

        public Solution(int n, int[] blacklist) {
            limit = n;
            for (int num : blacklist) {
                blacklistSet.add(num);
            }
            if (blacklistSet.size() > limit / 2) {
                for (int i = 0; i < n; i++) {
                    if (!blacklistSet.contains(i))
                        allowedList.add(i);
                }
            }

        }

        public int pick() {
            int size = allowedList.size();
            if (size > 0) {
                int randomNum = new Random().nextInt(size);
                return allowedList.get(randomNum);
            }

            while (true) {
                int randomNum = new Random().nextInt(limit);
                if (blacklistSet.contains(randomNum)) {
                    continue;
                }
                return randomNum;
            }

        }

    }
    
    
    class Solution1 {
        private int m;
        private Map<Integer, Integer> map = new HashMap<>();
        private Random random = new Random();

        public Solution1(int n, int[] list) {
            int len = list.length;
            m = n - len;
            boolean[] used = new boolean[len];
            for (int num : list) {
                if (num >= m) {
                    used[num - m] = true;
                }
            }
            int i = 0;
            for (int num : list) {
                if (num < m) {
                    while (used[i]) i++;
                    map.put(num, m + i);
                    i++;
                }
            }
        }
        
        public int pick() {
            int rand = random.nextInt(m);
            return map.getOrDefault(rand, rand);
        }
    }

}
