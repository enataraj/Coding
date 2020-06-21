package leetcode;

public class FindNumberWithEventNumberOfDigits {

    public int findNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int tmp = 0;
            while (temp > 0) {
                temp = temp / 10;
                tmp++;
            }

            if (tmp % 2 == 0) {
                count++;
            }

        }

        return count;

    }

    public int findNumbersStr(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] + "").length() % 2 == 0) {
                count++;
            }
        }

        return count;

    }
    
    public int findNumbersCool(int[] nums) {
        int even = 0;
        for(int x : nums) {
            if(10 <= x && x <= 99)
                even++;
            else if(1000 <= x && x <= 9999)
                even++;
            else if(x == 100000)
                even++;
        }
        return even;
    }

    public static void main(String[] args) {
        int nums[] = { 555, 901, 482, 1771 };
        FindNumberWithEventNumberOfDigits obj = new FindNumberWithEventNumberOfDigits();
        int result = obj.findNumbers(nums);
        System.out.println("Result : " + result);
    }

}
