package leetcode.recursion;

public class ArrayRecursion {

    // Printing via Recursion
    private void arrayRecursion(int[] A, int idx) {
        if (idx == A.length) {
            return;
        }
        System.out.println("Pre : " + A[idx]);
        arrayRecursion(A, idx + 1);
        System.out.println("Post:" + A[idx]);
    }

    private void splitArrayRecursion(int[] A, int idx) {
        if (idx == A.length) {
            return;
        }
        System.out.println("Pre : " + A[idx]);
        for (int i = 0; i < idx; i++) {
            splitArrayRecursion(A, idx + 1);
        }

    }

    public static void main(String[] args) {
        ArrayRecursion obj = new ArrayRecursion();
        int[] A = { 1, 2, 3, 4, 5 };
        // obj.arrayRecursion(A, 0);
        obj.splitArrayRecursion(A, 1);

    }
}
