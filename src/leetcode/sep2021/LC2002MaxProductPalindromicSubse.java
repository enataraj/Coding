package leetcode.sep2021;

public class LC2002MaxProductPalindromicSubse {
    public int maxProduct(String s) {
        return maxProduct(0, s, "", "");
    }

    private int maxProduct(int currentIndex, String s, String s1, String s2) {
        if (currentIndex == s.length()) {
            if (isPalindrome(s1) && isPalindrome(s2))
                return s1.length() * s2.length();
            return 1;
        }
        int p1 = maxProduct(currentIndex + 1, s, s1 + s.charAt(currentIndex), s2);
        int p2 = maxProduct(currentIndex + 1, s, s1, s2 + s.charAt(currentIndex));
        int p3 = maxProduct(currentIndex + 1, s, s1, s2);
        return Math.max(p1, Math.max(p2, p3));
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start += 1;
            end -= 1;
        }
        return true;
    }

}
