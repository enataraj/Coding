package leetcode;

public class LC1768MergeTwoStrings {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        StringBuffer strBuffer = new StringBuffer();
        while (i < word1.length() && i < word2.length()) {
            strBuffer.append(word1.charAt(i));
            strBuffer.append(word2.charAt(i));
            i++;
        }
        if (i < word1.length()) {
            strBuffer.append(word1.substring(i, word1.length()));
        }
        if (i < word2.length()) {
            strBuffer.append(word2.substring(i, word2.length()));
        }
        return strBuffer.toString();
    }

    public static void main(String[] args) {
        LC1768MergeTwoStrings obj = new LC1768MergeTwoStrings();
        String word2 = "Elu";
        String word1 = "Malai";
        System.out.println(obj.mergeAlternately(word1, word2));
    }

}
