package leetcode;

public class Subsequence {

    public boolean isSubsequence(String s, String t) {

        int si = 0;
        int se = s.length() - 1;
        int ti = 0;
        
        int te = t.length() - 1;
        if (s == t) {
            return true;
        }
        while (si <= se && ti <= te) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
                ti++;
            } else {
                ti++;
            }
            if (s.charAt(se) == t.charAt(te)) {
                se--;
                te--;
            } else {
                te--;
            }

        }

        if (si > se) {
            return true;
        }
        return false;

    }

    public boolean isSubsequence_another(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()){
            index = t.indexOf(c, index + 1);
            if (index == -1)
                return false;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        String s = "z";
        String t = "ahbgdc";
        boolean res = new Subsequence().isSubsequence(s, t);
        System.out.println("Result : " + res);
    }

}
