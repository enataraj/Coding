package leetcode.weekly.week251;

public class TransformWord {

    public int getLucky(String s, int k) {
        int resultNum = 0;
        for (char ch : s.toCharArray()) {
            int num = ch - 'a' + 1;
            resultNum += getSum(num);
           
        }
        System.out.println(resultNum);
        for (int i = 0; i < k - 1; i++) {
            resultNum = getSum(resultNum);
        }
        return resultNum;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int getLuckyBF(String s, int k) {
        StringBuffer buffer = new StringBuffer();
        for (char ch : s.toCharArray()) {
            int num = ch - 'a' + 1;
            buffer.append(num);
        }

        for (int i = 0; i < k; i++) {
            long res = 0;
            if (buffer.length() == 1) {
                break;
            }
            for (char ch : buffer.toString().toCharArray()) {
                res += ch - '0';
            }
            buffer = new StringBuffer();
            buffer.append(res);
        }
        return Integer.parseInt(buffer.toString());
    }

    public static void main(String[] args) {
        TransformWord obj = new TransformWord();
        System.out.println(obj.getLucky("leetcode", 2));
    }

}
