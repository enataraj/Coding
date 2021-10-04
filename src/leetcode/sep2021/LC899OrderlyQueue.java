package leetcode.sep2021;

import java.util.Arrays;

public class LC899OrderlyQueue {

    public String orderlyQueue(String s, int k) {
        char[] charArray = s.toCharArray();
        if (k > 1) {
            Arrays.sort(charArray);
            return new String(charArray);
        }

        String result = s;
        int i = 0;
        StringBuffer buffer = new StringBuffer(s);
        while (i < s.length()) {
            char tmp = buffer.charAt(0);
            buffer.deleteCharAt(0);
            buffer.append(tmp);
            if (result.compareTo(buffer.toString()) > 1) {
                result = buffer.toString();
            }
            i++;
        }
        return result;
    }

}
