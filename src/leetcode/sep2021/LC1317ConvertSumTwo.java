package leetcode.sep2021;

public class LC1317ConvertSumTwo {
    public int[] getNoZeroIntegers(int n) {
        int left = 1;
        int right = n - 1;
        while (left <= right) {
            if (isContainsZero(left) && isContainsZero(right)) {
                return new int[] { left, right };
            }
            left++;
            right--;
        }
        return new int[] { -1, -1 };

    }

    private boolean isContainsZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }

}
