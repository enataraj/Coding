package leetcode.feb;

import java.util.HashMap;
import java.util.Map;

public class LC13RomanToInteger {

    public int romanToInt(String s) {
        int res = 0;
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == 'I' && i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                res = res + 4;
                i = i + 2;

            } else if (ch == 'I' && i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                res = res + 9;
                i = i + 2;

            } else if (ch == 'X' && i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                res = res + 40;
                i = i + 2;

            } else if (ch == 'X' && i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                res = res + 90;
                i = i + 2;

            } else if (ch == 'C' && i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                res = res + 400;
                i = i + 2;

            } else if (ch == 'C' && i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                res = res + 900;
                i = i + 2;

            } else {
                res = res + map.get(ch);
                i = i + 1;
            }

            // System.out.println(res);
        }

        return res;

    }

    public int romanToIntSwit(String s) {
        int sum = 0;

        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            switch (ch) {
            case 'I':
                sum += sum >= 5 ? -1 : 1;
                break;
            case 'V':
                sum += 5;
                break;
            case 'X':
                sum += sum >= 50 ? -10 : 10;
                break;
            case 'L':
                sum += 50;
                break;
            case 'C':
                sum += sum >= 500 ? -100 : 100;
                break;
            case 'D':
                sum += 500;
                break;
            case 'M':
                sum += 1000;
                break;

            }
        }

        return sum;
    }

    public int romanToIntSwitch(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (i + 1 < s.length() && charToInt(ch) < charToInt(s.charAt(i + 1))) {
                sum = sum + charToInt(s.charAt(i + 1)) - charToInt(ch);
                i++;
            } else
                sum = sum + charToInt(ch);
        }
        return sum;
    }

    int charToInt(char c) {
        switch (c) {
        case 'I':
            return 1;
        case 'V':
            return 5;
        case 'X':
            return 10;
        case 'L':
            return 50;
        case 'C':
            return 100;
        case 'D':
            return 500;
        case 'M':
            return 1000;
        default:
            return 0;
        }
    }
    
    
    public int romanToIntSubtra(String s) {
        int nums[]=new int[s.length()];
    for(int i=0;i<s.length();i++){
        switch (s.charAt(i)){
            case 'M':
                nums[i]=1000;
                break;
            case 'D':
                nums[i]=500;
                break;
            case 'C':
                nums[i]=100;
                break;
            case 'L':
                nums[i]=50;
                break;
            case 'X' :
                nums[i]=10;
                break;
            case 'V':
                nums[i]=5;
                break;
            case 'I':
                nums[i]=1;
                break;
        }
    }
    int sum=0;
    for(int i=0;i<nums.length-1;i++){
        if(nums[i]<nums[i+1])
            sum-=nums[i];
        else
            sum+=nums[i];
    }
    return sum+nums[nums.length-1];
    }

    public static void main(String[] args) {
        LC13RomanToInteger obj = new LC13RomanToInteger();
        // String s = "MCMXCIV";
        System.out.println(obj.romanToInt("MMMMMMMMMMMMMMMM"));
    }
}
