package leetcode.oct2021;

import java.util.Arrays;

public class FindMissingObservations {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int num : rolls) {
            sum += num;
        }

        int totalSum = mean * (n + rolls.length);
        int requiredSum = totalSum - sum;
        if (requiredSum < n || requiredSum > (6 * n)) {
            return new int[0];
        }
        int[] result = new int[n];
        int bal = requiredSum % n;
        int idx = 0;
        Arrays.fill(result, requiredSum / n);
        while (bal > 0) {
            result[idx++] += 1;
            bal--;
        }
        return result;
    }

    public static void main(String[] args) {
        FindMissingObservations obj = new FindMissingObservations();
        int[] rolls = { 1 };
        int mean = 1;
        int n = 1;
        System.out.println(Arrays.toString(obj.missingRolls(rolls, mean, n)));

    }

}
