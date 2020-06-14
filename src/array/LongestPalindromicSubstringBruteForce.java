package array;

public class LongestPalindromicSubstringBruteForce {

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        int len = longestPalindromicSubstring(str);
        System.out.println("Max String " + len);
    }

    private static int longestPalindromicSubstring(String s) {
        int len = 0;
        String res = "";
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {

                String test = s.substring(i, j);
                if (test.length() > len) {
                    System.out.println(test);
                    String reverseStr = new StringBuilder(test).reverse().toString();
                    if (test.equals(reverseStr)) {
                        if (test.length() > len) {
                            res = test;
                        }
                        len = Math.max(test.length(), len);
                    }
                }
            }
        }

        System.out.println("Result " + res + "\n length : " + len);
        return len;
    }
}
