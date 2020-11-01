package leetcode;

import java.util.Arrays;

public class LC1528SuffleString {

    public String restoreString(String s, int[] indices) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] ch_array = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            ch_array[indices[i]] = s.charAt(i);
        }
       // System.out.println(Arrays.toString(ch_array));
        return new String(ch_array);
    }

    public String restoreStringa(String s, int[] indices) {
        int n = indices.length;
        char arr[] = new char[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            arr[indices[i]] = s.charAt(j++);
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        LC1528SuffleString obj = new LC1528SuffleString();
        int[] indices = { 4, 5, 6, 7, 0, 2, 1, 3 };
        String s = "codeleet";
        System.out.println(obj.restoreString(s, indices));
    }

}
