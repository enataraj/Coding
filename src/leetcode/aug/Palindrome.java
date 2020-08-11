package leetcode.aug;

public class Palindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return true;
        }

        s = s.toLowerCase().trim();
        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            if ((s.charAt(l) >= 'a' && s.charAt(l) <= 'z') || (s.charAt(l) >= '0' && s.charAt(l) <= '9')) {
                if ((s.charAt(r) >= 'a' && s.charAt(r) <= 'z') || (s.charAt(r) >= '0' && s.charAt(r) <= '9')) {
                    if (s.charAt(l) != s.charAt(r)) {
                        return false;
                    }
                    l++;
                    r--;

                } else {
                    r--;
                }

            } else {
                l++;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        Palindrome obj = new Palindrome();
        String str ="A man, a plan, a canal: Panama";
        System.out.println(obj.isPalindrome(str));

    }

}
