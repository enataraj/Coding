package leetcode.string;

public class LC1880CheckWordSummation {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        StringBuffer firstBuffer = new StringBuffer();
        StringBuffer secondBuffer = new StringBuffer();
        StringBuffer thirdBuffer = new StringBuffer();

        for (char ch : firstWord.toCharArray()) {
            firstBuffer.append(ch - 'a');
        }
        for (char ch : secondWord.toCharArray()) {
            secondBuffer.append(ch - 'a');
        }

        for (char ch : targetWord.toCharArray()) {
            thirdBuffer.append(ch - 'a');
        }

        return (Integer.parseInt(firstBuffer.toString()) + Integer.parseInt(secondBuffer.toString())) == Integer
                .parseInt(thirdBuffer.toString()) ? true : false;

    }

    public boolean isSumEqualSol(String firstWord, String secondWord, String targetWord) {
        int f = 0, s = 0, t = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            f = f * 10 + firstWord.charAt(i) - 'a';
        }
        for (int j = 0; j < secondWord.length(); j++) {
            s = s * 10 + secondWord.charAt(j) - 'a';
        }
        for (int k = 0; k < targetWord.length(); k++) {
            t = t * 10 + targetWord.charAt(k) - 'a';
        }

        return f + s == t;
    }

    public static void main(String[] args) {
        LC1880CheckWordSummation obj = new LC1880CheckWordSummation();
        String firstWord = "acb";
        String secondWord = "cba";
        String targetWord = "cdb";
        System.out.println(obj.isSumEqual(firstWord, secondWord, targetWord));

    }

}
