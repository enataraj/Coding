package leetcode.july2021;

import java.util.ArrayList;
import java.util.List;

public class LC89GrayCode {
    /*
     *   2
     *   00
     *   01
     *   10
     *   11
     *   
     *   n
     */
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int num = (int) Math.pow(2, n) - 1;
        for (int i = 0; i < num; i++) {
            int res = i ^ (i >> 1);
            list.add(res);

        }
        return list;
    }

    int nextNum = 0;

    public List<Integer> grayCodeSol(int n) {
        List<Integer> result = new ArrayList<>();
        grayCodeHelper(result, n);
        return result;
    }

    private void grayCodeHelper(List<Integer> result, int n) {
        if (n == 0) {
            result.add(nextNum);
            return;
        }
        grayCodeHelper(result, n - 1);
        // Flip the bit at (n - 1)th position from right
        nextNum = nextNum ^ (1 << (n - 1));
        grayCodeHelper(result, n - 1);

    }

    public List<Integer> grayCodeAlt(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        for (int digit = 1; digit < n; digit++) {
            List<Integer> prev = new ArrayList<>(res);
            for (int i = prev.size() - 1; i >= 0; i--) {
                int leading = 1 << digit;
                res.add(leading | prev.get(i));
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        LC89GrayCode obj = new LC89GrayCode();
        System.out.println(obj.grayCode(5));
    }

}
