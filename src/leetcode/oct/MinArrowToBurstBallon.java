package leetcode.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinArrowToBurstBallon {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }

        List<Integer[]> result = new ArrayList<>();

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return (Integer.valueOf(o1[1]).compareTo(o2[1]));
                }
                return (Integer.valueOf(o1[0]).compareTo(o2[0]));
            }
        });

        Integer[] tmp = new Integer[2];
        tmp[0] = points[0][0];
        tmp[1] = points[0][1];
        result.add(tmp);

        for (int i = 1; i < points.length; i++) {
            int a1 = result.get(result.size() - 1)[0];
            int b1 = result.get(result.size() - 1)[1];
            int a2 = points[i][0];
            int b2 = points[i][1];

            if (a2 >= a1 && a2 <= b1) {
                tmp = new Integer[2];

                if (a1 < a2) {
                    tmp[0] = a2;
                } else {
                    tmp[0] = a1;
                }

                if (b1 < b2) {

                    tmp[1] = b1;

                } else {
                    tmp[1] = b2;
                }
                result.remove(result.size() - 1);
                result.add(tmp);

            } else {
                tmp = new Integer[2];
                tmp[0] = a2;
                tmp[1] = b2;
                result.add(tmp);
            }
        }
        return result.size();

    }
    
    public int findMinArrowShotsOpt(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> {
            if (a[1] > b[1]) {
                return 1;
            } 
                return -1;
            
        });
        
        int num = 0;
        int prevEnd = points[0][1];
        int i = 1;
        while (i < points.length) {
            if (points[i][0] > prevEnd) {
                num++;
                prevEnd = points[i][1];
            } 
            i++;
        }
        return num + 1;
    }

    public static void main(String[] args) {
        MinArrowToBurstBallon obj = new MinArrowToBurstBallon();
        // int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };

//        int[][] points ={{1,2},{3,4},{5,6},{7,8}};
//        int[][] points = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        int[][] points = { { 2, 3 }, { 2, 3 } };
        System.out.println(obj.findMinArrowShots(points));

    }

}
