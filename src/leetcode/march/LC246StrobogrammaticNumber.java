package leetcode.march;

import java.util.HashMap;
import java.util.Map;

public class LC246StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {

        Map<Character, Character> strobogrammaticMap = new HashMap<Character, Character>();
        strobogrammaticMap.put('0', '0');
        strobogrammaticMap.put('1', '1');
        strobogrammaticMap.put('8', '8');
        strobogrammaticMap.put('6', '9');
        strobogrammaticMap.put('9', '6');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            if (num.charAt(left) != strobogrammaticMap.get(num.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        LC246StrobogrammaticNumber obj = new LC246StrobogrammaticNumber();
        System.out.println(obj.isStrobogrammatic("1"));
    }
}
