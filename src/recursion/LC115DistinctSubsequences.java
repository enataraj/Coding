package recursion;

import java.util.Arrays;

public class LC115DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        dfsHelper(s, t, 0, 0, memo);
        return memo[0][0];

    }

    private int dfsHelper(String s, String t, int i, int j, int[][] memo) {
        if (i >= s.length() || j >= t.length()) {
            if (j == t.length()) {
                return 1;
            }
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int result = 0;
        if (s.charAt(i) == t.charAt(j)) {
            result += dfsHelper(s, t, i + 1, j + 1, memo);
        }
        result += dfsHelper(s, t, i + 1, j, memo);
        memo[i][j] = result;
        return memo[i][j];

    }

    public static void main(String[] args) {
        //  String s = "rabbbit";
        //String t = "rabbit";
        String s = "babgbag";
        String t = "bag";
        LC115DistinctSubsequences obj = new LC115DistinctSubsequences();
        System.out.println(obj.numDistinct(s, t));
    }

}
