package leetcode.weekly.week255;

public class FindDifferentBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        boolean[] numArray = new boolean[nums.length + 1];
        for (String str : nums) {
            int num = Integer.parseInt(str, 2);
            if (num <= nums.length) {
                numArray[num] = true;
            }
        }

        String tmpResult = "";

        for (int i = 0; i <= nums.length; i++) {
            if (!numArray[i]) {
                tmpResult = Integer.toBinaryString(i);
                break;

            }
        }

        if (tmpResult.isEmpty()) {

            tmpResult = Integer.toBinaryString(nums.length + 1);
        }

        int lenDiff = nums[0].length() - tmpResult.length();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < lenDiff; i++) {
            buffer.append("0");
        }
        buffer.append(tmpResult);
        return buffer.toString();
    }
    
    public String findDifferentBinaryStringSol(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            char me = nums[i].charAt(i) == '0' ? '1' : '0';
            ans.append(me);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        FindDifferentBinaryString obj = new FindDifferentBinaryString();
        String[] nums = { "111", "000" };
        System.out.println(obj.findDifferentBinaryString(nums));
    }
}
