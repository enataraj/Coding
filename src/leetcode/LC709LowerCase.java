package leetcode;

public class LC709LowerCase {
    public String toLowerCase(String str) {
        if (str == null) {
            return null;
        }

        StringBuffer strBuff = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
                strBuff.append(ch);

            } else {
                strBuff.append(ch);

            }
        }

        return strBuff.toString();
    }

    public String toLowerCaseSol(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray())
            sb.append((char) (c | 32));
        return sb.toString();
    }

    public static void main(String[] args) {
        LC709LowerCase obj = new LC709LowerCase();
        String str = "Hellow";
        obj.toLowerCase(str);

    }

}
