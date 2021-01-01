package leetcode.dec;

import java.util.Arrays;

public class LC91DecodeWays {

    int result = 0;

    public int numDecodingsTLE(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        dfsHelpher(s);
        return result;

    }

    private void dfsHelpher(String s) {
        if (s.isEmpty()) {
            result += 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            if (left.charAt(0) != '0' && left.length() <= 2 && Integer.parseInt(left) <= 26
                    && Integer.parseInt(left) > 0) {
                dfsHelpher(right);

            }

        }
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return dfsHelpher(s, 0, cache);

    }

    private int dfsHelpher(String s, int idx, int[] cache) {

        if (idx >= s.length()) {
            return 1;
        }

        if (s.charAt(idx) == '0') {
            return 0;
        }

        if (idx >= s.length() - 1) {
            return 1;
        }

        if (cache[idx] != -1) {
            return cache[idx];
        }

        int res = 0;
        res = dfsHelpher(s, idx + 1, cache);

        if (Integer.parseInt(s.substring(idx, idx + 2)) <= 26) {
            res += dfsHelpher(s, idx + 2, cache);
        }
        cache[idx] = res;
        return res;

    }

    public int numDecodings_Alt(String s) {
        int[] numberOfDecodings = new int[s.length()];
        int currentNum, nextNum;

        currentNum = Integer.parseInt(s.charAt(s.length() - 1) + "");
        if (currentNum != 0)
            numberOfDecodings[s.length() - 1] = 1;
        else
            numberOfDecodings[s.length() - 1] = 0;

        for (int i = s.length() - 2; i >= 0; i--) {
            nextNum = currentNum;
            currentNum = Integer.parseInt(s.charAt(i) + "");

            if (currentNum == 0)
                numberOfDecodings[i] = 0;
            else {
                if (currentNum >= 3 || (currentNum == 2 && nextNum >= 7))
                    numberOfDecodings[i] = numberOfDecodings[i + 1];

                else if (i + 2 <= s.length() - 1 && ((currentNum == 1 || currentNum == 2) && nextNum == 0))
                    numberOfDecodings[i] = numberOfDecodings[i + 2];

                else {
                    if (i + 2 <= s.length() - 1)
                        numberOfDecodings[i] = numberOfDecodings[i + 1] + numberOfDecodings[i + 2];
                    else {
                        if ((currentNum == 1 || currentNum == 2) && nextNum == 0)
                            numberOfDecodings[i] = 1;
                        else
                            numberOfDecodings[i] = 2;
                    }
                }
            }
        }

        return numberOfDecodings[0];

    }

    public int numDecodingsSol(String s) {
        int n = s.length();
        int dp1 = 1;
        int dp2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            int dp = s.charAt(i) == '0' ? 0 : dp1;
            if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                dp += dp2;
            }
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }

    public static void main(String[] args) {
        LC91DecodeWays obj = new LC91DecodeWays();
        String s = "11";
        System.out.println(obj.numDecodings(s));

    }

}
