package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC1376TimeNeededtoInform {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int mgr = manager[i];
            if (map.containsKey(mgr)) {
                List<Integer> list = map.get(mgr);
                list.add(i);
                map.put(mgr, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(mgr, list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(map.get(-1));
        int result = informTime[map.get(-1).get(0)];
        map.remove(-1);

        while (!queue.isEmpty()) {

            int size = queue.size();
            System.out.println(queue);
            for (int i = 0; i < size; i++) {
                int mgr = queue.poll();
                List<Integer> reportees = map.get(mgr);
                map.remove(mgr);
               

                if (reportees != null) {
                    int max = 0;
                    for (int j = 0; j < reportees.size(); j++) {
                        max = Math.max(max, informTime[reportees.get(j)]);
                    }
                    result += max;
                    queue.addAll(reportees);
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        
        /*
         * 15
0
[-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6]
[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]
         */
        LC1376TimeNeededtoInform obj = new LC1376TimeNeededtoInform();
        int n = 15;
        int headID = 0;
        int[] manager = { -1,0,0,1,1,2,2,3,3,4,4,5,5,6,6 };
        int[] informTime = { 1,1,1,1,1,1,1,0,0,0,0,0,0,0,0 };
        System.out.println(obj.numOfMinutes(n, headID, manager, informTime));
    }

}
