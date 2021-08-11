package leetcode.weekly.biweekly57;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SmallestUnOccupiedChair {

    public int smallestChair(int[][] times, int targetFriend) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            map.put(times[i][0], i);
        }

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            queue.add(i);

        }
        PriorityQueue<int[]> depQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        depQueue.add(new int[] { times[0][1], queue.poll(), times[0][0] });
        if (map.get(times[0][0]) == targetFriend) {
            queue.peek();
        }

        for (int i = 1; i < times.length; i++) {
            
            
            if (depQueue.peek()[0] <= times[i][1]) {
                queue.add(depQueue.peek()[1]);
                depQueue.poll();
            }
            depQueue.add(new int[] { times[i][1], queue.poll(), times[i][0] });
            
            int arrTime = times[i][0];
            if (map.get(arrTime) == targetFriend) {
                queue.peek();
            }
        }
        return queue.peek();

    }

    public static void main(String[] args) {
        SmallestUnOccupiedChair obj = new SmallestUnOccupiedChair();
        //int[][] times = { { 1, 4 }, { 2, 3 }, { 4, 6 } };
        int[][] times = { { 3, 10 }, { 1, 5 }, { 2, 6 } };
        int target = 0;

        System.out.println(obj.smallestChair(times, target));
    }

}
