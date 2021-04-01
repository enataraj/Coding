package leetcode.aug;

public class PowerOfFour {

    public boolean isPowerOfFour(int num) {

        if (num == 0)
            return false;

        if (num == 1)
            return true;

        while (num % 4 == 0) {
            num = num / 4;
            if (num == 1) {
                return true;
            }
        }

        return false;

    }

    public boolean isPowerOfFourOpt(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

    public boolean isPowerOfFourOptAlt(int num) {
        return ((num & (num - 1)) == 0) && ((num % 3) == 1);
    }

    public static void main(String[] args) {
        PowerOfFour obj = new PowerOfFour();
        System.out.println(obj.isPowerOfFour(64));

    }

}
