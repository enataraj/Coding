package leetcode;

import java.util.Arrays;

public class LC1710MaxNumberOfBox {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][0] < truckSize) {
                truckSize = truckSize - boxTypes[i][0];
                result = result + (boxTypes[i][0] * boxTypes[i][1]);

            } else {
                result = result + (truckSize * boxTypes[i][1]);
                break;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        LC1710MaxNumberOfBox obj = new LC1710MaxNumberOfBox();
        int[][] boxTypes = { { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } };
        int truckSize = 10;
        System.out.println(obj.maximumUnits(boxTypes, truckSize));
    }

}
