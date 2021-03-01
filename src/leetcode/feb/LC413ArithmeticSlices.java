package leetcode.feb;

import java.util.ArrayList;
import java.util.List;

public class LC413ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3)
            return 0;

        int diff;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(A[0]);
        tmpList.add(A[1]);
        diff = A[1] - A[0];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - tmpList.get(tmpList.size() - 1) == diff) {
                tmpList.add(A[i]);
            } else {
                list.add(tmpList);
                int lastNum = tmpList.get(tmpList.size() - 1);
                tmpList = new ArrayList();
                tmpList.add(lastNum);
                tmpList.add(A[i]);
                diff = A[i] - lastNum;
            }

        }
        list.add(tmpList);

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() >= 3) {
                int n = list.get(i).size() - 2;
                result += (n * (n + 1)) / 2;
            }
        }

        System.out.println(list);
        return result;
    }
    

          
    
    public int numberOfArithmeticSlicesSol(int[] A) {
        int left = 0;
        int i = 1;
        Integer d = null;
        int ans = 0;
        for (; i<A.length; i++) {
            int nd = A[i] - A[i-1];
            if (d==null) {
                d = nd;                
            } else if (d != nd) {   
                int n = i - left;
                if (n >= 3) {
                    ans += (n-1)*(n-2)/2;
                }
                left = i-1;
                d = nd;
            }
        }
        int n = i - left;
        if (n >= 3) {
            ans += (n-1)*(n-2)/2;
        }
        return ans;        
    }
    
    
    public int numberOfArithmeticSlicesDP(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int[] dp = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int result = 0;
        for (int r : dp) {
            result += r;
        }
        return result;
    }

    public static void main(String[] args) {
        LC413ArithmeticSlices obj = new LC413ArithmeticSlices();
        int[] A = { 1, 2, 3, 6, 8, 10, 12 };
        System.out.println(obj.numberOfArithmeticSlices(A));
    }

}
