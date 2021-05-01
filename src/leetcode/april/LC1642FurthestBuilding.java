package leetcode.april;

import java.util.PriorityQueue;

public class LC1642FurthestBuilding {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int index = 0; index < heights.length - 1; index++) {
            int climb = heights[index + 1] - heights[index];
            if (climb <= 0)
                continue;
            pq.add(climb);
            if (pq.size() <= ladders)
                continue;
            bricks -= pq.poll();
            if (bricks < 0)
                return index;
        }
        return heights.length - 1;
    }

    public int furthestBuildingSol(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int curIdx = 0;
        int sum = 0;
        for (int i = 1; i < heights.length; ++i, ++curIdx) {
            if (heights[i] <= heights[curIdx]) {
                continue;
            }
            sum += heights[i] - heights[curIdx];
            queue.add(heights[i] - heights[curIdx]);

            if (sum > bricks && ladders > 0) {
                sum -= queue.poll();
                --ladders;
            } else if (sum > bricks) {
                break;
            }
        }
        return curIdx;
    }

    public static void main(String[] args) {
        LC1642FurthestBuilding obj = new LC1642FurthestBuilding();

        int[] heights = { 4, 2, 7, 6, 9, 14, 12 };
        int bricks = 5, ladders = 1;
        System.out.println(obj.furthestBuilding(heights, bricks, ladders));
    }

}
