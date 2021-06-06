package leetcode.may;

import java.util.PriorityQueue;

public class LC1354ConstructTargetArrayWithMultipleSums {

    public boolean isPossible(int[] target) {
        long sum = 0;
        int max = 0;
        for (int i = 0; i < target.length; i++) {
            sum += target[i];
            if (target[max] < target[i]) {
                max = i;
            }
        }

        long diff = sum - target[max];
        if (target[max] == 1 || diff == 1)
            return true;
        if (diff > target[max] || diff == 0 || target[max] % diff == 0)
            return false;
        target[max] %= diff;
        return isPossible(target);

    }

    public boolean isPossibleIter(int[] target) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < target.length; i++) {
            sum += target[i];
            pq.add(target[i]);
        }
        while (pq.peek() != 1) {
            int val = pq.poll();
            long diff = sum - val;
            if (diff == 1)
                return true;
            if (diff > val || diff == 0 || val % diff == 0)
                return false;
            val %= diff;
            sum = diff + val;
            pq.add(val);

        }
        return true;

    }

    public static void main(String[] args) {
        LC1354ConstructTargetArrayWithMultipleSums obj = new LC1354ConstructTargetArrayWithMultipleSums();
    }

}
