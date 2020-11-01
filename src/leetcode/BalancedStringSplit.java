package leetcode;

public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        int lCount = 0;
        int rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                lCount++;

            } else if (s.charAt(i) == 'R') {
                rCount++;
            }
            if (lCount == rCount) {
                count++;
            }

        }

        return count;

    }

    public static void main(String[] args) {
        BalancedStringSplit obj = new BalancedStringSplit();
       // String s = "LLLLRRRR";   
        String s = "RLRRLLRLRL";
        System.out.println(obj.balancedStringSplit(s));

    }

}
