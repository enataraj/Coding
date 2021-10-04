package leetcode.weekly.week255;

public class FindGCD {
    public int findGCD(int[] nums) {
        int small = 1001;
        int max = 0;

        for (int num : nums) {
            small = Math.min(small, num);
            max = Math.max(max, num);

        }
        return gcd(small, max);

    }

    private int gcd(int num1, int num2) {
        if (num1 == 0)
            return num2;
        if (num2 == 0)
            return num1;
        if (num1 == num2)
            return num1;
        if (num1 > num2)
            return gcd(num1 - num2, num2);
        return gcd(num1, num2 - num1);
    }

}
