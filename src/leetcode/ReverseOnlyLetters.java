package leetcode;

public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        char[] resArr = S.toCharArray();

        for (int i = 0, j = S.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetter(resArr[i])) {
                i++;
            }

            while (i < j && !Character.isLetter(resArr[j])) {
                j--;
            }

            char ch = resArr[i];
            resArr[i] = resArr[j];
            resArr[j] = ch;

        }

        return new String(resArr);

    }

}
