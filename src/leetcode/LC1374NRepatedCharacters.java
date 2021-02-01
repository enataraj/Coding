package leetcode;

import java.util.Arrays;

public class LC1374NRepatedCharacters {
    public String generateTheStringAlt(int n) {
        StringBuffer sb = new StringBuffer();
        if (n % 2 == 0) {
            sb.append("b");
            n = n - 1;
        }
        char[] str = new char[n];
        Arrays.fill(str, 'a');
        sb.append(new String(str));
        return sb.toString();

    }
    public String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        if (n % 2 == 0) {
            sb.append("b");
            n = n - 1;
        }
      for(int i=0;i<n;i++) {
          sb.append('a');
      }
        return sb.toString();

    }

    public static void main(String[] args) {
        LC1374NRepatedCharacters obj = new LC1374NRepatedCharacters();
        int n = 5;
        System.out.println(obj.generateTheString(n));

    }

}
