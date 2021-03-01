package leetcode;

public class LC1309DecryptString {

    public String freqAlphabets(String s) {
        StringBuffer str = new StringBuffer();
        int i = 0;
        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                // System.out.println(s.substring(i, i+2));
                char ch = (char) (Integer.parseInt(s.substring(i, i + 2)) - 1 + 'a');
                str.append(ch);
                i = i + 3;
            } else {
                // System.out.println(s.substring(i, i+1));
                char ch = (char) (Integer.parseInt(s.substring(i, i + 1)) - 1 + 'a');
                str.append(ch);
                i = i + 1;
            }

        }
        return str.toString();
    }
    
    public String freqAlphabetsSol(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(i < len - 2 && s.charAt(i + 2) == '#') {
        sb.append((char)('j' + (s.charAt(i) - '1') * 10 + (s.charAt(i + 1) - '0')));
                i += 2;
            }
            else {
                sb.append((char)('a' + (s.charAt(i) - '1')));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC1309DecryptString obj = new LC1309DecryptString();
        System.out.println(obj.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
        System.out.println(obj.freqAlphabets("10#11#12"));
    }

}
