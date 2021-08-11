package leetcode.aug2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LC218SkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        List<int[]> buildingHeightList = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            buildingHeightList.add(new int[] { building[0], building[2], 1 });
            buildingHeightList.add(new int[] { building[1], building[2], -1 });
        }

        Collections.sort(buildingHeightList, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(0);
        int prevHeight = 0;

        for (int[] buildingHeight : buildingHeightList) {
            if (buildingHeight[2] == 1) {
                queue.add(buildingHeight[1]);
            } else {
                queue.remove(buildingHeight[1]);
            }

            int curHeight = queue.peek();
            if (curHeight != prevHeight) { // Previous building height is not equal to current height will participate
                List<Integer> list = new ArrayList<>();
                list.add(buildingHeight[0]);
                list.add(curHeight);
                result.add(list);
                prevHeight = curHeight;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LC218SkylineProblem obj = new LC218SkylineProblem();
    }

}
