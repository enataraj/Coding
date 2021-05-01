package leetcode;

public class CountingBits {

    public static int[] countBitsBF(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int sum = 0, m = i;
            while (m != 0) {
                sum = (m % 2) + sum;
                m = m / 2;
            }
            res[i] = sum;
        }
        return res;
    }

    public static int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }

        return res;

    }

    public static int[] countBitsAlt(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i / 2] + 1;
            }
        }
        return res;
    }

}
