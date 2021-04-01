package general;

public class LC1616SplitTwoStingMakePalindrome {

    /*
     * ulacfd
     * jizalu
     * 
     * ula madam cfd
     * 
     * jizabcde alu
     * 
     * 
     */

    public boolean checkPalindromeFormation(String a, String b) {
        return checkPalindromeSubString(a, b) || checkPalindromeSubString(b, a);

    }

    private boolean checkPalindromeSubString(String a, String b) {

        int left = 0;
        int right = a.length() - 1;

        while (left < right) {
            if (a.charAt(left) == b.charAt(right)) {
                left++;
                right--;

            } else {
                break;
            }
        }

        if (isPalindrome(a, left, right)) {
            return true;
        }

        if (isPalindrome(b, left, right)) {
            return true;
        }
        return false;

    }

    private boolean isPalindrome(String a, int left, int right) {
        while (left < right) {
            if (a.charAt(left) != a.charAt(right)) {
                return false;
            }
            left++;
            right--;

        }
        return true;

    }

    public static void main(String[] args) {
        LC1616SplitTwoStingMakePalindrome obj = new LC1616SplitTwoStingMakePalindrome();
        String a = "abd ef";
        String b = "fec ab";
        System.out.println(obj.checkPalindromeFormation(a, b));
    }
}
