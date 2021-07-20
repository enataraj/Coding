package leetcode.weekly.week250;

public class MaxNumberOfWodCanType {

    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int result = 0;
        for (String word : words) {
            boolean flag = true;
            for (char ch : brokenLetters.toCharArray()) {
                if (word.indexOf(ch) != -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result++;
            }

        }
        return result;
    }

}
