package leetcode;

public class UglyNumber1 {

    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }

        while (num % 2 == 0) {
            num = num / 2;
        }

        while (num % 3 == 0) {
            num = num / 3;
        }

        while (num % 5 == 0) {
            num = num / 5;
        }
        if (num == 1) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {

        UglyNumber1 obj = new UglyNumber1();
        int num = 10;
        boolean result = obj.isUgly(num);
        System.out.println(result);

    }

}
