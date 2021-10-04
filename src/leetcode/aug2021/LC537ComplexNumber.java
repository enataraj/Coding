package leetcode.aug2021;

public class LC537ComplexNumber {

    public String complexNumberMultiply(String num1, String num2) {
        String[] num1Array = num1.split("\\+");
        String[] num2Array = num2.split("\\+");
        int a = Integer.parseInt(num1Array[0]);
        int b = Integer.parseInt(num1Array[1].replace("i", ""));
        int c = Integer.parseInt(num2Array[0]);
        int d = Integer.parseInt(num2Array[1].replace("i", ""));
        int res1 = (a * c) + (b * d * -1);
        int res2 = (a * d) + (b * c);
        return String.valueOf(res1) + "+" + String.valueOf(res2) + "i";

    }

    public static void main(String[] args) {
        LC537ComplexNumber obj = new LC537ComplexNumber();
        String num1 = "1+1i";
        String num2 = "1+1i";
        System.out.println(obj.complexNumberMultiply(num1, num2));
    }
}

