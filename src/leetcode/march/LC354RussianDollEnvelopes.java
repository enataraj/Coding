package leetcode.march;

import java.util.Arrays;
import java.util.TreeSet;

public class LC354RussianDollEnvelopes {
    
    
    public int maxEnvelopesNlogN(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] envelope : envelopes) {
            Integer height = set.ceiling(envelope[1]);
            if (height != null) {
                set.remove(height);
            }
            set.add(envelope[1]);
            System.out.println(set);
        }
        return set.size();
    }

    public int maxEnvelopesN2(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int result = 1;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 1)
            return 1;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] lis = new int[envelopes.length];
        Arrays.fill(lis, 1);

        for (int i = envelopes.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < envelopes.length; j++) {
                if (envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < lis.length; i++) {
            result = Math.max(lis[i], result);
        }
        return result;
    }

   

    public static void main(String[] args) {
        LC354RussianDollEnvelopes obj = new LC354RussianDollEnvelopes();
        // int[][] envelops = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
        int[][] envelops = { { 2, 100 }, { 3, 200 }, { 4, 300 }, { 5, 500 }, { 5, 400 }, { 5, 250 }, { 6, 370 },
                { 6, 360 }, { 7, 380 } };
        System.out.println(Arrays.toString(envelops));
        System.out.println(obj.maxEnvelopes(envelops));
    }

}
