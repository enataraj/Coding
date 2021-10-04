package leetcode.sep2021;

import java.util.HashMap;
import java.util.Map;

public class LC2001NumberOfPairsRectange {
    public long interchangeableRectangles(int[][] rectangles) {
        long count = 0;
        Map<Double, Integer> map = new HashMap<>(rectangles.length);
        for (int i = 0; i <rectangles.length ; i++) {
            double iIndex = Double.valueOf(rectangles[i][0])/Double.valueOf(rectangles[i][1]);
            count += map.getOrDefault(iIndex,0);
            map.put(iIndex,map.getOrDefault(iIndex,0)+1);
        }
        return count;
    }

}
