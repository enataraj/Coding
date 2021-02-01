package leetcode.jan;

public class LC1437CheckKPlaceAway {
    public boolean kLengthApart(int[] nums, int k) {
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (idx != -1 && (i - idx) <= k) {
                    return false;
                }
                idx = i;
            }

        }
        return true;

    }
    
    public boolean kLengthApartParin(int[] nums, int k) {
        int lastPos = -1,
            n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (lastPos >= 0 && i - lastPos - 1 < k) {
                    return false;
                }
                lastPos = i;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        LC1437CheckKPlaceAway obj = new LC1437CheckKPlaceAway();
        int[] nums = {1,1,0,1};
        int k = 1;
        System.out.println(obj.kLengthApart(nums, k));

    }

}
