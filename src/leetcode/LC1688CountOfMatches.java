package leetcode;

public class LC1688CountOfMatches {
    public int numberOfMatches(int n) {
        int matches = 0;
        while (n > 1) {
            matches += n / 2;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (n / 2) + 1;
            }

        }
        return matches;
    }

    public int numberOfMatchesRecursive(int n) {
        if (n == 1)
            return 0;
        if (n % 2 == 0) {
            return n / 2 + numberOfMatches(n / 2);
        }

        return n / 2 + (numberOfMatches(n / 2 + 1));

    }

    public static void main(String[] args) {
        LC1688CountOfMatches obj = new LC1688CountOfMatches();
        int n = 14;
        System.out.println(obj.numberOfMatches(n));
    }

}
