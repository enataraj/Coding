package leetcode.april;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC17LetterCombinationPhoneNumber {

    List<String> result = new ArrayList<>();
    String[] keyPad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        dfsHelpher(0, digits, new StringBuffer());
        return result;

    }

    private void dfsHelpher(int curLength, String digits, StringBuffer tmpResult) {
        if (curLength == digits.length()) {
            result.add(tmpResult.toString());
            return;
        }
        String str = keyPad[digits.charAt(curLength)-'0'];
        for (char c : str.toCharArray()) {
            tmpResult.append(c);
            dfsHelpher(curLength + 1, digits, tmpResult);
            tmpResult.deleteCharAt(tmpResult.length() - 1);
        }

    }

    public static void main(String[] args) {
        LC17LetterCombinationPhoneNumber obj = new LC17LetterCombinationPhoneNumber();
        System.out.println(obj.letterCombinations("234"));

    }

}
