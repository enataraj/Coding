package leetcode.string;

public class LC1668MaximumepeatingSubsting {

    // Continuesly exist in the sequence

    public int maxRepeatingSol(String sequence, String word) {
        StringBuilder sb = new StringBuilder();
        int count = -1;
        while (sequence.contains(sb.toString())) {
            count++;
            sb.append(word);
        }

        return count;
    }

    // Exist anywhere in the sequence

    public int maxRepeating(String sequence, String word) {
        int cnt = 0;
        int i = 0;
        int seqLen = sequence.length();
        int wordLen = word.length();
        while (i < seqLen && i + wordLen <= seqLen) {
            String tmpStr = sequence.substring(i, i + seqLen);
            if (tmpStr.equals(word)) {
                cnt++;
                i = i + wordLen;
            } else {
                i += 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LC1668MaximumepeatingSubsting obj = new LC1668MaximumepeatingSubsting();
        String sequ = "ababab";
        String word = "ab";
        System.out.println(obj.maxRepeating(sequ, word));
    }

}
