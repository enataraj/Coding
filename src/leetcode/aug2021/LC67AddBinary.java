package leetcode.aug2021;

public class LC67AddBinary {

    private static int BASE = 2;

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int sum = 0;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            sum = carry;

            if (i >= 0)
                sum += a.charAt(i--) - '0';
            if (j >= 0)
                sum += b.charAt(j--) - '0';

            carry = sum / BASE;
            sb.append(sum % BASE);
        }

        if (carry != 0)
            sb.append(carry);

        return sb.reverse().toString();
    }

}
