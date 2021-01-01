package leetcode;

public class LC1137TribonacciSeries {

    public int tribonacci(int n) {
        int t1 = 0, t2 = 1, t3 = 1, res = 0;
        if (n == 0) {
            return t1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        for (int i = 2; i < n; i++) {

            res = t1 + t2 + t3;
            t1 = t2;
            t2 = t3;
            t3 = res;
        }
        return res;

    }
}
