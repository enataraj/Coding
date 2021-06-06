package leetcode.may;

public class LC906SuperPalindrome {

    public int superpalindromesInRange(String left, String right) {
        long leftVal = Long.parseLong(left);
        long rightVal = Long.parseLong(right);
        int result = 0;

        // Even Length Palindrome
        for (int i = 1; i < 100000; i++) {
            StringBuffer str = new StringBuffer(Integer.toString(i));
            for (int j = str.length() - 1; j >= 0; j--) {
                str.append(str.charAt(j));
            }
            long num = Long.valueOf(str.toString());
            num *= num;
            if (num > rightVal)
                break;
            if (num >= leftVal && isPalindrome(num)) {
                result++;
            }

        }

        // Odd Length Palindrome
        for (int i = 1; i < 100000; i++) {
            StringBuffer str = new StringBuffer(Integer.toString(i));
            for (int j = str.length() - 2; j >= 0; j--) {
                str.append(str.charAt(j));
            }
            long num = Long.valueOf(str.toString());
            num *= num;
            if (num > rightVal)
                break;
            if (num >= leftVal && isPalindrome(num)) {
                result++;
            }
        }
        return result;
    }

    private boolean isPalindrome(long val) {
        return val == reverse(val) ? true : false;
    }

    private long reverse(long val) {
        long rev = 0;
        while (val > 0) {
            rev = rev * 10 + val % 10;
            val = val / 10;

        }
        return rev;
    }

    public static void main(String[] args) {
        LC906SuperPalindrome obj = new LC906SuperPalindrome();
        String left = "4";
        String right = "1000";
        System.out.println(obj.superpalindromesInRange(left, right));
    }

}
