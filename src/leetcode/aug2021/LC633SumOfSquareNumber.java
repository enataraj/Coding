package leetcode.aug2021;

public class LC633SumOfSquareNumber {

    public boolean judgeSquareSum(int c) {
        int sqrtNumber = (int) Math.sqrt(c);
        int left = 0;
        int right = sqrtNumber;
        while (left <= right) {
            int tmp = (left * left) + (right * right);
            if (c == tmp)
                return true;
            if (c > tmp) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

}
