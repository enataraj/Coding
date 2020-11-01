package leetcode;

public class DifferentChar {

    public char findTheDifference(String s, String t) {

        if (s == null || t == null || s.length() == t.length()) {

            return '\0';
        }
        int sum1 = 0, sum2 = 0;
        int len = Math.min(s.length(), t.length());

        for (int i = 0; i < len; i++) {
            sum1 += s.charAt(i) - 'a';
            sum2 += t.charAt(i) - 'a';
        }
        
        char res;

        if (s.length() > t.length()) {
            sum1 += s.charAt(len) - 'a';
            res = (char) (sum1 - sum2 + 'a');
           
        } else {
            sum2 += t.charAt(len) - 'a';
            res = (char) (sum2 - sum1 + 'a');
           
        }

        return res;
    }
    
    public char findTheDifferenceBit(String s, String t) {
        char diff = t.charAt(t.length() - 1);
        
        for (int i = 0; i < s.length(); i += 1) {
            diff ^= s.charAt(i);
            diff ^= t.charAt(i);
        }

        return diff;
    }

    public static void main(String[] args) {
        DifferentChar obj = new DifferentChar();
        String s = "abcd";
        String t = "abcde";
        System.out.println(obj.findTheDifference(s, t));

    }

}
