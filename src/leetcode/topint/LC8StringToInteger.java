package leetcode.topint;

public class LC8StringToInteger {
    public int myAtoi(String s) {
        StringBuffer buffer = new StringBuffer();
        int sign = 1;
        for (char ch : s.toCharArray()) {
            if (buffer.length() == 0 && ch == '-') {
                sign = -1;
            }
            if (ch >= '0' && ch <= '9') {
                buffer.append(ch);
            } else if (buffer.length() == 0 && ch != '-') {
                return 0;

            } else if (buffer.length() != 0) {
                break;
            }
        }
        if (buffer.length() == 0) {
            return 0;
        }
        long tmp = Long.parseLong(buffer.toString()) * sign;
        if (tmp < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (tmp > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) tmp;
        }

    }

    public int myAtoiSol(String str) {
        int i = 0;
        int sign = 1;
        int result = 0;
        if (str.length() == 0)
            return 0;

        //Discard whitespaces in the beginning
        while (i < str.length() && str.charAt(i) == ' ')
            i++;

        // Check if optional sign if it exists
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            sign = (str.charAt(i++) == '-') ? -1 : 1;

        // Build the result and check for overflow/underflow condition
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(i++) - '0');
        }
        return result * sign;

    }

    public static void main(String[] args) {
        LC8StringToInteger obj = new LC8StringToInteger();
        System.out.println(obj.myAtoi("4193 with words"));
        System.out.println(obj.myAtoi("-91283472332"));
        System.out.println(obj.myAtoi("words and 987"));

    }

}
