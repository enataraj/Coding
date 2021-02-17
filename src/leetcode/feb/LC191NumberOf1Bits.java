package leetcode.feb;

public class LC191NumberOf1Bits {

    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += (n & 1);
            n = n >>> 1;

        }
        return cnt;
    }

    public int hammingWeightSol(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        LC191NumberOf1Bits obj = new LC191NumberOf1Bits();
        int n = 00000000000000000000000000001011;
        System.out.println(obj.hammingWeight(n));

    }

}
