package general;

public class LC29DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1)
            return Integer.MAX_VALUE;
        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;
        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);
        int res = 0;
        while (dividend - divisor >= 0) {
            int count = 0;
            while (dividend - (divisor << 1 << count) >= 0) {
                count++;
            }
            res += 1 << count;
            dividend = dividend - (divisor << count);
        }
        return sign == true ? res : -res;

    }

    public static void main(String[] args) {
        LC29DivideTwoIntegers obj = new LC29DivideTwoIntegers();
        System.out.println(obj.divide(10, 3));
    }

}
