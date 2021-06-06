package leetcode.may;

import java.util.Arrays;

public class LC1423MaxPointsObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {

        int[] leftPrefixSum = new int[k + 1];
        int[] rightPrefixSum = new int[k + 1];

        leftPrefixSum[0] = 0;
        rightPrefixSum[0] = 0;
        for (int i = 0; i < k; i++) {
            leftPrefixSum[i + 1] = leftPrefixSum[i] + cardPoints[i];
            rightPrefixSum[i + 1] = rightPrefixSum[i] + cardPoints[cardPoints.length - 1 - i];
        }

        int result = 0;
        for (int i = 0; i <= k; i++) {
            result = Math.max(result, leftPrefixSum[i] + rightPrefixSum[k - i]);
        }
        return result;

    }

    public int maxScoreSol_Shree(int[] cardPoints, int k) {
        int N = cardPoints.length;
        int sum = 0;
        for (int index = 0; index < k; index++)
            sum += cardPoints[index];
        int maxScore = sum;
        for (int index = k - 1; index >= 0; index--) {
            sum = sum - cardPoints[index] + cardPoints[N - k + index];
            maxScore = Math.max(maxScore, sum);
        }
        return maxScore;
    }

    public int maxScoreDP(int[] cardPoints, int k) {
        int answer = Integer.MIN_VALUE;
        int N = cardPoints.length;
        int[] prefixSum = new int[k + 1];
        int[] suffixSum = new int[k + 1];
        for (int index = 0; index < k; index++) {
            prefixSum[index + 1] = prefixSum[index] + cardPoints[index];
            suffixSum[index + 1] = suffixSum[index] + cardPoints[N - index - 1];
        }
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= k; j++) {
                if ((i + j) == k)
                    answer = Math.max(answer, prefixSum[i] + suffixSum[j]);
            }
        }
        return answer;
    }


    private void printDp(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println("===========");

    }

    public static void main(String[] args) {
        LC1423MaxPointsObtainFromCards obj = new LC1423MaxPointsObtainFromCards();
        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;
        //  int[] cardPoints = { 2, 2, 2 };
        // int k = 2;
        // int[] cardPoints = { 1, 79, 80, 1, 1, 1, 200, 1 };
        //  int k = 3;
        System.out.println(obj.maxScore(cardPoints, k));

    }

}
