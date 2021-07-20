package leetcode.topint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LC218SkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> buildingHeights = new ArrayList<>();
        for (int[] building : buildings) {
            int[] buildingHeightStart = { building[0], -building[2] };
            int[] buildingHeightEnd = { building[1], building[2] };
            buildingHeights.add(buildingHeightStart);
            buildingHeights.add(buildingHeightEnd);
        }

        Collections.sort(buildingHeights, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];

        });

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        queue.add(0);
        int prev = 0;

        for (int[] buildingHeight : buildingHeights) {
            if (buildingHeight[1] < 0) {
                queue.add(-buildingHeight[1]);
            } else {
                queue.remove(buildingHeight[1]);
            }

            int curHeight = queue.peek();
            if (curHeight != prev) {
                List<Integer> list = new ArrayList<>();
                list.add(buildingHeight[0]);
                list.add(curHeight);
                result.add(list);
                prev = curHeight;
            }

        }
        return result;
    }

}
