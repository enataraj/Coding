package leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC989FormArray {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> resultList = new ArrayList<>();
        if ((A == null || A.length == 0) && K == 0) {
            resultList.add(0);
            return resultList;
        }

        int i = A.length - 1;
        int carry = 0;
        while (i >= 0 || K > 0) {
            int rem = K % 10;
            K = K / 10;
            int sum = 0;
            if (i >= 0) {
                sum = A[i] + rem + carry;
            } else {
                sum = rem + carry;
            }
            resultList.add(sum % 10);
            carry = sum / 10;
            i--;

        }
        if (carry != 0) {
            resultList.add(carry);
        }
        Collections.reverse(resultList);
        return resultList;

    }
    
    public List<Integer> addToArrayFormSol1(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        LC989FormArray obj = new LC989FormArray();
        int[] A = { 0 };
        int K = 123;
        System.out.println(obj.addToArrayForm(A, K));
    }

}
