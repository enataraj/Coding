package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1094CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int max = Integer.MIN_VALUE;
        for(int[] trip : trips)
            max = Math.max(max, trip[2]);
        
        int[] dp = new int[max+1];
        for(int[] trip : trips){
            dp[trip[1]] += trip[0];
            dp[trip[2]] -= trip[0];
        }
        
        for(int i=1; i<=max; i++){
            dp[i] += dp[i-1];
            if(dp[i] > capacity)
                return false;
        }
        
        return true;
    }

    public boolean carPoolingNW(int[][] trips, int capacity) {

        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < trips.length; i++) {
            System.out.println(Arrays.toString(trips[i]));
        }

        int[] tripPre = trips[0];
        int passengers = tripPre[0];

        int preEnd = tripPre[2];
        for (int i = 1; i < trips.length; i++) {
            int[] trip = trips[i];
            int start = trip[1];
            int end = trip[2];

            if (preEnd >= start) {
                passengers += trip[0];
            } else {
                passengers = trip[0];
            }

            preEnd = Math.min(preEnd, end);
            System.out.println(passengers);
            if (passengers >= capacity) {
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        LC1094CarPooling obj = new LC1094CarPooling();
        int[][] trips = { { 8, 2, 3 }, { 4, 1, 3 }, { 1, 3, 6 }, { 8, 4, 6 }, { 4, 4, 8 } };
        System.out.println(obj.carPooling(trips, 12));

    }
}
