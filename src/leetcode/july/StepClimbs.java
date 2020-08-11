package leetcode.july;

public class StepClimbs {
    
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        
        int prev1 = 1,
            prev2 = 1,
            next = 0;
        
        for (int i = 2; i <= n; i++) {
            next = prev1 + prev2;
            prev2 = prev1;
            prev1 = next;
        }
        
        return prev1;
    }

}
