package leetcode.july;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        if (x == y) {
            return 0;
        }
        int dis = 0;
        String xStr = String.format("%32s", Integer.toBinaryString(x)).replaceAll(" ", "0");
        String yStr = String.format("%32s", Integer.toBinaryString(y)).replaceAll(" ", "0");
        // System.out.println(xStr);
        // System.out.println(yStr);

        for (int i = 0; i < 32; i++) {
            if (xStr.charAt(i) != yStr.charAt(i)) {
                dis++;
            }
        }

        return dis;

    }

    public int hammingDistanceEfficient(int x, int y) {
        int count = 0;
        if (x == y) {
            return count;
        }
        while (x != 0 && y != 0) {
            int xbit = (1 & x);
            int ybit = (1 & y);
            if (xbit != ybit) {
                count++;
            }
            x = x >> 1;
            y = y >> 1;
        }
        while (x != 0) {
            int xbit = (1 & x);
            if (xbit != 0) {
                count++;
            }
            x = x >> 1;
        }
        while (y != 0) {
            int ybit = (1 & y);
            if (ybit != 0) {
                count++;
            }
            y = y >> 1;
        }

        return count;

    }

    public int hammingDistanceSimpler(int x, int y) {
        int count = 0; // count = 0

        while (x != 0 || y != 0) {
            count += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>= 1;
        }

        return count;
    }

    public int hammingDistanceAnother(int x, int y) {
        int count = 0; // count = 0

        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                count++;
            }

            x >>= 1;
            y >>= 1;
        }

        return count;
    }

    public int hammingDistanceAnotherOne(int x, int y) {
        int count = 0; // count = 0
        int xor = x ^ y;
        System.out.println(xor);

        while (xor != 0) {
            if ((xor & 1) == 1) {
                count++;

            }
            xor >>= 1;
        }

        return count;
    }

    public static void main(String[] args) {
        HammingDistance obj = new HammingDistance();
        int x = 1, y = 4;
        int result = obj.hammingDistanceAnotherOne(x, y);
        System.out.println(result);

    }

}
