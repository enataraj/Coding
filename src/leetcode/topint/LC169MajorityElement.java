package leetcode.topint;

public class LC169MajorityElement {

    // Moores Voting Algorithm
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    candidate = nums[i];
                    cnt++;
                }
            }

        }
        return candidate;
    }

}
