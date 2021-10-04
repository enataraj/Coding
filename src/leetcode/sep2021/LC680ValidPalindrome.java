package leetcode.sep2021;

public class LC680ValidPalindrome {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(left + 1, right, s) || isPalindrome(left, right - 1, s);
            }

            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(int left, int right, String s) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        LC680ValidPalindrome obj = new LC680ValidPalindrome();
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(obj.validPalindrome(s));
        String s1 = Integer.toBinaryString(2);
        
    }

}
