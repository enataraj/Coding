package leetcode.aug;

public class TitleToColumnNumber {

    public int titleToNumber(String s) {

        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        int titleToNum = 0;
        int pow = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int val = s.charAt(i) - 64;
            titleToNum = titleToNum + val * (int) (Math.pow(26, pow));
            pow++;
        }
        return titleToNum;

    }
    
    
    public int titleToNumberParin(String s) {
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            num = (num * 26) + (ch - 'A' + 1);
        }
        
        return num;
    }

    public static void main(String[] args) {
        TitleToColumnNumber obj = new TitleToColumnNumber();
        String s = "FXSHRXW";
        System.out.println(obj.titleToNumber(s));

    }

}
