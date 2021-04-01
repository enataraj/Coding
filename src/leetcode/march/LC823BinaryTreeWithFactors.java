package leetcode.march;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC823BinaryTreeWithFactors {

    public int numFactoredBinaryTrees(int[] arr) {
        long result = 0;
        Map<Integer, Long> resultMap = new HashMap<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            long tmpCount = 1l;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && resultMap.containsKey(arr[i] / arr[j])) {
                    tmpCount = tmpCount + resultMap.get(arr[i] / arr[j]) * resultMap.get(arr[j]);
                }
            }
            resultMap.put(arr[i], tmpCount);
        }

       
        for (long i : resultMap.values()) {
            result = result + i;
        }
        return (int) (result % (1000000000 + 7));
    }
    
    int mod = 1000000007;
    public int numFactoredBinaryTreesSol(int[] arr) {
        int n = arr.length;
        long[] dp = new long[n];
        Arrays.sort(arr);
        Map<Integer, Integer> invMap = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            invMap.put(arr[i], i);
        }
        
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i && arr[j]*arr[j]<=arr[i]; j++) {
                if(arr[i]%arr[j]==0) {
                    int oi = invMap.getOrDefault(arr[i]/arr[j], -1);
                    if(oi==-1) continue;
                    if(oi==j) dp[i] += (dp[j]*dp[j])%mod;
                    else dp[i] += (dp[j]*dp[oi]*2) % mod;
                    dp[i] %= mod;
                }
            }
        }
        
        long ans = 0L;
        for(int i=0; i<n; i++) {
            ans += dp[i];
        }
        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        LC823BinaryTreeWithFactors obj = new LC823BinaryTreeWithFactors();
        int[] arr = { 2, 4, 5, 10 };
        System.out.println(obj.numFactoredBinaryTrees(arr));

    }

}
