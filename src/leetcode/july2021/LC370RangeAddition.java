package leetcode.july2021;

import java.util.Arrays;

public class LC370RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];

        for (int[] update : updates) {
            if (update[0] < length) {
                result[update[0]] += update[2];
            }
            if (update[1] + 1 < length) {
                result[update[1] + 1] -= update[2];
            }

        }

        for (int i = 1; i < length; i++) {

            result[i] = result[i - 1] + result[i];
        }
        return result;
    }

    public static void main(String[] args) {
        LC370RangeAddition obj = new LC370RangeAddition();
        // int[][] updats = { { 1, 3, 2 }, { 2, 4, 3 }, { 0, 2, -2 } };

        int[][] updats = { { 2, 4, 6 }, { 5, 6, 8 }, { 1, 9, -4 } };
        System.out.println(Arrays.toString(obj.getModifiedArray(10, updats)));
        //[0,-4,2,2,2,4,4,-4,-4,-4]
    }

}
