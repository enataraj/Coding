package leetcode.july2021;

public class LC639DecodeWaysII {

    public int numDecodings(String s) {

        long[] dp = new long[s.length() + 1];

        dp[0] = 1;
        dp[1] = decodeSingleChar(s.charAt(0));
        for (int i = 2; i <= s.length(); i++) {
            char preChar = s.charAt(i - 2);
            char curChar = s.charAt(i - 1);

            dp[i] += dp[i - 1] * decodeSingleChar(curChar);
            dp[i] += dp[i - 2] * decodeTwoChars(preChar, curChar);
            dp[i] = dp[i] % 1000000007;
        }
        return (int) dp[s.length()];

    }

    private int decodeSingleChar(char ch) {
        if (ch == '*') {
            return 9;
        }
        if (ch == '0') {
            return 0;
        }
        return 1;
    }

    private int decodeTwoChars(char firstChar, char secondChar) {
        if (firstChar == '*') {  // 11,12,13,14,15,16,17,18,19,21,22,23,24,25,26 --> 15
            if (secondChar == '*') {
                return 15;
            }

            if (secondChar >= '0' && secondChar <= '6') {  // 1 -[0-6] ,2-[0-6]  --> 2
                return 2;
            }
            return 1; 
        }

        if (firstChar == '1') {
            if (secondChar == '*') {
                return 9;

            }
            return 1;

        }

        if (firstChar == '2') {
            if (secondChar == '*') {
                return 6;

            }

            if (secondChar >= '0' && secondChar <= '6') {
                return 1;
            }
            return 0;

        }
        return 0;
    }

    public static void main(String[] args) {
        LC639DecodeWaysII obj = new LC639DecodeWaysII();
        String str = "1*";
        System.out.println(obj.numDecodings(str));
    }

}
