package leetcode.sep2021;

import java.util.Arrays;

public class ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {

        if (word.indexOf(ch) != -1) {
            int idx = word.indexOf(ch);
            char[] chArray = word.toCharArray();
            int left = 0;
            int right = idx;
            while (left <= right) {
                char tmp = chArray[left];
                chArray[left] = chArray[right];
                chArray[right] = tmp;
                left++;
                right--;
            }
            return new String(chArray);

        }
        return word;

    }

  
  
}
