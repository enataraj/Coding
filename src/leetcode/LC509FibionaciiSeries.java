package leetcode;

public class LC509FibionaciiSeries {

    public int fib(int n) {
        int a = 0;
        int b = 1;

        if (n == 1)
            return 1;

        int res = 0;
        for (int i = 1; i < n; i++) {

            res = a + b;
            a = b;
            b = res;

        }
        return res;
    }

    public int fibRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return (fibRecursive(n - 1) + fibRecursive(n - 2));

    }

    public static void main(String[] args) {
        LC509FibionaciiSeries obj = new LC509FibionaciiSeries();
        System.out.println(obj.fib(30));
        System.out.println(obj.fibRecursive(30));
    }
}
