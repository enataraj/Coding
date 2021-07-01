package leetcode.weekly.week245;

import java.util.HashSet;
import java.util.Set;

public class LC1903LargestOddNumber {
    public String largestOddNumber(String num) {

        Set<Character> oddSet = new HashSet<>();
        oddSet.add('1');
        oddSet.add('3');
        oddSet.add('5');
        oddSet.add('7');
        oddSet.add('9');

        String restult = "";

        for (int i = num.length() - 1; i >= 0; i--) {
            if (oddSet.contains(num.charAt(i))) {
                restult = num.substring(0, i + 1);
                break;
            }
        }

        return restult;

    }
    
    public String largestOddNumberSol(String num) {
        for (int index = num.length() - 1; index >= 0; index--) {
            if ((num.charAt(index) - '0') % 2 == 1)
                return num.substring(0, index + 1);
        }
        return "";
    }

}
