package leetcode.topint;

public class LC125ValidPalindrome {

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeMine(String s) {

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

}
