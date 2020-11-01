package leetcode.oct;

public class MinimumDominosRotation {

    public int minDominoRotations(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || (A.length != B.length)) {
            return -1;
        }

        int aCount = 0;
        int bCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == A[0]) {
                aCount++;
            }
            if (B[i] == B[0]) {
                bCount++;
            }
        }

        if (aCount == A.length || bCount == B.length) {
            return 0;
        }

        int aTarget = A[0];
        int bTarget = B[0];

        int aSwap = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == aTarget) {
                continue;
            }
            if (A[i] != aTarget && B[i] == aTarget) {
                aSwap++;
            } else {
                aSwap = Integer.MAX_VALUE;
                break;
            }

        }
        int bSwap = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i] == bTarget) {
                continue;
            }
            if (B[i] != bTarget && A[i] == bTarget) {
                bSwap++;
            } else {
                bSwap = Integer.MAX_VALUE;
                break;
            }
        }

        int res = Math.min(aSwap, bSwap);

        aTarget = B[0];
        bTarget = A[0];

        aSwap = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == aTarget) {
                continue;
            }
            if (A[i] != aTarget && B[i] == aTarget) {
                aSwap++;
            } else {
                aSwap = Integer.MAX_VALUE;
                break;
            }

        }
        bSwap = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i] == bTarget) {
                continue;
            }
            if (B[i] != bTarget && A[i] == bTarget) {
                bSwap++;
            } else {
                bSwap = Integer.MAX_VALUE;
                break;
            }
        }

        res = Math.min(res, Math.min(aSwap, bSwap));

        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;

    }
    
    
    public int minDominoRotationsOpt(int[] A, int[] B) {
        int res = A.length+1;
        if(A[0] == B[0]){
            res = Math.min(helper(A, B, 1, A[0]), helper(B, A, 1, A[0]));
        }else{
             // use A[0] && rotate to A
            res = Math.min(res, helper(A, B, 1, A[0]));

            // use A[0] && rotate to B
            res = Math.min(res, 1+helper(B, A, 1, A[0]));

            // use B[0] && rotate to A
            res = Math.min(res, 1+helper(A, B, 1, B[0]));

            // use B[0] && rotate to B
            res = Math.min(res, helper(B, A, 1, B[0]));
        }
       
        return res > A.length ? -1 : res;
    }
    
    public int helper(int[] A, int[] B, int idx, int val){
        int cnt = 0;
        for(int i=idx; i<A.length; i++){
            if(A[i] == val) ;
            else if(B[i] != val) return A.length+1;
            else cnt++;
        }
        return cnt;

    
    }
    
    
    
    public int check(int x, int[] A, int[] B, int n) {
        // how many rotations should be done
        // to have all elements in A equal to x
        // and to have all elements in B equal to x
        int rotations_a = 0, rotations_b = 0;
        for (int i = 0; i < n; i++) {
          // rotations coudn't be done
          if (A[i] != x && B[i] != x) return -1;
          // A[i] != x and B[i] == x
          else if (A[i] != x) rotations_a++;
          // A[i] == x and B[i] != x    
          else if (B[i] != x) rotations_b++;
        }
        // min number of rotations to have all
        // elements equal to x in A or B
        return Math.min(rotations_a, rotations_b);
      }

      public int minDominoRotationsOpt1(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A[0], B, A, n);
        
        // If one could make all elements in A or B equal to A[0]
        if (rotations != -1) return rotations;
        // If one could make all elements in A or B equal to B[0]
        else return check(B[0], B, A, n);
      }

    public static void main(String[] args) {
        MinimumDominosRotation obj = new MinimumDominosRotation();
        int[] B = { 2, 1, 2, 4, 2, 2 };
        int[] A = { 5, 2, 6, 2, 3, 2 };
        // int[] A = { 3, 5, 1, 2, 3 };
        // int[] B = { 3, 6, 3, 3, 4 };

        System.out.println(obj.minDominoRotations(A, B));

    }

}
