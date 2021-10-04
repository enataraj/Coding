package leetcode.sep2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfEquivalentDomino {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] arr = new int[10][10];
        int count=0;
        for(int[] i:dominoes){
            int a = i[0];
            int b = i[1];
            count+=arr[a][b];
            if(a!=b)
                count+=arr[b][a];
            arr[b][a]++;
        }
        return count;
    }
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            int cnt =0;
            Map<String,Integer> map = new HashMap<>();
            for(int[] domino : dominoes){
                Arrays.sort(domino);
                String key =domino[0]+"#"+domino[1];
                if(map.containsKey(key)){
                    cnt+=map.get(key);
                    map.put(key,map.get(key)+1);
                }else{
                     map.put(key,1);
                }
            }
            return cnt;
        }
    }
}
