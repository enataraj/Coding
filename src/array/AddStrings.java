package array;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        if (num1 == null && num2 == null) {
            return "";
        }

        if (num1 == null) {
            return num2;
        }

        if (num2 == null) {
            return num1;
        }

        if (num1.length() < num2.length()) {
            return findSum(num2, num1);
        }

        return findSum(num1, num2);

    }

    private String findSum(String num1, String num2) {
        StringBuffer result = new StringBuffer();
        int lenDiff = Math.abs(num1.length() - num2.length());

        int a, b, carry = 0, sum = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            int secondIdx = i - lenDiff;

            a = num1.charAt(i) - 48;
            if (secondIdx >= 0) {
                b = num2.charAt(secondIdx) - 48;
            } else {
                b = 0;
            }

            sum = a + b + carry;
            carry = sum / 10;
            result.append(sum % 10);

        }
        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();

    }

    public String addStringsOpt(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int ind1 = num1.length() - 1;
        int ind2 = num2.length() - 1;
        int carry = 0;
        while (ind1 >= 0 || ind2 >= 0 || carry > 0) {
            int val1 = ind1 >= 0 ? num1.charAt(ind1) - '0' : 0;
            int val2 = ind2 >= 0 ? num2.charAt(ind2) - '0' : 0;
            int val = val1 + val2 + carry;
            sb.append((char) ((val % 10) + (int) '0'));
            carry = val / 10;
            ind1--;
            ind2--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings obj = new AddStrings();
        String num1 = "3456";
        String num2 = "34";
        System.out.println(obj.addStrings(num1, num2));
    }
}
