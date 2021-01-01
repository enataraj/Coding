package leetcode.dec;

public class LC1492KthFactorOfN {

    // This problem can be solved Sqrt of N time comutation

    // Also different approach :
    // https://leetcode.com/problems/the-kth-factor-of-n/discuss/960094/Python-Time%3AO(log(n))-Space%3AO(log(n))-7-lines

    public int kthFactor(int n, int k) {
        if (n == 0)
            return -1;
        if (n == 1 && k == 1)
            return 1;
        if (n == 1 && k > 1)
            return -1;
        if (k == 1 && n != 0)
            return 1;

        int factorCount = 1;
        for (int i = 2; i <= 1000; i++) {
            if (n % i == 0) {
                factorCount++;
            }
            if (factorCount == k) {
                return i;
            }
        }

        return -1;
    }

    public int kthFactorSol(int n, int k) {
        int i, c = 0;
        for (i = 1; i <= n; i++) {
            if (n % i == 0) {
                c++;
                if (c == k)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC1492KthFactorOfN obj = new LC1492KthFactorOfN();
        int n = 1000;
        int k = 3;
        System.out.println(obj.kthFactor(n, k));
    }

}
