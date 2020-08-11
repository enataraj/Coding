package XOR;

public class SingleDifferentNumber {

    public int findSingleDiffNumber(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res = res ^ num;
        }

        return res;

    }

    public static void main(String[] args) {
        SingleDifferentNumber obj = new SingleDifferentNumber();
        int nums[] = { 2, 3, 4, 5, 2, 4, 5 };
        System.out.println(obj.findSingleDiffNumber(nums));

    }

}
