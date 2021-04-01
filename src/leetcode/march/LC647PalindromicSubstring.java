package leetcode.march;

public class LC647PalindromicSubstring {

    public int countSubstringsSol1(String s) {

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // Consider Each Char is centre of the Palindrome and Expand both side
            int j = i;
            int k = i;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {

                result++;
                j--;
                k++;
            }

            // Consider i+1 char is as center of the Palindrome and expand both side
            j = i;
            k = i + 1;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                result++;
                j--;
                k++;
            }
        }

        return result;

    }

    private int result = 0;

    public int countSubstrings(String s) {

        for (int i = 0; i < s.length(); i++) {
            palindromicCount(s, i, i);
            palindromicCount(s, i, i + 1);
        }
        return result;
    }

    public void palindromicCount(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            result++;
        }

    }

 
    // Brute Force
    public int countSubstrings_BF(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = s.length();
        for (int i = 1; i < s.length(); i++) {
            int j = 0;
            int k = j + i;
            while (k < s.length()) {
                if (isPalindrome(s, j, k)) {
                    result++;
                }
                j = j + 1;
                k = j + i;
            }

        }
        return result;
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int countSubstringsDP(String s) {
        int n = s.length(), ans = 0;

        if (n <= 0)
            return 0;

        boolean[][] dp = new boolean[n][n];

        // Base case: single letter substrings
        for (int i = 0; i < n; ++i, ++ans)
            dp[i][i] = true;

        // Base case: double letter substrings
        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            ans += (dp[i][i + 1] ? 1 : 0);
        }

        // All other cases: substrings of length 3 to n
        for (int len = 3; len <= n; ++len)
            for (int i = 0, j = i + len - 1; j < n; ++i, ++j) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                ans += (dp[i][j] ? 1 : 0);
            }

        return ans;
    }

    // DFS
    private int count = 0;
    public int countSubstringsDFS(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        dfs(s, 0, 1);
        return count;
    }

    public void dfs(String s, int start, int end) {

        if (start == s.length() && end == s.length()) {
            return;
        }
        if (end == s.length() + 1) {
            dfs(s, start + 1, start + 1);
        } else {
            if ((end-start)>0 && isPalindrome(s,start,end-1)) {
                count += 1;
            }
            dfs(s, start, end + 1);
        }
    }

    /*
     *  
     *  public static void generate(String word) {
        if (word.length() == 1) {
            System.out.println(word);
            return;
        }else{
            System.out.println(word);
            generate(word.substring(0, word.length()-1)); 
            generate(word.substring(1, word.length())); 
        }
    
    }
     */

    public boolean isPalindrome(String s) {
      //  System.out.println(s);
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        LC647PalindromicSubstring obj = new LC647PalindromicSubstring();
        //  String s = "abcd";
        System.out.println(obj.countSubstringsDFS("aaaa"));

    }

}
