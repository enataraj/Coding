package leetcode.sep2021;

import java.util.Arrays;
import java.util.List;

public class LC1239MaxLengthOfConcatenated {

    int result = 0;

    public int maxLength(List<String> arr) {

        dfsHelper(0, arr, new StringBuffer());
        return result;
    }

    private void dfsHelper(int idx, List<String> list, StringBuffer curBuffer) {
        if (idx >= list.size()) {
            if (curBuffer.length() == 0 || curBuffer.length() <= result || curBuffer.length() > 26) {
                return;
            }
            isUnique(curBuffer);
            return;
        }
        if (!isUnique(curBuffer)) {
            return;
        }
        StringBuffer buffer = new StringBuffer(curBuffer);
        dfsHelper(idx + 1, list, buffer);
        dfsHelper(idx + 1, list, buffer.append(list.get(idx)));

    }

    private boolean isUnique(StringBuffer curBuffer) {
        boolean[] chMap = new boolean[26];
        for (int i = 0; i < curBuffer.length(); i++) {
            char ch = curBuffer.charAt(i);
            if (!chMap[ch - 'a']) {
                chMap[ch - 'a'] = true;
            } else {
                return false;
            }
        }
        result = Math.max(result, curBuffer.length());
        return true;

    }

    public static void main(String[] args) {
        LC1239MaxLengthOfConcatenated obj = new LC1239MaxLengthOfConcatenated();
        String[] arr = { "un", "iq", "ue" };
        List<String> list = Arrays.asList(arr);
        System.out.println(obj.maxLength(list));
    }

}
