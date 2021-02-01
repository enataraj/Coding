package leetcode.array;

import java.util.Arrays;

public class LC1720DecodeXORArray {

    public int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] res = new int[len + 1];

        res[0] = first;
        for (int i = 0; i < len; i++) {
            res[i + 1] = res[i] ^ encoded[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LC1720DecodeXORArray obj = new LC1720DecodeXORArray();
        int[] encoded = { 6, 2, 7, 3 };
        int first = 4;

        System.out.println(Arrays.toString(obj.decode(encoded, first)));

    }

}
