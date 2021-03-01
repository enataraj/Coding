package leetcode;

public class LC14LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int len = Integer.MAX_VALUE;
        for (int i = 1; i < strs.length; i++) {
            int tmp = 0;
            for (int j = 0; j < strs[i].length() && j < strs[0].length(); j++) {
                if (strs[i].charAt(j) == strs[0].charAt(j)) {
                    tmp++;
                } else {
                    break;
                }

            }
            len = Math.min(tmp, len);

        }

        if (len == Integer.MAX_VALUE)
            return "";
        return strs[0].substring(0, len);
    }
    
    public String longestCommonPrefixSol(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
        return pre;
    }

    public static void main(String[] args) {
        LC14LongestCommonPrefix obj = new LC14LongestCommonPrefix();

    }

}
