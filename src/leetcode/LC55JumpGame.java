package leetcode;

public class LC55JumpGame {
    
    // From the given start position, You can make max till that value of the index. 
    // So you record where you can jump max, In between keep check each index if you can jump more than the previously recorded position.
    // If so record that position is max you can jump. If you can traverse till end of the array you can reach to max else come break it. 
    // At any time your current index is max than the jump you can make , then you can not jump at all.
    // https://www.youtube.com/watch?v=muDPTDrpS28

    public boolean canJump(int[] nums) {

        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reachable < i)
                return false;
            reachable = Math.max(reachable, i + nums[i]);
        }

        return true;

    }

    
    public boolean canJumpSol(int[] nums) {
        int lastPos = nums.length - 1;
       for (int i = nums.length - 1; i >= 0; i--) {
           if (i + nums[i] >= lastPos) {
               lastPos = i;
           }
       }
       return lastPos == 0;
   }
    
    
    public static void main(String[] args) {
        LC55JumpGame obj = new LC55JumpGame();
        int[] nums = {3,2,1,0,4 };
        System.out.println(obj.canJump(nums));
    }

}
