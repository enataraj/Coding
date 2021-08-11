package leetcode.july2021;

public class LC600NonNegativeIntegers {

    public int findIntegersSol(int n) {
        int one = 0, zero = 0, temp;
        boolean isNum = true;
        for (int i = 31; i >= 0; i--) {
            temp = zero;
            zero += one;
            one = temp;
            if (isNum && ((n >> i) & 1) == 1) {
                zero += 1;
            }
            if (((n >> i) & 1) == 1 && ((n >> i + 1) & 1) == 1) {
                isNum = false;
            }

        }
        return one + zero + (isNum ? 1 : 0);
    }

    public int findIntegers(int n) {
        int x = 1, y = 2;
        int res = 0;
        n++;
        while (n > 0) {
            if ((n & 3) == 3)
                res = 0;
            res += x * (n & 1);
            n >>= 1;
            int t = x + y;
            x = y;
            y = t;
        }
        return res;
    }

    // TLE
    class Solution {
        public int findIntegers(int n) {
            int cnt = 0;
            for (int i = 0; i <= n; i++) {
                String binary = Integer.toBinaryString(i);
                if (binary.contains("11")) {
                    cnt++;
                }
            }
            return n + 1 - cnt;
        }
    }

    /*
     * 11
     * 
     * 110
     * 111
     * 
     * 1100
     * 1101
     * 1110
     * 1111
     * 
     * 11000
     * 11001
     * 11010
     * 11011
     * 11100
     * 11101
     * 11110
     * 11111
     * 
     * 
     * 
     * 
     * 
     * 1111
     * 1110
     * 
     * 1101
     * 1011
     * 1100
     * 
     * 1011
     * 
     * 
     * 
     * 
     */

    public static void main(String[] args) {
        LC600NonNegativeIntegers obj = new LC600NonNegativeIntegers();
        int n = 10;
        System.out.println(obj.findIntegers(n));
    }

}
