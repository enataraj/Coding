package leetcode.march;

public class LC1332RemovePalindromicSubSequences {

    public int removePalindromeSub(String s) {
        // 0 case
        if (s.length() == 0 || s.isEmpty())
            return 0;
        // 2 case
        int startIndex = 0;
        int endIndex = s.length() - 1;
        while (startIndex <= endIndex) {
            if (s.charAt(startIndex++) != s.charAt(endIndex--))
                return 2;
        }
        // 1 case
        return 1;
    }

    public static void main(String[] args) {

        LC1332RemovePalindromicSubSequences obj = new LC1332RemovePalindromicSubSequences();

    }
}
