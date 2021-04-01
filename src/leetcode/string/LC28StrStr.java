package leetcode.string;

public class LC28StrStr {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (needle.equals(haystack.substring(i, i + needle.length()))) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStrSol2(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        int i = 0;
        if (n == 0) {
            return 0;
        }
        int start = 0;
        while (i < h - n + 1) {
            start = 0;
            while (start < n && haystack.charAt(i + start) == needle.charAt(start)) {
                start++;
            }
            if (start == n) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int strStrSol3(String haystack, String needle) {

        if (needle == null || needle.length() == 0)
            return 0;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {

                int j = 0;
                for (j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == needle.length()) {
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
        System.out.println(obj.strStr("hello", "lo"));
        System.out.println(obj.strStrSol3("hello", "lo"));
    }
}
