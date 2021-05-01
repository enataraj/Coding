package leetcode.topint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC412FizzBizz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        int fizz = 3;
        int buzz = 5;
        for (int i = 1; i <= n; i++) {
            if (i == fizz && i == buzz) {
                result.add("FizzBuzz");
                fizz = fizz + 3;
                buzz = buzz + 5;
            } else if (i == fizz) {
                result.add("Fizz");
                fizz = fizz + 3;
            } else if (i == buzz) {
                result.add("Buzz");
                buzz = buzz + 5;
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;

    }

    public List<String> fizzBuzzSol2(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i)); // result.add(""+i) --> this increase time 4 ms

            }
        }
        return result;
    }

    public List<String> fizzBuzzSol(int n) {

        // ans list
        List<String> ans = new ArrayList<String>();

        // Hash map to store all fizzbuzz mappings.
        HashMap<Integer, String> fizzBizzDict = new HashMap<Integer, String>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };

        for (int num = 1; num <= n; num++) {

            String numAnsStr = "";

            for (Integer key : fizzBizzDict.keySet()) {

                // If the num is divisible by key,
                // then add the corresponding string mapping to current numAnsStr
                if (num % key == 0) {
                    numAnsStr += fizzBizzDict.get(key);
                }
            }

            if (numAnsStr.equals("")) {
                // Not divisible by 3 or 5, add the number
                numAnsStr += Integer.toString(num);
            }

            // Append the current answer str to the ans list
            ans.add(numAnsStr);
        }

        return ans;
    }

}
