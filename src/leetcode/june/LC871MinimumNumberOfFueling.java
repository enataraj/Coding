package leetcode.june;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC871MinimumNumberOfFueling {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        int result = 0;
        if (startFuel >= target) {
            return 0;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stations.length; i++) {
            while (!maxHeap.isEmpty() && startFuel < stations[i][0]) {
                startFuel += maxHeap.poll();
                result++;

            }
            if (startFuel < stations[i][0]) {
                return -1;
            }
            maxHeap.add(stations[i][1]);
        }

        while (!maxHeap.isEmpty() && startFuel < target) {
            startFuel += maxHeap.poll();
            result++;
        }
        if (startFuel < target) {
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int target = 200;
        int startFuel = 50;
        int[][] stations = { { 25, 25 }, { 50, 100 }, { 100, 100 }, { 150, 40 } };
        LC871MinimumNumberOfFueling obj = new LC871MinimumNumberOfFueling();
        System.out.println(obj.minRefuelStops(target, startFuel, stations));
    }

}
