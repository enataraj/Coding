package leetcode.june;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC1383MaxPerformanceOfTeam {

    class Engineer implements Comparable<Engineer> {
        int speed;
        int efficiency;

        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;

        }

        public String toString() {
            return "(" + speed + " , " + efficiency + ")";
        }

        @Override
        public int compareTo(Engineer e) {

            if (this.efficiency < e.efficiency)
                return 1;
            return -1;

        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> engList = new ArrayList<>();

        long result = 0;
        for (int i = 0; i < n; i++) {
            engList.add(new Engineer(speed[i], efficiency[i]));
        }
        Collections.sort(engList);
        PriorityQueue<Engineer> minSpeedHeap = new PriorityQueue<Engineer>(new Comparator<Engineer>() {

            public int compare(Engineer e1, Engineer e2) {
                if (e1.speed < e2.speed)
                    return -1;
                return 1;
            }
        });

        long speeds = 0;
        long efficiencys = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            Engineer engr = engList.get(i);
            minSpeedHeap.add(engr);
            speeds += engr.speed;
            efficiencys = Math.min(efficiencys, engr.efficiency);
            result = Math.max(result, speeds * efficiencys);
        }
        

        for (int i = k; i < n; i++) {
            Engineer curEng = engList.get(i);
            Engineer minSpeedEng = minSpeedHeap.peek();
            if (curEng.speed > minSpeedEng.speed) {
                speeds -= minSpeedEng.speed;
                speeds += curEng.speed;
                efficiencys = Math.min(efficiencys, curEng.efficiency);
                minSpeedHeap.poll();
                minSpeedHeap.add(curEng);
                result = Math.max(result, speeds * efficiencys);
                
            }
        }
        return (int) (result % 1000000007);
    }

    public static void main(String[] args) {
        LC1383MaxPerformanceOfTeam obj = new LC1383MaxPerformanceOfTeam();
        int n = 6;
        int k = 2;
        int[] speed = { 2, 10, 3, 1, 5, 8 };
        int[] efficiency = { 5, 4, 3, 9, 7, 2 };
        System.out.println(obj.maxPerformance(n, speed, efficiency, k));

    }

}
