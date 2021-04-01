package recursion;

public class GenerateSubArray {

    public void printSubArray(int[] nums) {
        dfsHelpher(nums, 0, 0);

    }

    private void dfsHelpher(int[] nums, int start, int end) {
        if (end == nums.length)
            return;

        else if (start > end) {
            dfsHelpher(nums, 0, end + 1);
        } else {
            for (int i = start; i <= end; i++) {
                System.out.print(" " + nums[i]);
            }
            System.out.println();
            dfsHelpher(nums, start + 1, end);
        }
       
    }

    public static void main(String[] args) {
        GenerateSubArray obj = new GenerateSubArray();
        int[] nums = { 1, 2, 3, 4, 5 };
        obj.printSubArray(nums);
    }

}
