package leetcode.feb;

public class LC29DivideTwoInteger {

    /*
     * 
     * https://www.youtube.com/watch?v=m4L_5qG4vG8
     * 
     * Double the divisor every time and subtract it till its possible
     * 
     */
    public int divide(int dividend, int divisor) {
        int res = 0;

        if (dividend == 1 << 31 && divisor == -1)
            return Integer.MAX_VALUE;
        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;
        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);
        while (dividend - divisor >= 0) {
            int count = 0;
            while (dividend - (divisor << 1 << count) >= 0)
                count++;
            res += 1 << count;
            dividend = dividend - (divisor << count);
        }
        return sign == true ? res : -res;
    }

    public int divideSol(int A, int B) {
        if (Integer.MIN_VALUE == A && B == -1) {
            return Integer.MAX_VALUE;
        }

        int a = Math.abs(A);
        int b = Math.abs(B);
        int res = 0;

        while (a - b >= 0) {
            int tmp = b;
            int cnt = 1;
            while (a - (tmp << 1) >= 0) {
                tmp <<= 1;
                cnt <<= 1;
            }
            a -= tmp;
            res += cnt;
        }

        return (A > 0) == (B > 0) ? res : -res;
    }

    public int divideSol1(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1)
            return Integer.MAX_VALUE;
        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int res = 0;

        while (dividend - divisor >= 0) {
            int tmpDiv = divisor;
            int cnt = 1;
            while (dividend - (tmpDiv << 1) >= 0) {
                tmpDiv <<= 1;
                cnt <<= 1;
            }
            dividend -= tmpDiv;
            res += cnt;
        }

        return sign ? res : -res;
    }

    public int divideSol2(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1)
            return Integer.MAX_VALUE;
        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int res = 0;

        while (dividend - divisor >= 0) {
            int tmpDiv = divisor;
            int cnt = 1;
            while (dividend - (tmpDiv + tmpDiv) >= 0) {
                tmpDiv = tmpDiv + tmpDiv;
                cnt = cnt + cnt;
            }
            dividend -= tmpDiv;
            res += cnt;
        }

        return sign ? res : -res;
    }

    public static void main(String[] args) {
        LC29DivideTwoInteger obj = new LC29DivideTwoInteger();
    }

}
