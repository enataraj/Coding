package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        Set<Integer> resultSet = new HashSet<>();
        while (true) {
            n = helper(n);
            // System.out.println(n);
            if (n == 1) {
                return true;
            } else if (resultSet.contains(n)) {
                return false;
            } else {
                resultSet.add(n);

            }
        }

    }

    private int helper(int n) {
        int sum = 0;

        while (n > 9) {
            int t = n % 10;
            n = n / 10;
            sum = sum + (t * t);
        }
        sum = sum + (n * n);

        return sum;

    }

    public boolean isHappyEfficient(int n) {
        int slow = n;
        int fast = helper(n);
        while (fast != 1 && fast != slow) {
            slow = helper(slow);
            fast = helper(helper(fast));
        }
        return fast == 1;
    }

    public static void main(String[] args) {

        HappyNumber obj = new HappyNumber();
        boolean result = obj.isHappy(19);
        System.out.println(result);

    }
}
