package leetcode.sep;

public class RepeatedSubstring {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return false;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i, 2 * i);
            if (s1.equals(s2)) {
                String tmp = s.replace(s1, "");
                if (tmp.length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstring obj = new RepeatedSubstring();
        String str = "abcabcabcabc";
        System.out.println(obj.repeatedSubstringPattern(str));
    }

}
