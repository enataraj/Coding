package leetcode.jan;

public class LC1662CHeckIfTwoStringAreEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        int i = 0, j = 0, wIdx1 = 0, wIdx2 = 0;

        while (wIdx1 < word1.length && wIdx2 < word2.length) {

            if (word1[wIdx1].charAt(i) != word2[wIdx2].charAt(j)) {
                return false;
            }
            i++;
            j++;
            if (i == word1[wIdx1].length()) {
                wIdx1++;
                i = 0;
            }

            if (j == word2[wIdx2].length()) {
                wIdx2++;
                j = 0;
            }

        }
        return wIdx1 == word1.length && wIdx2 == word2.length;

    }

    private String getWord(String[] word, int idx) {
        if (idx < word.length) {
            return word[idx];
        }
        return null;

    }

    public static void main(String[] args) {
        LC1662CHeckIfTwoStringAreEqual obj = new LC1662CHeckIfTwoStringAreEqual();
        String[] word1 = { "abc", "d", "defg" };
        String[] word2 = { "abcddefg" };
        System.out.println(obj.arrayStringsAreEqual(word1, word2));

    }

}
