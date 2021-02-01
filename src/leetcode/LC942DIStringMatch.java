package leetcode;

import java.util.Arrays;

public class LC942DIStringMatch {
    public int[] diStringMatch(String S) {
        int len = S.length();
        int res[] = new int[S.length() + 1];
        int low = 0;
        int high = len;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == 'I') {
                res[i] = low;
                low++;
            } else {
                res[i] = high;
                high--;
            }
        }
        if (S.charAt(len - 1) == 'I') {
            res[len] = low;
        } else {
            res[len] = high;
        }
        return res;
    }

    public static void main(String[] args) {
        LC942DIStringMatch obj = new LC942DIStringMatch();
        System.out.println(Arrays.toString(obj.diStringMatch("III")));

    }

}
