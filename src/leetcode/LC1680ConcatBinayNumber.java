package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC1680ConcatBinayNumber {

    public int concatenatedBinaryNot(int n) {
        int MOD = 1000000007;

        StringBuffer strBuffer = new StringBuffer();
        Queue<String> queue = new LinkedList<String>();
        queue.add("1");
        while (n > 0) {
            String str = queue.poll();
            strBuffer.append(str);
            queue.add(str + "0");
            queue.add(str + "1");
            n--;
        }
        double res = 0;
        int pow = 0;
        for (int i = strBuffer.length() - 1; i >= 0; i--) {

            if (strBuffer.charAt(i) == '1') {
                res = (res + getPowerOfX(pow)) % MOD;
            }
            pow++;
        }

        System.out.println(strBuffer.toString());
        return (int) res;

    }

    private double getPowerOfX(int pow) {
        double res = 1;
        for (int i = 0; i < pow; i++) {
            res *= 2;
        }
        return res % MOD;
    }

    private static final int MOD = 1000000007;
    private static final int[] aux = new int[100001];
    private static int BASE = 0;

    public int concatenatedBinarySol1(int n) {
        if (aux[n] != 0)
            return aux[n];
        int i = 1;
        while (i < n && aux[i] != 0)
            i++;
        for (; i <= n; i++) {
            if (((1 << BASE) & i) != 0)
                BASE++;
            aux[i] = (int) ((((long) (aux[i - 1]) << BASE) + i) % MOD);
        }
        return aux[n];
    }

    public int concatenatedBinarySol(int n) {
        int digits = 0, MOD = 1000000007;
        long result = 0;
        for (int i = 1; i <= n; i++) {
            /*
             * if "i" is a power of 2, then we have one additional digit in its the binary
             * equivalent compared to that of i-1
             */
            if ((i & (i - 1)) == 0)
                digits++;
            result = ((result << digits) + i) % MOD;
        }

        return (int) result;
    }

    public int concatenatedBinary(int n) {

        int mod = 1000000007;
        int res = 0;

        for (int num = 1; num <= n; num++) {

            String binaryRep = Integer.toBinaryString(num);

            for (char ch : binaryRep.toCharArray()) {
                int val = (ch == '0') ? 0 : 1;

                res = ((res * 2) % mod + val) % mod;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        LC1680ConcatBinayNumber obj = new LC1680ConcatBinayNumber();
        int n = 20;
        // 20 -- > 632668867
        System.out.println(obj.concatenatedBinaryNot(n));

    }

}
