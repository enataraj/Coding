package leetcode.may;

import java.util.Arrays;

public class LC583DeleteOperationsForTwoStrings {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return len1 + len2 - 2 * dp[len1][len2];

    }

    public int minDistanceSol2(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();

        int len1 = str1.length;
        int len2 = str2.length;
        int[] array = new int[len2 + 1];
        int[] temp = new int[len2 + 1];
        for (int i = 0; i <= len1; ++i) {
            Arrays.fill(temp, 0);
            for (int j = 0; j <= len2; ++j) {
                if (i == 0 || j == 0)
                    temp[j] = i + j;
                else if (str1[i - 1] == str2[j - 1])
                    temp[j] = array[j - 1];
                else
                    temp[j] = Math.min(array[j], temp[j - 1]) + 1;
            }
            System.arraycopy(temp, 0, array, 0, temp.length);
        }
        return array[len2];
    }
    
    public int minDistanceRec(String word1, String word2) {
        Integer[][] memo = new Integer[word1.length()][word2.length()];
        return minDistanceHelper(word1, word2, memo, 0, 0);
    }

    private int minDistanceHelper(String word1, String word2, Integer[][] memo, int i, int j) {
        if (i == word1.length())
            return word2.length() - j;
        if (j == word2.length())
            return word1.length() - i;
        if (memo[i][j] != null)
            return memo[i][j];
        if (word1.charAt(i) == word2.charAt(j))
            return minDistanceHelper(word1, word2, memo, i + 1, j + 1);
        int count1 = 1 + minDistanceHelper(word1, word2, memo, i + 1, j);
        int count2 = 1 + minDistanceHelper(word1, word2, memo, i, j + 1);
        return memo[i][j] = Math.min(count1, count2);
    }




    public static void main(String[] args) {
        LC583DeleteOperationsForTwoStrings obj = new LC583DeleteOperationsForTwoStrings();

        String word1 = "leetcode";
        String word2 = "etco";
        System.out.println(obj.minDistance(word1, word2));
    }

}
