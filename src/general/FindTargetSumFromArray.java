package general;

public class FindTargetSumFromArray {

    public void findTargetSum(int[] nums, int targetSum) {
        dfsHelper(nums, 0, targetSum, 0, 0);

    }

    private void dfsHelper(int[] nums, int idx, int targetSum, int curSum, int cnt) {
        if (idx == nums.length) {
            if (targetSum == curSum) {
                System.out.println(cnt);

            }
            return;
        }
        
        if (targetSum == curSum) {
            System.out.println(cnt);
            
            return;
        }

        if(curSum>targetSum || curSum<0) {
            return;
        }
        if(idx<0) {
            return;
        }

        dfsHelper(nums, idx+1, targetSum, curSum , cnt);
        dfsHelper(nums, idx + 1, targetSum, curSum + nums[idx], cnt +1);

    }

    public static void main(String[] args) {
        FindTargetSumFromArray obj = new FindTargetSumFromArray();
        int[] nums = { 3, 2, 5, 7, 2, 4, 5, 8, 4 };
        int target = 10;
        obj.findTargetSum(nums, target);

    }

}
