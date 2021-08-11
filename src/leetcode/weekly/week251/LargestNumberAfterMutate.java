package leetcode.weekly.week251;

public class LargestNumberAfterMutate {

    public String maximumNumber(String num, int[] change) {
        char[] numArray = num.toCharArray();
        boolean flag = false;
        for (int i = 0; i < numArray.length; i++) {
            int curNum = numArray[i] - '0';
            System.out.println(curNum);
            if (curNum <= change[curNum]) {
                char c = (char) (change[curNum] + '0');
                numArray[i] = c;
                if(!flag && curNum == change[curNum]) {
                    continue;
                }
                flag = true;

            } else if (flag) {
                break;
            }
        }
        return new String(numArray);
    }

    public static void main(String[] args) {
        LargestNumberAfterMutate obj = new LargestNumberAfterMutate();
        // int[] change = { 9, 4, 3, 5, 7, 2, 1, 9, 0, 6 };
        // String num = "021";

        String num = "334111";
        int[] change = { 0,9,2,3,3,2,5,5,5,5 };

        System.out.println(obj.maximumNumber(num, change));
    }

}
