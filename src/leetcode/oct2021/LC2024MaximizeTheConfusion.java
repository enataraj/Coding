package leetcode.oct2021;

public class LC2024MaximizeTheConfusion {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int k2 = k;
        int i = 0, j;
        for (j = 0; j < answerKey.length(); j++) {
            if (answerKey.charAt(j) == 'T')
                k--;
            if (k < 0 && answerKey.charAt(i++) == 'T')
                k++;
        }
        int x = 0, y;
        for (y = 0; y < answerKey.length(); y++) {
            if (answerKey.charAt(y) == 'F')
                k2--;
            if (k2 < 0 && answerKey.charAt(x++) == 'F')
                k2++;
        }
        return Math.max(j - i, y - x);
    }

    public static void main(String[] args) {
        LC2024MaximizeTheConfusion obj = new LC2024MaximizeTheConfusion();
        String answerKey = "TTFTTFTT";
        int k = 1;
        System.out.println(obj.maxConsecutiveAnswers(answerKey, k));

        /*
         * 
                while (start <= end && (tCnt > k || fCnt > k)) {
                    if (answerKey.charAt(start) == 'T') {
                        tCnt--;
                    } else {
                        fCnt--;
                    }
                    start++;
                }
            
         */
    }
}
