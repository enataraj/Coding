package leetcode.topint;

public class LC69SqrtOfX {

    public int mySqrt(int x) {
        long left = 1;
        long right = x / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long product = mid * mid;
            if (product == x) {
                return (int) mid;
            } else if (product < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left * left == x) {
            return (int) left;
        }
        return (int) right;
    }

}
