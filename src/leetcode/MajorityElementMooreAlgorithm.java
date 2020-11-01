package leetcode;

public class MajorityElementMooreAlgorithm {

    public int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int candidate = nums[0];
        int count = 1;
        
        /*
         * This algorithm will work if and only if it should have one majority element
         * 
         * Candidate and new number matches , increment the count , if not decrement the count
         * 
         * if count is matched to zero, reset your candidate.
         * 
         * Finally which one stays in candidate is your answer.
         * 
         */

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {

                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count++;
                }
            }
        }
        
     

        return candidate;

    }

    public static void main(String[] args) {
        MajorityElementMooreAlgorithm obj = new MajorityElementMooreAlgorithm();
        int[] nums = { 2, 2, 1, 1, 1,1, 3, 4 };
        System.out.println(obj.majorityElement(nums));

    }
}
