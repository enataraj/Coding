package leetcode.aug2021;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC1942SmallestOccupiedChair {

    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> availableCharis = new PriorityQueue<>();
        Map<Integer, Integer> allocatedCharis = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            queue.add(new int[] { times[i][0], 1, i });
            queue.add(new int[] { times[i][1], -1, i });
            availableCharis.add(i);
        }
        // Adding one chair for buffer
        availableCharis.add(times.length);

        while (!queue.isEmpty()) {
            int[] details = queue.poll();
            // Arrival , Upon Arrival, Pick the chair from available queue and put into allocated Map.
            if (details[1] == 1) {
                if (details[2] == targetFriend) {
                    return availableCharis.poll();
                }
                allocatedCharis.put(details[2], availableCharis.poll());

            } else {
                // Upon Depature remove the chair from allocated map and added into Available Queue.
                int freedChair = allocatedCharis.remove(details[2]);
                availableCharis.add(freedChair);
            }
        }

        return availableCharis.peek();

    }

    public static void main(String[] args) {
        LC1942SmallestOccupiedChair obj = new LC1942SmallestOccupiedChair();
        int[][] times = { { 4, 5 }, { 12, 13 }, { 5, 6 }, { 1, 2 }, { 8, 9 }, { 9, 10 }, { 6, 7 }, { 3, 4 }, { 7, 8 },
                { 13, 14 }, { 15, 16 }, { 14, 15 }, { 10, 11 }, { 11, 12 }, { 2, 3 }, { 16, 17 } };
        int targetFriend = 15;

        System.out.println(obj.smallestChair(times, targetFriend));

    }

}
