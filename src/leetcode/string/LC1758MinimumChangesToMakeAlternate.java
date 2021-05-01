package leetcode.string;

public class LC1758MinimumChangesToMakeAlternate {

    public int minOperations(String s) {

        boolean flag = true;
        int oneCnt = 0;
        int zeroCnt = 0;

        for (char ch : s.toCharArray()) {
            if (flag) {
                if (ch != '1') {
                    oneCnt++;
                }
                if (ch != '0') {
                    zeroCnt++;
                }
                flag = false;
            } else {

                if (ch != '1') {
                    zeroCnt++;
                }
                if (ch != '0') {
                    oneCnt++;
                }
                flag = true;

            }

        }
        return Math.min(oneCnt, zeroCnt);
    }

    public int minOperationsSol(String s) {
        int a = 0; // 0 comes first
        int b = 0; // 1 comes first

        char swapper = '0';

        for (char ch : s.toCharArray()) {
            if (ch != swapper) {
                a++;
            } else {
                b++;
            }
            swapper = swapper == '0' ? '1' : '0';
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        LC1758MinimumChangesToMakeAlternate obj = new LC1758MinimumChangesToMakeAlternate();
        String str = "1001";
        System.out.println(obj.minOperations(str));

    }

}
