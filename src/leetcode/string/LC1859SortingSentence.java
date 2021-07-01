package leetcode.string;

public class LC1859SortingSentence {
    public String sortSentence(String s) {
        String[] tmpArray = s.split(" ");
        String result[] = new String[tmpArray.length + 1];
        for (String str : tmpArray) {
            int idx = str.charAt(str.length() - 1) - '0';
            result[idx] = str.substring(0, str.length() - 1) + " ";
        }

        StringBuffer sentence = new StringBuffer();
        for (int i = 1; i < result.length; i++) {
            sentence.append(result[i]);

        }
        return sentence.toString().trim();

    }

    public String sortSentence0s(String s) {

        String[] sentence = s.split(" "); // break sentence up into different words
        String[] sortedSentence = new String[sentence.length];
        for (String word : sentence) {
            int position = word.charAt(word.length() - 1) - '0';
            sortedSentence[position - 1] = word.substring(0, word.length() - 1);
        }
        StringBuilder ssorted = new StringBuilder();
        for (int i = 0; i < sortedSentence.length - 1; i++) {
            ssorted.append(sortedSentence[i]).append(" ");
        }
        ssorted.append(sortedSentence[sortedSentence.length - 1]);
        return ssorted.toString();

    }

}
