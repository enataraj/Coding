package leetcode.jan;

public class LC5LongestPalindromicSubstring {
    int length = 0;
    int startPos = 0;

    public String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;

        String result = "";

        for (int i = 0; i < s.length(); i++) {

            lengthOfPalindrom(s, i, i);
            lengthOfPalindrom(s, i, i + 1);
            result = s.substring(startPos, length + startPos);

        }

        return result;

    }

    private void lengthOfPalindrom(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if (length < right - left - 1) {
            length = right - left - 1;
            startPos = left + 1;

        }

    }

    public static void main(String[] args) {
        LC5LongestPalindromicSubstring obj = new LC5LongestPalindromicSubstring();
        String s = "abbbc";
        System.out.println(obj.longestPalindrome(s));

    }

}
