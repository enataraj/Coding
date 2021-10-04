package leetcode.sep2021;

import java.util.Arrays;

public class LC1652DefuseBomb {

    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        if (k == 0) {
            return result;
        }

        int len = code.length;
        if (k > 0) {
            int sum = 0;
            int idx = 0;
            for (int i = 1; i <= k; i++) {
                sum += code[i % len];
            }
            for (int i = 0; i < len; i++) {
                int tmp = code[(i + 1) % len];
                result[idx++] = sum;
                sum -= tmp;
                k = k + 1;
                sum += code[k % len];
            }
        }

        if (k < 0) {
            k = k * -1;
            int sum = 0;
            int idx = 0;
            for (int i = len - k; i < len; i++) {
                sum += code[i];
            }

            for (int i = 0; i < len; i++) {
                int tmp = code[(len - k + i) % len];
                result[idx++] = sum;
                sum -= tmp;
                sum += code[(len + i) % len];
            }
        }
        return result;
    }

    public static void main(String[] args) {
       
        LC1652DefuseBomb obj = new LC1652DefuseBomb();
        int[] code = { 5, 7, 1, 4 };
        int k = 3;
        System.out.println(Arrays.toString(obj.decrypt(code, k)));
        int[] code1 = {2,4,9,3};
        int k1 = -2;
        System.out.println(Arrays.toString(obj.decrypt(code1, k1)));
        
    }
}
