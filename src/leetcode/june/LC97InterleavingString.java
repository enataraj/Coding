package leetcode.june;

public class LC97InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null && s3 == null) {
            return true;
        }
        if (s1 == null) {
            if (s2 != s3) {
                return false;
            }
        }
        if (s2 == null) {
            if (s1 != s3) {
                return false;
            }
        }

        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfsHelper(s1, s2, s3, 0, 0, 0, memo);

    }

    private boolean dfsHelper(String s1, String s2, String s3, int idx1, int idx2, int idx3, Boolean[][] memo) {
        if (idx1 == s1.length() && idx2 == s2.length() && idx3 == s3.length()) {

            return true;
        }
        if (memo[idx1][idx2] != null) {
            return memo[idx1][idx2];
        }
        boolean flag1 = false, flag2 = false;
        if (idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx3)) {
            flag1 = dfsHelper(s1, s2, s3, idx1 + 1, idx2, idx3 + 1, memo);
        }
        if (idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx3)) {
            flag2 = dfsHelper(s1, s2, s3, idx1, idx2 + 1, idx3 + 1, memo);
        }
        memo[idx1][idx2] = flag1 || flag2;
        return memo[idx1][idx2];
    }

    public static void main(String[] args) {
        LC97InterleavingString obj = new LC97InterleavingString();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(obj.isInterleave(s1, s2, s3));

    }

}
