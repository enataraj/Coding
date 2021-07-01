package leetcode.string;

public class LC1869LongestSubSequence {

    public boolean checkZeroOnes(String s) {

        int cntZero = 0;
        int cntOne = 0;
        int tmpZero = 0;
        int tmpOne = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                cntZero = Math.max(cntZero, tmpZero);
                tmpZero = 0;
                tmpOne++;

            } else {
                cntOne = Math.max(tmpOne, cntOne);
                tmpOne = 0;
                tmpZero++;

            }

        }
        cntZero = Math.max(cntZero, tmpZero);
        cntOne = Math.max(tmpOne, cntOne);
        return cntOne > cntZero ? true : false;

    }

    public boolean checkZeroOnesAlt(String s) {
        int maxOne = 0, maxZero = 0;
        int itrOne = 0, itrZero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                itrZero++;
                maxZero = Math.max(maxZero, itrZero);
                itrOne = 0;
            } else {
                itrOne++;
                maxOne = Math.max(maxOne, itrOne);
                itrZero = 0;
            }
        }
        return (maxOne > maxZero);
    }

}
