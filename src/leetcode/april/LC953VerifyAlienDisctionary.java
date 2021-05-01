package leetcode.april;

import java.util.HashMap;
import java.util.Map;

public class LC953VerifyAlienDisctionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for (char ch : order.toCharArray()) {
            map.put(ch, idx);
            idx++;

        }

        String prevWord = words[0];
        String currentWord;
        for (int i = 1; i < words.length; i++) {
            currentWord = words[i];
            int curIdx = 0;
            while (prevWord.length() - 1 >= curIdx && currentWord.length() - 1 >= curIdx
                    && prevWord.charAt(curIdx) == currentWord.charAt(curIdx)) {
                curIdx++;
            }
            
            if(prevWord.length() > curIdx&& currentWord.length() == curIdx) {
                return false;
            }

            if (prevWord.length() - 1 >= curIdx && currentWord.length() - 1 >= curIdx
                    && map.get(prevWord.charAt(curIdx)) > map.get(currentWord.charAt(curIdx))) {
                return false;

            }
            
            
            prevWord = currentWord;
        }
        return true;
    }
    
    
    public boolean isAlienSortedSol(String[] words, String order) {
        int [] rank = new int[order.length()];
        for(int i = 0; i < order.length(); i++)
            rank[order.charAt(i)-'a'] = i;
        
        for(int i = 0; i < words.length-1; i++){
            for(int c_idx = 0; c_idx < words[i].length(); c_idx++){
                if(c_idx >= words[i+1].length()) 
                    return false;
                
                if(rank[words[i].charAt(c_idx)-'a'] > rank[words[i+1].charAt(c_idx)-'a'])
                    return false;
                else if(rank[words[i].charAt(c_idx)-'a'] < rank[words[i+1].charAt(c_idx)-'a'])
                    break;
            }
            
        }
        
        return true;
    }
    
public boolean isAlienSortedSol_M(String[] words, String order) {
        
        if(words.length == 1){
            return true;
        }
        
        for(int i = 1; i < words.length; i++){
            if(!isSorted(words[i-1], words[i], order)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isSorted(String first, String second, String order){
        if(first == null || second == null || first.length() == 0 || second.length() == 0){
            return false;
        }
        
        
        int minLen = Math.min(first.length(), second.length());
        
        for(int i = 0; i < minLen; i++){
            char firstWordCh = first.charAt(i);
            char secondWordCh = second.charAt(i);
            
            if(firstWordCh != secondWordCh){
                int firstChIdx = order.indexOf(firstWordCh);
                int secondChIdx = order.indexOf(secondWordCh);
                
                if(firstChIdx < 0 || secondChIdx < 0){
                    return false;
                }
                
                if(secondChIdx < firstChIdx){
                    return false;
                }
                
                return true;
            }
        }
        
        if(second.length() < first.length()){
            return false;
        }
        
        return true;
        
    }

    
    public static void main(String[] args) {
        LC953VerifyAlienDisctionary obj = new LC953VerifyAlienDisctionary();
        String[] words = {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(obj.isAlienSorted(words, order));
        
    }

}
