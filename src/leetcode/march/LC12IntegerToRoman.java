package leetcode.march;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC12IntegerToRoman {
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(2, "II");
        romanMap.put(3, "III");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(6, "VI");
        romanMap.put(7, "VII");
        romanMap.put(8, "VIII");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(11, "XI");
        romanMap.put(20, "XX");
        romanMap.put(30, "XXX");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(60, "LX");
        romanMap.put(70, "LXX");
        romanMap.put(80, "LXXX");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(200, "CC");
        romanMap.put(300, "CCC");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(600, "DC");
        romanMap.put(700, "DCC");
        romanMap.put(800, "DCCC");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");
        romanMap.put(2000, "MM");
        romanMap.put(3000, "MMM");

        StringBuffer result = new StringBuffer();
        List<String> resList = new ArrayList<>();

        int product = 1;
        while (num > 0) {
            product = product * 10;
            int tmp = num % product;
            num -= tmp;
            if (romanMap.containsKey(tmp)) {
                resList.add(romanMap.get(tmp));
            }
        }

        for (int i = resList.size() - 1; i >= 0; i--) {
            result.append(resList.get(i));
        }
        return result.toString();

    }

    public String intToRomanSol(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num = num - values[i];
                result.append(romanSymbols[i]);
            }
        }
        return result.toString();
    }

    public String intToRomanParin(int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            if (num >= 1000) {
                sb.append("M");
                num -= 1000;

            } else if (num >= 900) {
                sb.append("CM");
                num -= 900;

            } else if (num >= 500) {
                sb.append("D");
                num -= 500;

            } else if (num >= 400) {
                sb.append("CD");
                num -= 400;

            } else if (num >= 100) {
                sb.append("C");
                num -= 100;

            } else if (num >= 90) {
                sb.append("XC");
                num -= 90;

            } else if (num >= 50) {
                sb.append("L");
                num -= 50;

            } else if (num >= 40) {
                sb.append("XL");
                num -= 40;

            } else if (num >= 10) {
                sb.append("X");
                num -= 10;

            } else if (num >= 9) {
                sb.append("IX");
                num -= 9;

            } else if (num >= 5) {
                sb.append("V");
                num -= 5;

            } else if (num >= 4) {
                sb.append("IV");
                num -= 4;

            } else if (num >= 1) {
                sb.append("I");
                num -= 1;

            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LC12IntegerToRoman obj = new LC12IntegerToRoman();
        System.out.println(obj.intToRoman(1994));
    }

}
