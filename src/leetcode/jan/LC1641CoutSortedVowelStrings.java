package leetcode.jan;

public class LC1641CoutSortedVowelStrings {

    char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

    public int countVowelStrings(int n) {

        int res = 0;
        for (char ch : vowels) {
            res += dfsHelpherForCount(n - 1, ch);
        }
        return res;

    }

    private int dfsHelpherForCount(int n, char ch) {
        if (n == 0) {
            return 1;
        }
        int cnt = 0;

        for (int i = 0; i < vowels.length; i++) {
            if (ch >= vowels[i]) {
                cnt += dfsHelpherForCount(n - 1, vowels[i]);
            }
        }
        return cnt;
    }

   
    
    public int countVowelStringsVinit(int n) {
        return dfs(n, 0);
    }

    private int dfs(int n, int ch) {
        if (n == 0) {
            return 1;
        }
        int result = 0;
        for (int i = ch; i < 5; i++) {
            result += dfs(n - 1, i);
        }
        return result;
    }

  
    
    
    
    public int countVowelStringsDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        LC1641CoutSortedVowelStrings obj = new LC1641CoutSortedVowelStrings();
        int n = 4;
        System.out.println(obj.countVowelStrings(n));
        
        System.out.println(obj.countVowelStringsVinit(n));

    }

}
