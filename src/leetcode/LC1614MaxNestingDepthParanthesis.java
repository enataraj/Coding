package leetcode;

public class LC1614MaxNestingDepthParanthesis {

    public int maxDepth(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int depth = Integer.MIN_VALUE;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            depth = Math.max(depth, count);
            if (ch == ')')
                count--;
        }

        return depth;

    }

    public static void main(String[] args) {
        LC1614MaxNestingDepthParanthesis obj = new LC1614MaxNestingDepthParanthesis();
       // String s = "(1)+((2))+(((3)))";
       // String s = "";
        String s = "1+(2*3)/(2-1)";
        System.out.println(obj.maxDepth(s));
    }

}
