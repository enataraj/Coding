package recursion;

import java.util.LinkedList;
import java.util.List;

public class LC784LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new LinkedList<>();
        dfsHelpher(S.toCharArray(), 0, list);
        return list;
    }

    private void dfsHelpher(char[] charArray, int pos, List<String> list) {
        if (pos == charArray.length) {
            list.add(new String(charArray));
            return;
        }

        if (charArray[pos] >= '0' && charArray[pos] <= '9') {
            dfsHelpher(charArray, pos + 1, list);
            return;
        }

        charArray[pos] = Character.toUpperCase(charArray[pos]);
        dfsHelpher(charArray, pos + 1, list);

        charArray[pos] = Character.toLowerCase(charArray[pos]);
        dfsHelpher(charArray, pos + 1, list);

    }

}
