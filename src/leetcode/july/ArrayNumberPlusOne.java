package leetcode.july;

import java.util.Arrays;

public class ArrayNumberPlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }

        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) {
                    flag = true;
                }

            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        if (flag) {
            int[] tmp = new int[digits.length + 1];
            tmp[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                tmp[i + 1] = digits[i];
            }

            return tmp;
        }

        return digits;

    }
    
    public int[] plusOneOther(int[] digits) {
        int carry = 1;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        
        if (carry == 0) {
            return digits;
        }
        
        int[] res = new int[digits.length + 1];
        res[0] = carry;
        for (int i = 1; i <= digits.length; i++) {
            res[i] = digits[i-1];
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayNumberPlusOne obj = new ArrayNumberPlusOne();
        int num[] = { 1, 2 };
        int res[] = obj.plusOne(num);
        System.out.println(Arrays.toString(res));
    }

}
