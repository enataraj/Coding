package leetcode.string;

public class LC1784MostOneSegments {
    
        public boolean checkOnesSegmentSol(String s) {
            char prev = '1';
            int cnt = 1;
            for(int i = 1; i < s.length(); i++) {
                if(prev == '0' && s.charAt(i) == '1'){
                    cnt++;
                }
                prev = s.charAt(i);
    
                if(cnt > 1){
                    return false;
                }
            }
    
            return true;
        }

   

}
