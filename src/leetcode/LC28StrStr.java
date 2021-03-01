package leetcode;

public class LC28StrStr {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean flag = true;
                int j = 0;
                for (j = 0; j < needle.length() && (i + j) < haystack.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag && j == needle.length()) {
                    return i;
                }
            }
        }

        return -1;
    }
    
    

    public int strStrSol(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        int h = haystack.length();
        int n = needle.length();
        if (h < n)
            return -1;

        for (int i = 0; i <= h - n; i++) {
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
                // if reach to the end of needle string and all chars are equals, return i
                if (j == n - 1)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC28StrStr obj = new LC28StrStr();
        System.out.println(obj.strStr("hello", "ll"));
    }
}
