package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LC1624LargestSubstring {

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int result = -1;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                result = Math.max(result,i-map.get(s.charAt(i))-1);
            }else{
                map.put(s.charAt(i),i);
            }
        }
        return result;
    }

    public int maxLengthBetweenEqualCharactersSol(String s) {
        int[] indices = new int[26];
        int maxLen = -1;
        for (int i = 0; i < s.length(); ++i) {
            int idx = s.charAt(i) - 'a';
            if (indices[idx] > 0) {
                maxLen = Math.max(maxLen, i - indices[idx]);
            } else {
                indices[idx] = i + 1;
            }
        }
        return maxLen;
    }

}
