package leetcode.may;

public class LC709ToLowerCase {

    public String toLowerCase(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
                charArray[i] = charArray[i] = (char) ('a' + charArray[i] - 'A');

            }
        }
        return new String(charArray);
    }

}
