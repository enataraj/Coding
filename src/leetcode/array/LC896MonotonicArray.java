package leetcode.array;

public class LC896MonotonicArray {

    public boolean isMonotonic(int[] A) {
        boolean increase = false;
        boolean decrease = false;

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] <= A[i]) {
                increase = true;
            } else {
                increase = false;
                break;
            }
        }

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] >= A[i]) {
                decrease = true;
            } else {
                decrease = false;
                break;
            }
        }

        return increase || decrease;

    }

    public static void main(String[] args) {
        LC896MonotonicArray obj = new LC896MonotonicArray();

    }

}
