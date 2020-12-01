package leetcode.nov;

public class ConsecutiveChars {

    public int maxPower(String s) {
        if (s == null || s.length() == 0) {
            return 0;

        }
        int tmpCount = 1;
        int res = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                tmpCount++;
                res = Math.max(res, tmpCount);
            } else {
                tmpCount = 1;
            }
        }
        return res;
    }

    public int maxPowerSliding(String s) {
        // sliding window (2 pointers)
        int max = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                count = 0;
                i = j;
            } else {
                j++;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        ConsecutiveChars obj = new ConsecutiveChars();
        // String str = "abbcccddddeeeeedcba";
        String str = "cqqqqqaaaaaaaa";
        System.out.println(obj.maxPower(str));

    }

}
