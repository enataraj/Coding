package leetcode.topint;

public class LC242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
       int[] countMap = new int[26];
        for(int i=0;i<s.length();i++){
            countMap[s.charAt(i)-'a']++;  // charAt is taking more time, convert into char array
            countMap[t.charAt(i)-'a']--;
        }
         
        for(int i=0;i<26;i++){
            if(countMap[i]!=0){
                return false;
            }
        }
        return true;
    }

}
