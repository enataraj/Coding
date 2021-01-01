package leetcode;

public class LC1662TwoStringAreEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer str1 = new StringBuffer();
        StringBuffer str2 = new StringBuffer();

        for (String s : word1) {
            str1.append(s);
        }
        for (String s : word2) {
            str2.append(s);
        }

        return str1.toString().equals(str2.toString());

    }

    public static void main(String[] args) {
        LC1662TwoStringAreEqual obj = new LC1662TwoStringAreEqual();
        String[] word1 = { "a", "bc" };
        String[] word2 = { "ab", "c" };
        System.out.println(obj.arrayStringsAreEqual(word1, word2));

    }

}
