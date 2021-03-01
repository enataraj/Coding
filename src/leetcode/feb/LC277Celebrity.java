package leetcode.feb;

public class LC277Celebrity {
    
    public int findCelebrity(int n) {
        int cand = 0;
        
        for (int i = 0; i < n; i++) {
            if (knows(cand, i)) {
                cand = i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!knows(i, cand) || (i != cand && knows(cand, i))) {
                return -1;
            }
        }
        
        return cand;
    }
    
    private boolean knows(int i,int j) {
        return true;
    }

}
