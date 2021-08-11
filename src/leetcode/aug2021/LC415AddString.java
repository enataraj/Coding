package leetcode.aug2021;

public class LC415AddString {

    public String addStrings(String num1, String num2) {

        StringBuffer result = new StringBuffer();
        int a;
        int b;
        int carry = 0;

        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;

        while (length1 >= 0 || length2 >= 0) {

            if (length1 >= 0) {
                a = num1.charAt(length1) - '0';
            } else {
                a = 0;
            }
            if (length2 >= 0) {
                b = num2.charAt(length2) - '0';
            } else {
                b = 0;
            }
            int sum = a + b + carry;
            System.out.println(sum);
            if (sum > 9) {
                result.append(sum % 10);
                carry = sum / 10;
            } else {
                result.append(sum);
                carry = 0;
            }
            length1--;
            length2--;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuffer result = new StringBuffer();
            int a, b, carry = 0;
            int length1 = num1.length() - 1;
            int length2 = num2.length() - 1;
            while (length1 >= 0 || length2 >= 0) {
                a = length1 >= 0 ? num1.charAt(length1) - '0' : 0;
                b = length2 >= 0 ? num2.charAt(length2) - '0' : 0;
                int sum = a + b + carry;
                if (sum > 9) {
                    result.append(sum % 10);
                    carry = sum / 10;
                } else {
                    result.append(sum);
                    carry = 0;
                }
                length1--;
                length2--;
            }
            if (carry != 0) {
                result.append(carry);
            }
            return result.reverse().toString();
        }
    }

    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "77";
        LC415AddString obj = new LC415AddString();
        System.out.println(obj.addStrings(num1, num2));
    }

}
