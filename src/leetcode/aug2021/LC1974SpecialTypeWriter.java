package leetcode.aug2021;

public class LC1974SpecialTypeWriter {
    public int minTimeToType(String word) {
        int result = 0;
        int distance = 0;
        int curChar = 0;
        int preChar = 0;
        for (char ch : word.toCharArray()) {
            curChar = ch - 'a';
            distance = Math.abs(preChar - curChar);
            distance = Math.min(distance, 26 - distance);
            result += distance + 1;
            preChar = curChar;

        }
        return result;
    }

    class Solution {
        public int minTimeToType(String word) {
            int minTime = 0;
            char cur = 'a';

            for (char c : word.toCharArray()) {
                int ctr = 0, clc = 0;
                minTime += 1 + Math.min(Math.abs(cur - c), Math.min(c - cur + 26, cur - c + 26));
                cur = c;
            }

            return minTime;
        }
    }
}
