package leetcode;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int orgNum = x;
        int revNum = 0;

        while (x > 0) {
            revNum = (revNum * 10) + (x % 10);
            x = x / 10;

        }

        if (orgNum == revNum) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        PalindromeNumber obj = new PalindromeNumber();
        int x = 121;
        System.out.println(obj.isPalindrome(x));

    }

}
