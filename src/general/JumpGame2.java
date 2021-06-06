package general;

public class JumpGame2 {
    
    
public int jump(int[] nums) {
        
        if (nums.length == 1) {

            return 0;

        }

        int jump = 0;
        int maxValue = 0;
        int maxReach = 0;
        int i = 0;
        while (i < nums.length) {
            if (maxReach == nums.length - 1) {
                break;
            }

            maxValue = Math.max(maxValue, i + nums[i]);
            if (i == maxReach) {
                maxReach = maxValue;
                jump++;
            }
            i++;

        }

        return jump;

    
    }

    public int jumpalt(int[] nums) {
        int cnt = 0;
        int i = 0;
        while (i < nums.length) {
            int max = 0;
            for (int j = i; j < i + nums[i]; j++) {
                max = Math.max(max, nums[j]);
            }
            i = max + i;
            if (i >= nums.length) {
                return cnt;
            }
            cnt++;
        }
        return cnt;
    }

}
