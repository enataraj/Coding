package leetcode.weekly;

import java.util.LinkedList;
import java.util.Queue;

public class LCWeekly236 {
    int cnt = 0;

    public int arraySign(int[] nums) {
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                cnt++;
            }
        }
        if (cnt % 2 == 1) {
            return -1;
        }
        return 1;

    }

    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                int val = queue.poll();
                queue.add(val);
            }
            queue.poll();
        }

        return queue.poll();

    }

    public int minSideJumps(int[] A) {
        int[] dp = new int[] { 1, 0, 1 };
        for (int a : A) {
            if (a > 0)
                dp[a - 1] = 1000000;
            for (int i = 0; i < 3; ++i)
                if (a != i + 1)
                    dp[i] = Math.min(dp[i], Math.min(dp[(i + 1) % 3], dp[(i + 2) % 3]) + 1);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        LCWeekly236 obj = new LCWeekly236();
        System.out.println(obj.findTheWinner(6, 5));

    }

}
