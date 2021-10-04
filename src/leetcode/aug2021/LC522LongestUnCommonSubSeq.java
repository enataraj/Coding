package leetcode.aug2021;

public class LC522LongestUnCommonSubSeq {
    public int findLUSlength(String[] strs) {
        int result = -1;
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            if (strs[i].length() < result) {
                continue;
            }
            boolean isSubSequenceFound = false;
            int j = 0;
            for (j = 0; j < length && !isSubSequenceFound; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isSubSequenceFound = true;
                }
            }

            if (!isSubSequenceFound) {
                result = Math.max(result, strs[i].length());
            }
        }
        return result;
    }

    public boolean isSubsequence(String a, String b) {
        if (a.equals(b))
            return true;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length())
            if (a.charAt(i) == b.charAt(j++))
                i++;
        return i == a.length();
    }

    public int findLUSlengthw(String[] strs) {
        int result = -1, length = strs.length;
        for (int i = 0; i < length; i++) {
            if (strs[i].length() < result)
                continue;
            int j = -1;
            while (++j < length)
                if (i != j && isSubsequence(strs[i], strs[j]))
                    break;
            if (j == length)
                result = Math.max(result, strs[i].length());
        }
        return result;
    }

    public static void main(String[] args) {
        LC522LongestUnCommonSubSeq obj = new LC522LongestUnCommonSubSeq();
        String[] strs = { "aabbcc", "aabbcc", "c" };
        System.out.println(obj.findLUSlength(strs));
    }

}
