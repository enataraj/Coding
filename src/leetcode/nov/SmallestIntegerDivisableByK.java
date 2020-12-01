package leetcode.nov;

import java.util.HashSet;
import java.util.Set;

public class SmallestIntegerDivisableByK {

    public int smallestRepunitDivByK(int K) {

        if (K <= 0 || K % 2 == 0) {
            return -1;
        }

        Set<Integer> repeat = new HashSet<>();
        int N = 1;
        int i = 1;
        while (N > 0 && N < Integer.MAX_VALUE) {
            if (N % K == 0) {
                return i;
            }
            if (repeat.contains(N % K)) {
                return -1;
            }
            repeat.add(N % K);
            N = (N % K) * 10 + 1;
            i++;
        }
        return -1;
    }

    public int smallestRepunitDivByKOpt(int K) {
        if (K % 2 == 0 || K % 5 == 0)
            return -1;
        if (K == 1)
            return 1;

        int remainder = 0;
        for (int i = 1; i <= K; i++) {

            remainder = (10 * remainder + 1) % K;
            if (remainder == 0)
                return i;

        }
        return -1;
    }

    public static void main(String[] args) {
        SmallestIntegerDivisableByK obj = new SmallestIntegerDivisableByK();
        int K = 5;
        System.out.println(obj.smallestRepunitDivByK(K));
    }

}
