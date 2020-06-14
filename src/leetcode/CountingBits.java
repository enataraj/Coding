package leetcode;

public class CountingBits {

    public static int[] countBits(int num) {
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

}
