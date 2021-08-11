package leetcode.weekly.week252;

import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStrones {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        for (int num : piles) {
            queue.add(num);
        }
        while (k > 0) {
            k--;
            int num = queue.poll();
            if (num % 2 == 1) {
                num += 1;
            }
            queue.add(num / 2);
        }

        int result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveStrones obj = new RemoveStrones();
        int[] piles = { 4, 3, 6, 7 };
        System.out.println(obj.minStoneSum(piles, 3));
    }

}
