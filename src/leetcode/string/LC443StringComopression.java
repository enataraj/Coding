package leetcode.string;

import java.util.Arrays;

public class LC443StringComopression {
    public int compress(char[] chars) {
        int writeIdx = 0;
        char ch;
        int idx = 0;
        int length = chars.length;

        while (idx < chars.length) {
            ch = chars[idx];
            int cnt = 1;
            int curIdx = idx + 1;
            while (curIdx < length && ch == chars[curIdx]) {
                curIdx++;
                cnt++;
            }
            if (cnt == 1) {
                chars[writeIdx] = ch;
                writeIdx++;
            } else {
                chars[writeIdx] = ch;
                writeIdx++;
                String str = "" + cnt;
                for (char c : str.toCharArray()) {
                    chars[writeIdx] = c;
                    writeIdx++;
                }
            }
            idx = curIdx;
        }
      //  System.out.println(Arrays.toString(chars));
        return writeIdx;
    }

    public static void main(String[] args) {
        LC443StringComopression obj = new LC443StringComopression();
        char[] chars = {'a','a','a','a','b','b'};
        System.out.println(obj.compress(chars));
    }

}
