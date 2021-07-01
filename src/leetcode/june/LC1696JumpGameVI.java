package leetcode.june;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LC1696JumpGameVI {

    class Score {
        private int idx;
        private int score;

        public Score(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
    }

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Score> deque = new LinkedList<>();
        deque.addLast(new Score(0, nums[0]));
        int maxScore = nums[0];
        for (int i = 1; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst().idx < i - k) {
                deque.pollFirst();
            }
            int score = deque.peekFirst().score;
            maxScore = nums[i] + score;
            while (!deque.isEmpty() && maxScore >= deque.peekLast().score) {
                deque.pollLast();
            }
            deque.addLast(new Score(i, maxScore));
        }
        return maxScore;
    }

    public int maxResultPQ(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int score = nums[0];
        pq.add(new int[] { 0, score });
        for (int i = 1; i < nums.length; i++) {
            while (i - pq.peek()[0] > k) {
                pq.poll();
            }
            score = pq.peek()[1] + nums[i];
            pq.add(new int[] { i, score });
            
        }
        return score;
    }

    public static void main(String[] args) {
        LC1696JumpGameVI obj = new LC1696JumpGameVI();
        // int[] nums= {1,-5,-20,4,-1,3,-6,-3};
        int[] nums = { 0,1,2,3,4,5,6 };

        int k = 2;
        System.out.println(obj.maxResult(nums, k));
        System.out.println(obj.maxResultPQ(nums, k));
    }

}
