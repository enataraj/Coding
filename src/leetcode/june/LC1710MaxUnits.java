package leetcode.june;

import java.util.Arrays;

public class LC1710MaxUnits {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int result = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize >= boxTypes[i][0]) {
                result += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                result += truckSize * boxTypes[i][0];
                break;
            }
        }
        return result;

    }
    
    public int maximumUnitsOpt(int[][] boxTypes, int truckSize) {
        int[] cs = new int[1001];
       for (int i = 0; i < boxTypes.length; i++)
           cs[boxTypes[i][1]] += boxTypes[i][0];
       
       int total = 0;
       for (int i = 1000; i >= 0 && truckSize > 0; i--) {
           if (cs[i] != 0){
               total += Math.min(truckSize, cs[i]) * i;
               truckSize -= cs[i];
           }
       }

       return total;
   }

}
