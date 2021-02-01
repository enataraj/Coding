package leetcode;

public class LC1663SmallestString {

    public String getSmallestString(int n, int k) {

        int max = 26;
        int numOfZ = 0;
        // Finding possible Z's can fill from last considering the space availability.
        while (k > max && n <= (k - max)) {
            n = n - 1;
            k = k - max;
            numOfZ++;
        }

        // Rest of the places we can fill 'a' s from left except one pos.
        int noOfA = n - 1;

        // Find the char for that one position

        int otherChar = k - noOfA;
        char otherCh = (char) (97 + otherChar - 1);

        // Build the whole result
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < noOfA; i++) {
            strBuffer.append('a');
        }
        strBuffer.append(otherCh);

        for (int i = 0; i < numOfZ; i++) {
            strBuffer.append('z');
        }
        return strBuffer.toString();
    }

    public String getSmallestStringSol(int n, int k) {
        int z = (k - n) / 25;
        int a = k - z * 26;
        if (a > n - z) {
            a = n - z - 1;
        }
        int m = k - z * 26 - a;

        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < a; i++) {
            strBuffer.append('a');
        }
        if (m > 0) {
            strBuffer.append((char) ('a' + m - 1));
        }

        for (int i = 0; i < z; i++) {
            strBuffer.append('z');
        }
        return strBuffer.toString();

    }

    public static void main(String[] args) {
        LC1663SmallestString obj = new LC1663SmallestString();
        int n = 5;
        int k = 31;
        System.out.println(obj.getSmallestString(n, k));
    }

}
