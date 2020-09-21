package leetcode.sep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {

    public List<Integer> sequentialDigitsTLE(int low, int high) {

        List<Integer> resultList = new ArrayList<>();

        for (int i = low; i < high; i++) {
            if (isSequential(i + "")) {
                resultList.add(i);
            }

        }

        return resultList;

    }

    private boolean isSequential(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) + 1 != str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> sequentialDigits(int low, int high) {

        StringBuffer str = new StringBuffer();
        List<Integer> result = new ArrayList<>();
        for (int k = 1; k <= 9; k++) {
            str = new StringBuffer();
            for (int i = k; i <= 9; i++) {
                str.append(i);

                int number = Integer.parseInt(str.toString());
                if (number >= low && number <= high) {
                    result.add(number);
                }
            }
        }
        Collections.sort(result);
        return result;

    }

    public List<Integer> sequentialDigitsOpt(int low, int high) {

        List<Integer> output = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            int num = 0, j = i;
            while (num <= high && j < 10) {
                num = num * 10 + (j);
                if (num >= low && num <= high) {
                    output.add(num);
                }
                j++;
            }
        }
        Collections.sort(output);
        return output;
    }

    /*
     * def sequentialDigits(self, low: int, high: int) -> List[int]:
     * 
     * def rec(currStr,nextNum, len_str):
     * 
     * if len(currStr) == len_str: if low <= int(currStr) <= high:
     * res.append(currStr) return
     * 
     * if nextNum > 9: return
     * 
     * rec(currStr+str(nextNum), nextNum+1, len_str)
     * 
     * 
     * res = [] for len_str in range(len(str(low)), len(str(high))+1): for j in
     * range(1, 10): rec('',j, len_str)
     * 
     * return res
     */

    public List<Integer> sequentialDigitsRec(int low, int high) {
        List<Integer> res = new ArrayList<>();

        for (int j = 0; j <= 10; j++) {
            dfsHelper(new StringBuffer(), j, 3, low, high, res);
        }

        System.out.println(res);

        return res;
    }

    private void dfsHelper(StringBuffer currStr, int nextNum, int len, int low, int high, List<Integer> res) {
        if (currStr.length() == len) {
            int num = Integer.parseInt(currStr.toString());
            if (low <= num && num <= high) {
                res.add(num);
                return;
            }
        }

        if (nextNum > 9) {
            return;
        }

        dfsHelper(currStr.append(nextNum), nextNum + 1, len, low, high, res);

    }

    public static void main(String[] args) {
        SequentialDigits obj = new SequentialDigits();
        System.out.println(obj.sequentialDigitsRec(100, 999));
    }

}
