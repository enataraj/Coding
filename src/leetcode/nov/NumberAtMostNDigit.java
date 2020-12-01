package leetcode.nov;

import java.util.HashSet;
import java.util.Set;

public class NumberAtMostNDigit {
    
    
    public int atMostNGivenDigitSetDp(String[] D, int N) {
        String S = String.valueOf(N);
        int K = S.length();
        int[] dp = new int[K+1];
        dp[K] = 1;

        for (int i = K-1; i >= 0; --i) {
            // compute dp[i]
            int Si = S.charAt(i) - '0';
            for (String d: D) {
                if (Integer.valueOf(d) < Si)
                    dp[i] += Math.pow(D.length, K-i-1);
                else if (Integer.valueOf(d) == Si)
                    dp[i] += dp[i+1];
            }
        }

        for (int i = 1; i < K; ++i)
            dp[0] += Math.pow(D.length, i);
        return dp[0];
    }
    
    public int atMostNGivenDigitSetMath(String[] D, int N) {
        int B = D.length; // bijective-base B
        char[] ca = String.valueOf(N).toCharArray();
        int K = ca.length;
        int[] A = new int[K];
        int t = 0;

        for (char c: ca) {
            int c_index = 0;  // Largest such that c >= D[c_index - 1]
            boolean match = false;
            for (int i = 0; i < B; ++i) {
                if (c >= D[i].charAt(0))
                    c_index = i+1;
                if (c == D[i].charAt(0))
                    match = true;
            }

            A[t++] = c_index;
            if (match) continue;

            if (c_index == 0) { // subtract 1
                for (int j = t-1; j > 0; --j) {
                    if (A[j] > 0) break;
                    A[j] += B;
                    A[j-1]--;
                }
            }

            while (t < K)
                A[t++] = B;
            break;
        }

        int ans = 0;
        for (int x: A)
            ans = ans * B + x;
        return ans;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        if (digits == null || digits.length == 0) {
            return 0;
        }
        int res = 0;
        Set<Integer> disgitSet = new HashSet<>();
        for (String digit : digits) {
            disgitSet.add(Integer.parseInt(digit));
        }

        for (int i = 1; i <= n; i++) {
            int num = i;
            boolean flag = true;
           // String tmp = 
            while (num > 0) {
                if (!disgitSet.contains(num % 10)) {
                    flag = false;
                    break;
                }
                num = num / 10;

            }
            if (flag) {
                res++;
            }
            System.out.println(res);
        }

        return res;

    }

    public static void main(String[] args) {
        NumberAtMostNDigit obj = new NumberAtMostNDigit();

        // String[] digits = {"1","3","5","7"};
        // int n = 8;
        String[] digits = { "1", "4", "9" };
        int n = 1000000000;
        System.out.println(obj.atMostNGivenDigitSet(digits, n));
    }

}
