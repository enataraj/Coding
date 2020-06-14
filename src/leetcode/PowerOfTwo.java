package leetcode;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }

        while (n > 1) {
            if (n % 2 != 0)
                return false;

            n = n / 2;

        }
        System.out.println(n);
        return n == 1;

    }

    public boolean isPowerOfTwo_opt(int n) {

        if (n <= 0) {
            return false;
        }

        while (n % 2 != 1) {
            n = n / 2;
        }
        System.out.println(n);
        return n == 1;

    }
    
    // bit wise
    
    public boolean isPowerOfTwo_bitwise(int n) {
        return n > 0 && ((n & (n-1)) == 0);
    }

    public static void main(String[] args) {
        // for (int i = 0; i < 25; i++) {
        int n = 12;
        boolean result = new PowerOfTwo().isPowerOfTwo(n);
        System.out.println(n + " is Power of Two : " + result);
        // }

    }

}
