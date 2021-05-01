package leetcode.april;

import java.util.TreeSet;

public class LC775GlobalAndLocal {

    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) > 1)
                return false;
        }
        return true;
    }

    public boolean isIdealPermutation_1(int[] A) {
        int localInv = 0;
        int globalInv = 0;
        int length = A.length - 1;

        for (int i = 0; i < length; i++) {
            if (A[i] > i) {
                globalInv += (A[i] - i);
            }
            if (A[i] > A[i + 1]) {
                localInv += 1;
            }
            if (A[i] == i && A[i] > A[i + 1]) {
                globalInv += 1;
            }
        }
        if (localInv == globalInv)
            return true;
        return false;

    }

    // Binary Search
    public boolean isIdealPermutationBinary(int[] A) {
        if (A == null || A.length <= 1) {
            return true;
        }
        final TreeSet<Integer> s = new TreeSet();
        s.add(A[A.length - 1]);
        int li = 0, gi = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                li++;
            }
            s.add(A[i]);
            gi += s.headSet(A[i]).size();
        }
        return li == gi;
    }

    // Segment Tree
    public boolean isIdealPermutationSol1(int[] A) {
        int sum = 0, currSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += i;
            currSum += A[i];
            if (currSum - sum > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isIdealPermutationSol2(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) >= 2) {
                return false;
            }
        }
        return true;
    }

    public boolean isIdealPermutationSol3(int[] A) {
        if (A.length < 3) {
            return true;
        }
        int minValue = A[A.length - 1];
        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] > minValue) {
                return false;
            }
            minValue = Math.min(minValue, A[i + 1]);
        }
        return true;
    }

    public boolean isIdealPermutationSol4(int[] A) {
        int total = A.length;
        if (A.length < 3)
            return true;

        for (int i = 0; i < A.length; i++) {
            int higher = (total - 1) - A[i];
            int remSpace = total - i - 1;
            if (remSpace <= higher)
                continue;
            else if (remSpace == higher + 1) {
                if (A[i + 1] > A[i])
                    return false;
            } else {
                return false;
            }
        }
        return true;

    }

    public boolean isIdealPermutationSol5(int[] A) {
        int max = -1;

        for (int i = 0; i < A.length - 2; i++) {
            max = Math.max(max, A[i]);

            if (max > A[i + 2])
                return false;
        }

        return true;
    }

    public boolean isIdealPermutationTLE(int[] A) {
        if (A == null || A.length <= 1) {
            return true;
        }
        int localInversion = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                localInversion++;
            }
        }
        int globalInversion = 0;

        for (int i = 0; i < A.length; i++) {
            int num1 = A[i];
            int j = i + 1;
            while (j < A.length) {
                int num2 = A[j];
                if (num1 > num2) {
                    globalInversion++;
                }
                j++;

            }
        }
        if (localInversion == globalInversion) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        LC775GlobalAndLocal obj = new LC775GlobalAndLocal();
        int A[] = { 1, 0, 2 };
        System.out.println(obj.isIdealPermutation(A));

    }

}
