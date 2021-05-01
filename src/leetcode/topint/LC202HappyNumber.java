package leetcode.topint;

import java.util.HashSet;
import java.util.Set;

public class LC202HappyNumber {
    
    
    // Fast and Slow Pointer Approach
    
    private int next(int n){
        int sum = 0;
        while(n != 0){
            sum = sum + (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
    public boolean isHappySol(int n) {
        int slow = n;
        int fast = next(n); 
        while(slow != fast){
            slow = next(slow);
            fast = next(next(fast));
        }
        if(slow == 1){
            return true;
        }
        return false;
    }
    
    

    public boolean isHappy(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        Set<Integer> resultSet = new HashSet<>();
        while (true) {
            n = helper(n);
            //System.out.println(n);
            if (n == 1) {
                return true;
            } else if (resultSet.contains(n)) {
                return false;
            } else {
                resultSet.add(n);

            }
        }

    }

    private int helper(int n) {
        int sum = 0;

        while (n > 9) {
            int t = n % 10;
            n = n / 10;
            sum = sum + (t * t);
        }
        sum = sum + (n * n);

        return sum;

    }
    
    
    

}
