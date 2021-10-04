package leetcode.sep2021;

public class LC806NumberOfLines {
    public int[] numberOfLines(int[] widths, String s) {
        int sum = 0;
        int line = 1;
        for (char ch : s.toCharArray()) {
            if (sum + widths[ch - 'a'] > 100) {
                line++;
                sum = 0;
            }
            sum += widths[ch - 'a'];
        }
        return new int[] { line, sum };
    }

}
