package leetcode.topint;

public class LC326PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        int pow = 1;
        for (int i = 1; i < n; i++) {
            pow = pow * 3;
            if (pow > n)
                return false;
            if (pow == n) {
                return true;
            }
        }
        return false;
    }

    public boolean isPowerOfThreeSol(int n) {
        while (n > 0 && n % 3 == 0) {
            n = n / 3;
        }
        return n == 1 ? true : false;
    }

    public boolean isPowerOfThreeMath(int n) {
        double x = Math.log10(n) / Math.log10(3.0);
        if (x - Math.floor(x) == 0)
            return true;
        return false;
    }

    public boolean isPowerOfThreeBadPerf(int n) {

        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        int pow = 1;
        for (int i = 1; i < n; i++) {
            pow = pow * 3;
            if (pow > n)
                return false;
            if (pow == n) {
                return true;
            }
        }
        return false;

    }

    public boolean isPowerOfThree1(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 9 == 0) {
            n /= 9;
        }
        return (n == 1 || n == 3);
    }

    public boolean isPowerOfThree2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public boolean isPowerOfThree4(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree5(int n) {
        for (int i = 0; i < 31; i++) {
            if (Math.pow(3, i) == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC326PowerOfThree obj = new LC326PowerOfThree();
        System.out.println(obj.isPowerOfThree(27));
    }

}
