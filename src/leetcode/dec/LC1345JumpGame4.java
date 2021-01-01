package leetcode.dec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC1345JumpGame4 {

    /*
     * BFS with Visited BFS Possibility current Idx +1 or Idx -1 or All possible
     * value same as current Idx Maintian Visited not to visit again Clear the list
     * after visit all idx else this will check again and again
     */

    public int minJumps(int[] arr) {

        if (arr.length == 1) {
            return 0;
        }
        int length = arr.length - 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        /*
         * 
         * for (int i = 0; i < n; i++) { valIndicesMap.putIfAbsent(arr[i], new
         * ArrayList<>()); valIndicesMap.get(arr[i]).add(i); }
         */
        for (int i = 0; i <= length; i++) {
            if (map.containsKey(arr[i])) {
                List<Integer> list = map.get(arr[i]);
                list.add(i);
                map.put(arr[i], list);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(arr[i], list);
            }

        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[length + 1];
        queue.add(0);
        isVisited[0] = true;
        int jump = 0;

        while (!queue.isEmpty()) {
            System.out.println(map);
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int idx = queue.poll();
                if (idx == length) {
                    return jump;
                }

                if (idx - 1 >= 0 && !isVisited[idx - 1]) {
                    queue.add(idx - 1);
                    isVisited[idx - 1] = true;
                }
                if (idx + 1 <= length && !isVisited[idx + 1]) {
                    queue.add(idx + 1);
                    isVisited[idx + 1] = true;
                }

                List<Integer> list = map.get(arr[idx]);
                for (int j = 0; j < list.size(); j++) {
                    int tmpIdx = list.get(j);
                    if (!isVisited[tmpIdx]) {
                        queue.add(tmpIdx);
                        isVisited[tmpIdx] = true;
                    }

                }
                list.clear();
            }
            jump += 1;
        }
        return jump;
    }

    public static void main(String[] args) {
        LC1345JumpGame4 obj = new LC1345JumpGame4();
        // int[] arr = { 6, 1, 9 };
        // int[] arr = { 11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13 };
        // int[] arr = {7,6,9,6,9,6,9,7};
        // int[] arr = { 100, -23, -23, 404, 100, 23, 23, 23, 3, 404 };
        // int[] arr = { -76, 3, 66, -32, 64, 2, -19, -8, -5, -93, 80, -5, -76, -78, 64,
        // 2, 16 };
        int[] arr = { 68, -94, -44, -18, -1, 18, -87, 29, -6, -87, -27, 37, -57, 7, 18, 68, -59, 29, 7, 53, -27, -59,
                18, -1, 18, -18, -59, -1, -18, -84, -20, 7, 7, -87, -18, -84, -20, -27 };

        System.out.println(obj.minJumps(arr));
    }

}
