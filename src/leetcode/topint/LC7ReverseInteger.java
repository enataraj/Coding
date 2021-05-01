package leetcode.topint;

public class LC7ReverseInteger {

    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = Math.abs(x);
        }
        long result = 0;
        while (x > 0) {
            result = (result * 10) + x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        LC7ReverseInteger obj = new LC7ReverseInteger();
        obj.reverse(321);
    }
}
