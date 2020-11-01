package leetcode.oct;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    Queue<Integer> queue = null;

    public RecentCounter() {
        queue = new LinkedList<>();

    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();

    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));

    }

}
