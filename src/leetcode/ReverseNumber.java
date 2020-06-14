package leetcode;

public class ReverseNumber {

    public int reverse(int x) {
        long res = 0;
        int negative = 1;

        if (x > -10 && x < 10) {
            return x;
        }

        if (x < 0) {
            negative = -1;
            x = x * negative;
        }

        while (x > 0) {

            int tmp = x % 10;
            res = (res * 10) + tmp;
            x = x / 10;
        }

        if (res > Integer.MAX_VALUE) {
            return 0;
        }
        if (res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) (negative * res);

    }

    public static void main(String[] args) {
        int num = 1534236469;
        num = new ReverseNumber().reverse(num);
        System.out.println("Reversed Number : " + num);
    }

}
