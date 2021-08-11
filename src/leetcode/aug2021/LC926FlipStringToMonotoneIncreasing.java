package leetcode.aug2021;

public class LC926FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int[] leftOnes = new int[s.length()];
        int[] rightZeros = new int[s.length()];

        int cnt = 0;
        for (int i = 0; i < leftOnes.length; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            }

            leftOnes[i] = cnt;
        }
        cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                cnt++;
            }
            rightZeros[i] = cnt;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < leftOnes.length; i++) {
            result = Math.min(result, leftOnes[i] + rightZeros[i]-1);
        }

        return result;

    }

    public int minFlipsMonoIncrSol(String s) {
        int onesCnt = 0;
        int flipCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (onesCnt == 0) {
                    continue;
                }
                flipCnt++;
            } else {

                onesCnt++;
            }
            if (flipCnt > onesCnt) {
                flipCnt = onesCnt;
            }
        }
        return flipCnt;
    }

    public static void main(String[] args) {
        LC926FlipStringToMonotoneIncreasing obj = new LC926FlipStringToMonotoneIncreasing();
        System.out.println(obj.minFlipsMonoIncr("0101100011"));

        System.out.println(obj.minFlipsMonoIncr("10011111110010111011"));
    }

}
