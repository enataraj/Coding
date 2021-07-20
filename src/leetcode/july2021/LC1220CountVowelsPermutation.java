package leetcode.july2021;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class LC1220CountVowelsPermutation {

    private Map<String, Long> map = new HashMap<>();
    int MOD = 1000000007;

    public int countVowelPermutation(int n) {
        long result = 0;

        char[] charSet = new char[] { 'a', 'e', 'i', 'o', 'u' };
        for (char ch : charSet) {
            result = (result + dfsHelper(n - 1, ch)) % MOD;
        }
        System.out.println(map);
        return (int) result;

    }
    
    /* n=2
     * a -> ae
     * e->  ea,ei
     * i-> ia,ie,io,iu
     * o ->oi ou
     * u -> ua
     * 
     * 10
     */

    public long dfsHelper(int remaingChar, char prevChar) {
        if (remaingChar == 0) {
            return 1;

        }
        String key = remaingChar + "#" + prevChar;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        long total = 0;
        if (prevChar == 'a') {
            total = (dfsHelper(remaingChar - 1, 'e')) % MOD;
        } else if (prevChar == 'e') {
            total = (dfsHelper(remaingChar - 1, 'a') + dfsHelper(remaingChar - 1, 'i')) % MOD;

        } else if (prevChar == 'i') {
            total = (dfsHelper(remaingChar - 1, 'a') + dfsHelper(remaingChar - 1, 'e') + dfsHelper(remaingChar - 1, 'o')
                    + dfsHelper(remaingChar - 1, 'u')) % MOD;
        } else if (prevChar == 'o') {
            total = (dfsHelper(remaingChar - 1, 'i') + dfsHelper(remaingChar - 1, 'u')) % MOD;

        } else if (prevChar == 'u') {
            total = (dfsHelper(remaingChar - 1, 'a')) % MOD;
        }
        map.put(key, total);
        return total;
    }

    // DP Solution

    public int countVowelPermutationDP(int n) {
        int MOD = (int) (1e9) + 7;
        BigInteger[] countsAtLength = new BigInteger[5];
        BigInteger[] temp = new BigInteger[5];
        fill(countsAtLength, new BigInteger("1"));
        while (n-- > 1) {
            temp[0] = countsAtLength[1].add(countsAtLength[2]).add(countsAtLength[4]);
            temp[1] = countsAtLength[0].add(countsAtLength[2]);
            temp[2] = countsAtLength[1].add(countsAtLength[3]);
            temp[3] = countsAtLength[2];
            temp[4] = countsAtLength[2].add(countsAtLength[3]);
            countsAtLength = temp.clone();
        }
        int answer = 0;
        for (int index = 0; index < 5; index++) {
            answer += countsAtLength[index].mod(BigInteger.valueOf(MOD)).intValue();
            answer %= MOD;
        }
        return answer;
    }

    public void fill(BigInteger[] countsAtLength, BigInteger value) {
        for (int index = 0; index < countsAtLength.length; index++)
            countsAtLength[index] = value;
    }
    
    public static void main(String[] args) {
        LC1220CountVowelsPermutation obj = new LC1220CountVowelsPermutation();
        System.out.println(obj.countVowelPermutation(4));
    }

}
