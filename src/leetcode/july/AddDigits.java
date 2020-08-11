package leetcode.july;

public class AddDigits {

    public int addDigitsOpt(int num) {
        if (num <= 9) {
            return num;
        }

        return 1 + ((num - 1) % 9);

    }

    public int addDigits(int num) {
        if (num <= 9) {
            return num;
        }

        int res = 0;
        while (num > 9) {
            res = 0;
            while (num > 0) {
                res = res + (num % 10);
                num = num / 10;
            }
            num = res;

        }

        return res;
    }

    public static void main(String[] args) {
        AddDigits obj = new AddDigits();
        System.out.println(obj.addDigits(3818));
        System.out.println(obj.addDigitsOpt(3818));

    }

}
