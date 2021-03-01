package leetcode.string;

public class LC541ReverseStringII {

    public String reverseStr(String s, int k) {
        if (s == null)
            return s;
        char[] charArray = s.toCharArray();
        int end = Math.min(k - 1, s.length() - 1);
        int start = 0;

        while (start < s.length()) {
            reverseString(charArray, start, end);
            start = start + (2 * k);
            end = Math.min(start + k - 1, s.length() - 1);
        }

        return new String(charArray);

    }

    private void reverseString(char[] charArray, int start, int end) {

        while (start < end) {
            char ch = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = ch;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        LC541ReverseStringII obj = new LC541ReverseStringII();
        String s = "abcdefgh";
        int k = 3;
        System.out.println(obj.reverseStr(s, k));
    }

}
