package leetcode.sep;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
