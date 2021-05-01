package leetcode.weekly;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Weekly {

    class Solution {
        public boolean squareIsWhite(String coordinates) {

            int row = coordinates.charAt(0) - 'a';
            int col = Integer.parseInt(coordinates.charAt(1) + "");
            if (col % 2 == 0 && row % 2 == 0) {
                return true;
            }

            if (col % 2 == 1 && row % 2 == 1) {
                return true;
            }

            return false;

        }
    }

    //5706. Sentence Similarity III

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() < sentence2.length()) {
            String tmp = sentence1;
            sentence1 = sentence2;
            sentence2 = tmp;

        }
        Map<String, Integer> map1 = new LinkedHashMap<>();

        String[] sent1 = sentence1.split(" ");
        String[] sent2 = sentence2.split(" ");
        for (int i = 0; i < sent1.length; i++) {
            map1.put(sent1[i], i);
        }

        for (int i = 0; i < sent2.length; i++) {
            if (map1.containsKey(sent2[i])) {
                map1.remove(sent2[i]);

            }
        }

        if (map1.isEmpty()) {
            return true;
        }

        boolean flag = true;
        int pre = 0;
        for (int key : map1.values()) {
            if (flag) {
                pre = key;
                flag = false;
            } else {
                if (key == pre + 1) {
                    pre = key;
                } else {
                    return false;
                }
            }

        }

        if ((sent1.length == sent2.length) && !map1.isEmpty()) {
            return false;
        }
        return true;

    }

    // 5708. Count Nice Pairs in an Array

    // 5707. Maximum Number of Groups Getting Fresh Donuts

    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = num % 10;
            num = num / 10;
        }
        return rev;

    }

    public int countNicePairs(int[] nums) {

        Map<Integer, Integer> reverseNum = new HashMap<>();
        
        for (int num : nums) {
            int rev = reverse(num);
            reverseNum.put(num, rev);
            reverseNum.put(rev, num);

        }

        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + reverseNum.get(nums[j]) == nums[j] + reverseNum.get(nums[i])) {
                    result++;
                    break;
                }
            }
        }

        return (int) result % 1000000009;
    }

    public static void main(String[] args) {
        Weekly obj = new Weekly();
        String sentence1 = "of";
        String sentence2 = "A lot of words";

        System.out.println(obj.areSentencesSimilar(sentence1, sentence2));

        int[] nums = { 42, 11, 1, 97 };
        System.out.println(obj.countNicePairs(nums));
    }
}
