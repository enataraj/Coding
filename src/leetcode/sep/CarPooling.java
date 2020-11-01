package leetcode.sep;

import java.util.HashMap;
import java.util.Map;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {

        if (trips == null || trips.length == 0) {
            return false;
        }

        if (trips.length == 1) {
            if (trips[0][0] > capacity) {
                return false;
            }
            return true;
        }

        Map<Integer, Integer> tripMap = new HashMap<>();

        for (int i = 0; i < trips.length; i++) {
            for (int j = trips[i][1]; j < trips[i][2]; j++) {
                System.out.println(tripMap);
                if (tripMap.containsKey(j)) {
                    int ppl = tripMap.get(j);
                    ppl = ppl + trips[i][0];
                    if (ppl > capacity) {
                        return false;
                    }
                    tripMap.put(j, ppl);
                } else {
                    int ppl = trips[i][0];
                    if (ppl > capacity) {
                        return false;
                    }
                    tripMap.put(j, ppl);
                }
            }

        }

        return true;
    }

    public boolean carPoolingOpt(int[][] trips, int capacity) {
        int stops[] = new int[1001];

        for (int t[] : trips) {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }

        for (int i = 0; capacity >= 0 && i < 1001; ++i)
            capacity -= stops[i];

        return capacity >= 0;
    }

    public static void main(String[] args) {
        CarPooling obj = new CarPooling();
        // int[][] trips = { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } };
        // int[][] trips = {{2,1,5},{3,5,7}};

        int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
        int capacity = 4;
        System.out.println(obj.carPooling(trips, capacity));

    }

}
